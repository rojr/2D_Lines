package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2i;

import java.util.Random;

import org.newdawn.slick.opengl.Texture;

public class Buff {
	
	private BuffType type;
	private int x, y, w, h;
	private Texture tex;
	private float r,g,b;
	private int effectGen;
	public Buff(BuffType type, int x, int y){
		this.x = x;
		this.y =y;
		this.w = 20;
		this.h = 20;
		this.type = type;
		this.tex = type.tex;
		r = 1;
		g = 1;
		b = 1;
		Random random = new Random();
		effectGen = 1+random.nextInt(5);
	}
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void doEffect(){
		if(effectGen == 1){
			Main.p.changeSize(true);
			r = 1;
			g = 0;
			b = 0;
		}else if(effectGen == 2){
			Main.p.changeSize(false);
		}else{
			Main.p.changeSize(false);
		}
	}
	public void onUpdate(int delta){
		y += (int) (delta * 0.2);
		if(effectGen == 1){
			r = 1;
			g = 0;
			b = 0;
		}
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
