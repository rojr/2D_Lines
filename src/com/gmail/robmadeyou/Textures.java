package com.gmail.robmadeyou;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Textures {
	
	public static Texture turretArrow1;
	
	public static void loadTextures(){
		
		try{
			System.out.println(System.getProperty("user.dir"));
			turretArrow1 = TextureLoader.getTexture("PNG", new FileInputStream(new File("C:\\Users\\Robert\\Desktop\\lwjgl_applet-2.8.5\\lwjgl_applet-2.8.5\\applet\\basic\\res\\towers\\ArrowTower.png")));
			
		}catch (IOException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
    	}
	}
}
