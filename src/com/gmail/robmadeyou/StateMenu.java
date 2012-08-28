package com.gmail.robmadeyou;

public class StateMenu {
	
	public static boolean areCreated = false;
	
	public static void onInit(){
		//Here we add new objects to the Main menu state. x, y, height, width, state, normalColour, colourPressed/hover, Texture, moveable, expandable
		
		//Level select
		guiButton.button[0] = new guiButton.Button(5, 400, 60, 120, "MAIN_MENU", "red", "white", "", true, true);
		//Options
		guiButton.button[1] = new guiButton.Button(130, 400, 60, 100, "MAIN_MENU", "green", "white", "", true, true);
		//Credits
		guiButton.button[2] = new guiButton.Button(235, 400, 60, 100, "MAIN_MENU", "blue", "white", "", true, true);
		//Level creator
		guiButton.button[3] = new guiButton.Button(340, 400, 60, 100, "MAIN_MENU", "yellow", "white", "", true, true);
		//Quit
		guiButton.button[4] = new guiButton.Button(445, 400, 60, 100, "MAIN_MENU", "violet", "white", "", true, true);
		
		areCreated = true;
		
	}
}
