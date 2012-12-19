package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2i;
import static org.lwjgl.opengl.GL11.glColor3f;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

public class Player implements GUI {

	
	private int x, y, width, height;
	private Texture tex = Textures.turretArrow1;
	private float r,g,b;
	private int bSize;
	public Player(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.r = 1F;
		this.g = 0F;
		this.b = 0F;
		this.bSize = 0;
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

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
	public void setColor(float r, float g, float b){
		this.r = r;
		this.g = g;
		this.b = b;
	}
	public void changeSize(boolean plus){
		if(plus && this.bSize <= 4){
			this.bSize++;
		}
		if(!plus && this.bSize >= -4){
			this.bSize--;
		}
		if(bSize == 5){
			
		}else if(bSize == 4){
			width = 140;
		}else if(bSize == 3){
			width = 130;
		}else if(bSize == 2){
			width = 120;
		}else if(bSize == 1){
			width = 110;
		}else if(bSize == 0){
			width = 100;
		}else if(bSize == -1){
			width = 90;
		}else if(bSize == -2){
			width = 80;
		}else if(bSize == -3){
			width = 70;
		}else if(bSize == -4){
			width = 60;
		}else if(bSize == -5){
			width = 50;
		}
	}
	public void draw(){
		if(tex != null){
			tex.bind();
			System.out.println("Binding textures");
		}
		glBegin(GL_QUADS);
			glColor3f(r,g,b);
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
	public void onUpdate(){
		draw();
		x = Mouse.getX() - width / 2;
		if(!Main.b.isActive() && Input.lmbp){
			System.out.println("cunt");
			Main.b.setDY(-0.3);
			Main.b.setActive(true);
		}
	}
}
