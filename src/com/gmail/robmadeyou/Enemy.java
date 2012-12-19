package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2i;
import static org.lwjgl.opengl.GL11.glColor3f;

import java.util.Random;

import org.newdawn.slick.opengl.Texture;

public class Enemy implements GUI {

	
	
	protected int x,y,w,h;
	protected int toughness;
	protected Texture tex;
	protected float r,g,b;
	protected String bonus;
	protected boolean isOnScreen;
	public Enemy(int x, int y, int w, int h, String bonus, int toughness){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.bonus = bonus;
		this.toughness = toughness;
		Random ranColour = new Random();
		this.r = ranColour.nextFloat();
		this.g = ranColour.nextFloat();
		this.b = ranColour.nextFloat();
	}
	@Override
	public void setLocation(int x, int y) {
		
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
		this.w = w;
	}

	@Override
	public void setH(int h) {
		this.h = h;
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
		return w;
	}

	@Override
	public int getHeight() {
		return h;
	}
	
	public void draw(){
		if(tex != null){
			tex.bind();
		}
		glBegin(GL_QUADS);
			glColor3f(r,g,b);
			glTexCoord2f(0,0);
			glVertex2i(x, y);
			glTexCoord2f(1,0);
			glVertex2i(x + w, y);
			glTexCoord2f(1,1);
			glVertex2i(x + w, y + h);
			glTexCoord2f(0,1);
			glVertex2i(x , y + h);
		glEnd();
		
	}

}
