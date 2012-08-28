package com.gmail.robmadeyou;

public class GUI {
	
	public static void Draw(int i, String state){
		if(guiButton.button[i] != null){
			if(guiButton.button[i].area == state){
				guiButton.button[i].draw();
			}
		}
		
	}
}
