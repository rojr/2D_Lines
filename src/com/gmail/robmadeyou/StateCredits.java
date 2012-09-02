package com.gmail.robmadeyou;

public class StateCredits {
	public static boolean areCreated = false;
	
	public static void onInit(){
		//Back button
		guiButton.button[7] = new guiButton.Button(0, 0, 40, 50, "CREDITS", "yellow", "white", "", false, false);
		
		areCreated = true;
	}
}
