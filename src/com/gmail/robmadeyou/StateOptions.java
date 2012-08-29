package com.gmail.robmadeyou;

public class StateOptions {
	public static boolean areCreated = false;
	
	public static void onInit(){
		
		//Here we add new objects to the Main menu state. x, y, height, width, state, normalColour, colourPressed/hover, Texture, moveable, expandable
		
		//Back button
		guiButton.button[6] = new guiButton.Button(0, 0, 40, 50, "OPTIONS", "yellow", "white", "", false, false);
		
		areCreated = true;
	}
}
