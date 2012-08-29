package com.gmail.robmadeyou;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class Game {
	
	public static String state = "MAIN_MENU";
	/*
	 * Possible states are:
	 * MAIN_MENU
	 * OPTIONS
	 * CREDITS
	 * GAME
	 * LEVEL_SELECT
	 * LEVEL_EDITOR
	 */
	
	public static void Render(){
		
		if(state == "MAIN_MENU"){
			for(int i = 0; i < 128; i++){
				GUI.Draw(i, state);
			}
		}else if(state == "LEVEL_SELECT"){
			for(int i = 0; i < 128; i++){
				GUI.Draw(i, state);
			}
			for(int i = 0; i < 64; i++){
				GUI.Draw(i, state);
			}
		}else if(state == "OPTIONS"){
			for(int i = 0; i < 128; i++){
				GUI.Draw(i, state);
			}
		}else if(state == "CREDITS"){
			for(int i = 0; i < 128; i++){
				GUI.Draw(i, state);
			}
		}else if(state == "LEVEL_EDITOR"){
			for(int i = 0; i < 128; i++){
				GUI.Draw(i, state);
			}
		}
		
	}
	
	public static void onUpdate(){
		/*
		 * Runs the code once to load the buttons. Once loaded, they aren't touched anymore. Because of this we can now
		 * change the size of the boxes, make them bigger, smaller. what ever
		 */
		if(StateMenu.areCreated != true){
			StateMenu.onInit();
		}
		if(StateLevelSelect.areCreated != true){
			StateLevelSelect.onInit();
		}
		if(StateOptions.areCreated != true){
			StateOptions.onInit();
		}
		if(StateCredits.areCreated != true){
			StateCredits.onInit();
		}
		if(StateLevelEditor.areCreated != true){
			StateLevelEditor.onInit();
		}
		
		for(int i = 0; i < 128; i++){
			if(guiButton.button[i] != null && guiButton.button[i].area == "MAIN_MENU" && state == "MAIN_MENU"){
				guiButton.button[i].applyColour();
				guiButton.button[i].isMouseOver();
				guiButton.button[i].expand(0, -100);
				
				//Tests for different buttons, if pressed, state changes
				if(guiButton.button[0].isPressed()){
					System.out.println("LEVEL_SELECT");
					state = "LEVEL_SELECT";
				}
				if(guiButton.button[1].isPressed()){
					System.out.println("OPTIONS");
					state = "OPTIONS";
				}
				if(guiButton.button[2].isPressed()){
					System.out.println("CREDITS");
					state = "CREDITS";
				}
				if(guiButton.button[3].isPressed()){
					System.out.println("LEVEL_EDITOR");
					state = "LEVEL_EDITOR";
				}
				if(guiButton.button[4].isPressed()){
					Display.destroy();
				}
			}else if(guiButton.button[i] != null && guiButton.button[i].area == "LEVEL_SELECT" && state == "LEVEL_SELECT"){
				guiButton.button[i].applyColour();
				guiButton.button[i].isMouseOver();
				
				if(guiButton.button[5].isPressed()){
					state = "MAIN_MENU";
				}
			}else if(guiButton.button[i] != null && guiButton.button[i].area == "OPTIONS" && state == "OPTIONS"){
				guiButton.button[i].applyColour();
				guiButton.button[i].isMouseOver();
				
				if(guiButton.button[6].isPressed()){
					state = "MAIN_MENU";
				}
			}else if(guiButton.button[i] != null && guiButton.button[i].area == "CREDITS" && state == "CREDITS"){
				guiButton.button[i].applyColour();
				guiButton.button[i].isMouseOver();
				
				if(guiButton.button[7].isPressed()){
					state = "MAIN_MENU";
				}
			}else if(guiButton.button[i] != null && guiButton.button[i].area == "LEVEL_EDITOR" && state == "LEVEL_EDITOR"){
				guiButton.button[i].applyColour();
				guiButton.button[i].isMouseOver();
				
				if(guiButton.button[8].isPressed()){
					state = "MAIN_MENU";
				}
			}
			if(i < 64){
				if(guiLevels.levels[i] != null){
					guiLevels.levels[i].applyColour();
					guiLevels.levels[i].isMouseOver();
					
					if(guiButton.button[9].isPressed()){
						guiLevels.levels[i].moveForward();
					}
					if(guiButton.button[10].isPressed()){
						guiLevels.levels[i].moveBack();
					}
				}
			}
		}
		
	}
}
