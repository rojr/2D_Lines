package com.gmail.robmadeyou;

public class State {
	/*
	 * Choose between 4 states
	 * 
	 * GAME
	 * LEVEL_EDIT
	 * MAIN_MENU
	 * QUIT
	 * 
	 */
	
	
	static String state = "MAIN_MENU";
	public static void stateDecider(){
		if(state.equals("MAIN_MENU")){
			
		}else if(state.equals("GAME")){
			
		}else if(state.equals("LEVEL_EDIT")){
			
		}else if(state.equals("QUIT")){
			System.exit(1);
		}
	}
}
