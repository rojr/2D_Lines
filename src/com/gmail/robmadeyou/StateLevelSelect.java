package com.gmail.robmadeyou;

public class StateLevelSelect {
	public static boolean areCreated = false;
	
	static int page = 1;
	
	public static void onInit(){
		//Creating the back button, nothing special >:3
		guiButton.button[5] = new guiButton.Button(0, 0, 40, 50, "LEVEL_SELECT", "yellow", "white", "", false, false);
		
		//Next page button
		guiButton.button[9] = new guiButton.Button(330, 370, 50, 50, "LEVEL_SELECT", "yellow", "white", "", false, false);
		//Previous page button
		guiButton.button[10] = new guiButton.Button(260, 370, 50, 50, "LEVEL_SELECT", "yellow", "white", "", false, false);
		
		
		/*
		 * Adding the level selection list. This shouldn't be too hard, but shouldn't be too easy at the same time.
		 * If my math is right, there should be 32 available levels for selection, with 15 pixels distance between in x
		 * and 10 pixels distance in y, should work. Let's hope it works!
		 * 
		 * Okay so I decided, instead of doing 32 boxes on the screen which is 4x4, i'll do 4x3, to leave some room
		 * on the bottom so the player can use the buttons to go to the next page to see more levels :) Should look nicer. Hopefully
		 */
		
		guiLevels.levels[0] = new guiLevels.Levels(50, 40, true, 1, "green", "red", "white", "");
		guiLevels.levels[1] = new guiLevels.Levels(190, 40, false, 1, "green", "red", "white", "");
		guiLevels.levels[2] = new guiLevels.Levels(330, 40, false, 1, "green", "red", "white", "");
		guiLevels.levels[3] = new guiLevels.Levels(470, 40, false, 1, "green", "red", "white", "");
		guiLevels.levels[4] = new guiLevels.Levels(50, 150, false, 1, "green", "red", "white", "");
		guiLevels.levels[5] = new guiLevels.Levels(190, 150, false, 1, "blue", "red", "white", "");
		guiLevels.levels[6] = new guiLevels.Levels(330, 150, false, 1, "blue", "red", "white", "");
		guiLevels.levels[7] = new guiLevels.Levels(470, 150, false, 1, "blue", "red", "white", "");
		guiLevels.levels[8] = new guiLevels.Levels(50, 260, false, 1, "blue", "red", "white", "");
		guiLevels.levels[9] = new guiLevels.Levels(190, 260, false, 1, "blue", "red", "white", "");
		guiLevels.levels[10] = new guiLevels.Levels(330, 260, false, 1, "violet", "red", "white", "");
		guiLevels.levels[11] = new guiLevels.Levels(470, 260, false, 1, "violet", "red", "white", "");
		
		guiLevels.levels[12] = new guiLevels.Levels(640 + 50, 40, false, 2, "violet", "red", "white", "");
		guiLevels.levels[13] = new guiLevels.Levels(640 + 190, 40, false, 2, "violet", "red", "white", "");
		guiLevels.levels[14] = new guiLevels.Levels(640 + 330, 40, false, 2, "violet", "red", "white", "");
		guiLevels.levels[15] = new guiLevels.Levels(640 + 470, 40, false, 2, "yellow", "red", "white", "");
		guiLevels.levels[16] = new guiLevels.Levels(640 + 50, 150, false, 2, "yellow", "red", "white", "");
		guiLevels.levels[17] = new guiLevels.Levels(640 + 190, 150, false, 2, "yellow", "red", "white", "");
		guiLevels.levels[18] = new guiLevels.Levels(640 + 330, 150, false, 2, "yellow", "red", "white", "");
		guiLevels.levels[19] = new guiLevels.Levels(640 + 470, 150, false, 2, "yellow", "red", "white", "");
		guiLevels.levels[20] = new guiLevels.Levels(640 + 50, 260, false, 2, "cyan", "red", "white", "");
		guiLevels.levels[21] = new guiLevels.Levels(640 + 190, 260, false, 2, "cyan", "red", "white", "");
		guiLevels.levels[22] = new guiLevels.Levels(640 + 330, 260, false, 2, "cyan", "red", "white", "");
		guiLevels.levels[23] = new guiLevels.Levels(640 + 470, 260, false, 2, "cyan", "red", "white", "");
		
		
		areCreated = true;
	}
}
