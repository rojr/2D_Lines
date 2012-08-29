package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glColor3f;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class guiLevels {
	static Levels[] levels = new Levels[64];
	public static class Levels{
		int x;
		int y;
		int width = 120;
		int height = 100;
		
		
		boolean unlocked;
		
		int originalX;
		int originalY;
		
		int page;
		
		String colour;
		String colourPressed;
		String colourLocked;
		
		float red;
		float green;
		float blue;
		
		float redUnpressed;
		float greenUnpressed;
		float blueUnpressed;
		
		float redPressed;
		float greenPressed;
		float bluePressed;
		
		float redLocked;
		float greenLocked;
		float blueLocked;
		
		Levels(int x, int y, boolean unlocked, int page, String colour,String colourPressed, String colourLocked, String texture){
			this.x = x;
			this.y = y;
			this.unlocked = unlocked;
			
			this.page = page;
			this.colour = colour;
			this.colourPressed = colourPressed;
			this.colourLocked = colourLocked;
			
			this.originalX = x;
			this.originalY = y;
		}
		
		void applyColour(){
			
			if(colourLocked == "white"){
				redLocked = 1;
				greenLocked = 1;
				blueLocked = 1;
			}else if(colourLocked == "black"){
				redLocked = 0;
				greenLocked = 0;
				blueLocked = 0;
			}else if(colourLocked == "red"){
				redLocked = 1;
				greenLocked = 0;
				blueLocked = 0;
			}else if(colourLocked == "green"){
				redLocked = 0;
				greenLocked = 1;
				blueLocked = 0;
			}else if(colourLocked == "blue"){
			redLocked = 0;
				greenLocked = 0;
				blueLocked = 1;
			}else if(colourLocked == "cyan"){
				redLocked = 0;
				greenLocked = 1;
				blueLocked = 1;
			}else if(colourLocked == "violet"){
				redLocked = 1;
				greenLocked = 0;
				blueLocked = 1;
			}else if(colourLocked == "yellow"){
				redLocked = 1;
				greenLocked = 1;
				blueLocked = 0;
			}
			
			if(colour == "white"){
				redUnpressed = 1;
				greenUnpressed = 1;
				blueUnpressed = 1;
			}else if(colour == "black"){
				redUnpressed = 0;
				greenUnpressed = 0;
				blueUnpressed = 0;
			}else if(colour == "red"){
				redUnpressed = 1;
				greenUnpressed = 0;
				blueUnpressed = 0;
			}else if(colour == "green"){
				redUnpressed = 0;
				greenUnpressed = 1;
				blueUnpressed = 0;
			}else if(colour == "blue"){
				redUnpressed = 0;
				greenUnpressed = 0;
				blueUnpressed = 1;
			}else if(colour == "cyan"){
				redUnpressed = 0;
				greenUnpressed = 1;
				blueUnpressed = 1;
				}else if(colour == "violet"){
				redUnpressed = 1;
				greenUnpressed = 0;
				blueUnpressed = 1;
			}else if(colour == "yellow"){
				redUnpressed = 1;
				greenUnpressed = 1;
				blueUnpressed = 0;
			}
				
			if(colourPressed == "white"){
				redPressed = 1;
				greenPressed = 1;
				bluePressed = 1;
			}else if(colourPressed == "black"){
				redPressed = 0;
				greenPressed = 0;
				bluePressed = 0;
			}else if(colourPressed == "red"){
				redPressed = 1;
				greenPressed = 0;
				bluePressed = 0;
			}else if(colourPressed == "green"){
				redPressed = 0;
				greenPressed = 1;
				bluePressed = 0;
			}else if(colourPressed == "blue"){
				redPressed = 0;
				greenPressed = 0;
				bluePressed = 1;
			}else if(colourPressed == "cyan"){
				redPressed = 0;
				greenPressed = 1;
				bluePressed = 1;
			}else if(colourPressed == "violet"){
				redPressed = 1;
				greenPressed = 0;
				bluePressed = 1;
			}else if(colourPressed == "yellow"){
				redPressed = 1;
				greenPressed = 1;
				bluePressed = 0;
				}
			}
		void moveForward(){
			while(x != originalX - 640){
				x--;
			}
		}
		void moveBack(){
			while(x != originalX){
				x++;
			}
		}
		boolean isMouseOver(){
			int mouseX = Mouse.getX();
			int mouseY = Display.getHeight() - Mouse.getY();
			//Checks if Mouse is in the exact location of the cube,
			if(mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height){
				if(unlocked){
					red = redPressed;
					green = greenPressed;
					blue = bluePressed;
					return true;
				}else{
					red = redLocked;
					green = greenLocked;
					blue = blueLocked;
				}
			}else{
				if(unlocked){
					red = redUnpressed;
					green = greenUnpressed;
					blue = blueUnpressed;
					return false;
				}else{
					red = redLocked;
					green = greenLocked;
					blue = blueLocked;
				}
			}
			return false;
		}
		
		boolean isPressed(){
			if(isMouseOver()){
				while(Mouse.next()){
					if(Mouse.isButtonDown(0)){
						if(Mouse.getEventButtonState()){
							return true;
						}
					}
				}
			}
			return false;
		}
		
		
		void draw(){
			glBegin(GL_QUADS);
				glColor3f(red, green, blue);
				glVertex2f(x , y);
				glVertex2f(x + width, y);
				glVertex2f(x + width , y + height);
				glVertex2f(x , y + height);
			glEnd();
		}
		
	}
}
