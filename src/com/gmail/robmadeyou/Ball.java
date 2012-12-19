package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2i;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

public class Ball implements GUI {

	private int x, y, width, height;
	private Texture tex;
	private boolean active = false;
	private double dX, dY;
	private int lives = 4;
	public Ball(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void setW(int w) {
		this.width = width;
	}

	@Override
	public void setH(int h) {
		this.height = height;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	public double getDX(){
		return dX;
	}
	public double getDY(){
		return dY;
	}
	public void setDX(double dX){
		this.dX = dX;
	}
	public void setDY(double dY){
		this.dY = dY;
	}
	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
	public boolean isActive(){
		return active;
	}
	public void setActive(boolean active){
		this.active = active;
	}

	public void draw(){
		if(tex != null){
			tex.bind();
		}
		glBegin(GL_QUADS);
			glTexCoord2f(0,0);
			glVertex2i(x, y);
			glTexCoord2f(1,0);
			glVertex2i(x + width, y);
			glTexCoord2f(1,1);
			glVertex2i(x + width, y + height);
			glTexCoord2f(0,1);
			glVertex2i(x , y + height);
		glEnd();
		
	}
	public void onDeath(){
		if(lives >= 1){
			active = false;
		}else{
			System.exit(1);
		}
		lives--;
	}
	
	public void changeDirection(String direction){
		if(direction.equals("right")){
			dX = -dX;
		}else if(direction.equals("left")){
			dX = -dX;
		}else if(direction.equals("top")){
			dY = -dY;
		}else if(direction.equals("bottom")){
			dY = -dY;
		}
	}
	public void onUpdate(int delta){
		int pX = Main.p.getX();
		int pY = Main.p.getY();
		int pW = Main.p.getWidth();
		int pH = Main.p.getHeight();
		double cXP = pX + pW / 2;
		double cXB = x + width / 2;
		draw();
		if(!active){
			y = Display.getHeight() - 60 - 16;
			x = Main.p.getX() + Main.p.getWidth() / 2;
		}
		if(active){
			this.x += (int) (delta * dX);
			this.y += (int) (delta * dY);
			
			if(y <= 0){
				changeDirection("top");
			}
			if(x <= 0){
				changeDirection("left");
			}
			if(x >= Display.getWidth()){
				changeDirection("right");
			}
			
			boolean one = (x  + width / 2> pX && x + width / 2< pX + pW && y + height / 2> pY && y  + height / 2< pY + pH);
			if(one){
				changeDirection("bottom");
				dX = -(cXP - cXB) / 100;
				System.out.println(dX);
			}
			if(y > Display.getHeight()){
				onDeath();
			}
		}
	}
}
