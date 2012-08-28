package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glClear;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class Main {
	
	public Main(){
		
		try{
			Display.setDisplayMode(new DisplayMode(640,480));
			Display.setTitle("Weird ass game");
			Display.create();
		}catch(LWJGLException e){
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho( 0, 640, 480, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);

		while(!Display.isCloseRequested()){

			glClear(GL_COLOR_BUFFER_BIT);
			
			onUpdate();
			updateFPS();
			
			Display.update();
			Display.sync(60);
		}
	}
	  
	public static void onUpdate(){
		Game.onUpdate();
		Game.Render();
	}
	void updateFPS(){
		
	}
	public static void main(String[] args) {
		new Main();
		
	}
}
