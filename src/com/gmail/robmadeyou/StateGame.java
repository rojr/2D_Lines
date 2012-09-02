package com.gmail.robmadeyou;

import org.lwjgl.input.Mouse;

public class StateGame {
	public static boolean areCreated = false;
	public static int level = 1;
	static int lives = 5;
	
	static int pointsOnScreen = 0;
	static int pointsAvailable = 0;
	static int pointSize = 40;
	
	static String pointColour = "white";
	
	
	static boolean levelLoaded = false;
	static boolean levelComplete = false;
	public static void onInit(){
		
		//Back button
		guiButton.button[10] = new guiButton.Button(0, 0, 40, 50, "GAME", "yellow", "white", "", false, false);
		//Lives button
		guiButton.button[11] = new guiButton.Button(640 - 60, 0, 50, 60, "GAME", "cyan", "red", "" , false , false);
		
		
		areCreated = true;
	}
	
	public static void level(){
		
		while(Mouse.next()){
			if(Mouse.isButtonDown(0)){
				if(Mouse.getEventButtonState()){
					if(pointsAvailable != 0){
						System.out.println("Yo, I'm clicked " + pointsOnScreen);
						
						Player.dots[pointsOnScreen] = new Player.Dots(Mouse.getX(), Mouse.getY(), pointSize, pointColour);
						pointsOnScreen += 1;
						pointsAvailable -= 1;
					}
				}
			}
		}
		
		if(level == 0){
			if(levelLoaded == false){
				pointsOnScreen = 0;
				pointsAvailable = 10;
				levelLoaded = true;
			}
			
			if(levelComplete){
				levelLoaded = false;
			}
		}
	}
	
	
	public static void Lives(){
		
		if(lives >= 5){
			guiButton.button[11].colour = "cyan";
		}else if(lives == 4){
			guiButton.button[11].colour = "blue";
		}else if(lives == 3){
			guiButton.button[11].colour = "green";
		}else if(lives == 2){
			guiButton.button[11].colour = "yellow";
		}else if(lives ==1){
			guiButton.button[11].colour = "red";
		}
	}
}
