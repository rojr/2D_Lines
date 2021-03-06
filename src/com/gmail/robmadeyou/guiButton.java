package com.gmail.robmadeyou;

import org.newdawn.slick.opengl.Texture;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;
import static org.lwjgl.opengl.GL11.glTexCoord2f;

import static org.lwjgl.opengl.GL11.GL_QUADS;


public class GuiButton implements GUI {

	private int x, y, w, h;
	private Texture tex;
	public GuiButton(int x, int y, int w, int h, Texture tex){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.tex = tex;
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
	
	public void onUpdate(){
		
	}
	
	public void draw(){
		if(tex != null){
			tex.bind();
		}
		glBegin(GL_QUADS);
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
