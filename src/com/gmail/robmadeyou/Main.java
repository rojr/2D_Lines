package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glClear;


import org.lwjgl.input.Cursor;
import org.lwjgl.input.Keyboard;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.gmail.robmadeyou.EnemyList.Enemies;


public class Main {
	
	private static long lastFrame;

    private static long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    private static int getDelta() {
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta;
    }
	
	public static class PlayerBar extends Player{
		public PlayerBar(int x, int y, int width, int height) {
			super(x, y, width, height);
		}
	}
	public static class BallMoving extends Ball{
		public BallMoving(int x, int y, int width, int height) {
			super(x, y, width, height);
		}
	}
	static PlayerBar p;
	static BallMoving b;
	static boolean applet = false;
	boolean loadedTex = false;
	
	public Main(){
		if(!applet){
			try {
				Display.setDisplayMode(new DisplayMode(1024,512));
				Display.setTitle("");
				Display.create();
				Display.setResizable(false);
			} catch (LWJGLException e) {
				e.printStackTrace();
			}
		}
		
		glEnable(GL_TEXTURE_2D);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho( 0, 1024, 512, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
	    glEnable(GL_BLEND);
	    glBlendFunc(GL_SRC_ALPHA , GL_ONE_MINUS_SRC_ALPHA);

		try {
			Cursor emptyCursor = new Cursor(1, 1, 0, 0, 1, BufferUtils.createIntBuffer(1), null);
			Mouse.setNativeCursor(emptyCursor);
		} catch (LWJGLException e1) {
			e1.printStackTrace();
		}
		for(int x = 0; x < 20; x++){
			for(int y = 0; y < 5; y++){
				EnemyList.addEnemy(new EnemyList.Enemies(x * 40, y * 40, 32, 32, "", 1));
			}
		}
		p = new PlayerBar((Display.getWidth() / 2) - 50, Display.getHeight() - 60, 100, 40);
		b = new BallMoving(p.getX() - p.getWidth() / 2, p.getY() - 16, 16, 16);
		while(!Display.isCloseRequested()){
			if(!loadedTex){
				Textures.loadTextures();
				System.out.println("Textures Loaded!");
				loadedTex = true;
			}
			int delta = getDelta();
			glClear(GL_COLOR_BUFFER_BIT);
			onUpdate(delta);
			p.onUpdate();
			b.onUpdate(delta);
			if(Input.keyPressed == Keyboard.KEY_D){
				Save.saveMap(EnemyList.enemy);
			}
			if(Input.keyPressed == Keyboard.KEY_S){
				Save.loadMap();
			}
			EnemyList.drawAll();
			EnemyList.checkIfInBounds();
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
		System.exit(1);
	}
	  
	public static void onUpdate(int delta){
		Input.checkInput();
		BuffList.onUpdate(delta);
	}
	public static void main(String[] args) {
		new Main();
		
	}
}
