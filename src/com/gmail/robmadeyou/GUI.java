package com.gmail.robmadeyou;

public class GUI {
	
	public static void Draw(int i, String state){
		if(guiButton.button[i] != null){
			if(guiButton.button[i].area == state){
				guiButton.button[i].draw();
			}
		}
		if(Game.state == "LEVEL_SELECT" && i < 64){
			if(guiLevels.levels[i] != null){
				guiLevels.levels[i].draw();
			}
		}
		if(Game.state == "GAME"){
			for(int r = 0; r < 256; r++){
				if( r < 128 && Player.lines[r]!= null){
					Player.lines[r].draw();
				}
				if(Player.dots[r] != null){
					Player.dots[r].draw();
				}
			}
		}
		
	}
}
