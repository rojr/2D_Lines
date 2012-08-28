package com.gmail.robmadeyou;

public class StateLevelSelect {
	public static boolean areCreated = false;
	
	public static void onInit(){
		
		guiButton.button[5] = new guiButton.Button(0, 0, 40, 50, "OPTIONS", "yellow", "white", "", false, false);
		
		areCreated = true;
	}
}
