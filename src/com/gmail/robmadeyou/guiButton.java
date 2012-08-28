package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glColor3f;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class guiButton {
	/*
	 * Just an array list that holds all the buttons, for now 128, might need to increase the amount later on...
	 */
	static Button[] button = new Button[128];
	
	public static class Button{
		int x;
		int y;
		int height;
		int width;
		//Area string, I like to render the Quads according to their allocated area. Saves some work in my oppinion.
		String area;
		String colour;
		String colourPressed;
		String texture;
		//Floats for Colours, these will be changed with the colour String
		float red;
		float green;
		float blue;
		
		float redUnpressed;
		float greenUnpressed;
		float blueUnpressed;
		
		float redPressed;
		float greenPressed;
		float bluePressed;
		
		//Variables for the moving buttons, they are cool!
		
		int originalX;
		int originalY;
		int originalHeight;
		int originalWidth;
		
		int moved;
		int expandedX;
		int expandedY;
		
		//Variables that determine some of the options of the button
		boolean moveable;
		boolean expandable;
		
		Button(int x, int y, int height, int width, String area, String colour, String colourPressed, String texutre, boolean moveable, boolean expandable){
			this.x = x;
			this.y = y;
			this.height = height;
			this.width = width;
			this.area = area;
			this.colour = colour;
			this.colourPressed = colourPressed;
			this.texture = texture;
			this.moveable = moveable;
			this.expandable = expandable;
			
			this.originalX = x;
			this.originalY = y;
			this.originalHeight = height;
			this.originalWidth = width;
		}
		/*
		 * Here the String for colour is broken down into 3 floats, red, green, and blue. Reason for this is
		 * because I like to program before I start drawing :3
		 * 
		 * p.s. 
		 * Yes this is how you spell <b>Colour</b> xD
		 */
		void applyColour(){
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
			}else{
				redUnpressed = 1;
				greenUnpressed = 1;
				blueUnpressed = 1;
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
		
		boolean isMouseOver(){
			int mouseX = Mouse.getX();
			int mouseY = Display.getHeight() - Mouse.getY();
			//Checks if Mouse is in the exact location of the cube,
			if(mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height){
				red = redPressed;
				green = greenPressed;
				blue = bluePressed;
				return true;
			}else{
				red = redUnpressed;
				green = greenUnpressed;
				blue = blueUnpressed;
				return false;
			}
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
		
		void move(int toX, int toY){
			if(moveable){
				x = toX;
				y = toY;
				
				originalX = toX;
				originalY = toY;
			}
		}
		
		
		void expand(int byX, int byY){
			if(expandable){
				if(isMouseOver()){
					if(byX < 0){
						if(expandedX != byX){
							x--;
							expandedX--;
							width++;
						}
					}else if(byX > 0){
						if(expandedX != byX){
							x++;
							expandedX++;
							width--;
						}
					}
					
					if(byY < 0){
						if(expandedY != byY){
							y--;
							expandedY--;
							height++;
						}
					}else if(byY > 0){
						if(expandedY != byY){
							y++;
							expandedY--;
							height--;
						}
					}
				}else{
					if(byX < 0){
						if(x != originalX){
							x++;
							expandedX++;
							width--;
						}
					}else if(byX > 0){
						if(x != originalX){
							x--;
							expandedX--;
							width++;
						}
					}
					if(byY < 0){
						if(y != originalY){
							y++;
							expandedY++;
							height--;
						}
					}else if(byY > 0){
						if(y != originalY){
							y--;
							expandedY--;
							height++;
						}
					}
				}
			}
		}
		//Draws the Quads, 
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
