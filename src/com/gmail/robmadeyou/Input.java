package com.gmail.robmadeyou;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Input {
	
	static boolean lmbd = false;
	static boolean lmbp = false;
	static boolean rmbd = false;
	static boolean rmbp = false;
	
	static int keyPressed = -1;
	static int keyDown = -1;
	
	
	public static void checkInput(){
		lmbd = false;
		lmbp = false;
		rmbd = false;
		rmbp = false;
		
		keyPressed = -1;
		keyDown = -1;
		
		while(Mouse.next()){
			if(Mouse.getEventButtonState()){
				if(Mouse.isButtonDown(0)){
					lmbp = true;
					lmbd = true;
				}else{
					lmbp = false;
					lmbd = false;
				}
				if(Mouse.isButtonDown(1)){
					rmbp = true;
					rmbd = true;
				}else{
					rmbp = false;
					rmbd = false;
				}
			}
		}
		if(lmbd == true && Mouse.isButtonDown(0)){
			lmbd = true;
		}else{
			lmbd = false;
		}
		if(rmbd == true && Mouse.isButtonDown(1)){
			rmbd = true;
		}else{
			rmbd = false;
		}
		
		
		
		while(Keyboard.next()){
			if(Keyboard.getEventKeyState()){
				if(Keyboard.isKeyDown(Keyboard.getEventKey())){
					keyPressed = Keyboard.getEventKey();
					keyDown = keyPressed;
				}
			}
		}
		if(keyDown == Keyboard.getEventKey()){
			keyDown = Keyboard.getEventKey();
		}else{
			keyDown = -1;
		}
	}
}
