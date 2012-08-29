package com.gmail.robmadeyou;

public class StateLevelEditor {
	
	public static boolean areCreated = false;
	
	public static void onInit(){
		
		//Here we add new objects to the Main menu state. x, y, height, width, state, normalColour, colourPressed/hover, Texture, moveable, expandable
		
		//Back button
		guiButton.button[8] = new guiButton.Button(0, 0, 40, 50, "LEVEL_EDITOR", "yellow", "white", "", false, false);
		
		areCreated = true;
	}
}
