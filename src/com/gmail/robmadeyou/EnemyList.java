package com.gmail.robmadeyou;

import java.util.Random;

public class EnemyList {
	public static int maxEnemies = 100;
	static Enemy[] enemy = new Enemy[maxEnemies];
	
	
	public static class Enemies extends Enemy{
		public Enemies(int x, int y, int w, int h, String bonus, int toughness) {
			super(x, y, w, h, bonus,toughness);
		}
		
	}
	
	public static void addEnemy(Enemy e){
		for(int i = 0; i < maxEnemies; i++){
			if(enemy[i] == null){
				enemy[i] = e;
				enemy[i].isOnScreen = true;
				break;
			}
		}
	}
	
	public static void drawAll(){
		for(int i = 0; i < maxEnemies; i++){
			if(enemy[i] != null && enemy[i].isOnScreen){
				enemy[i].draw();
			}
		}
	}
	public static int getArrayNumber(int x, int y){
		for(int i = 0; i < maxEnemies; i++){
			if(enemy[i] != null){
				if(x != -1 && y != -1 && enemy[i].x == x && enemy[i].y == y){
					return i;
				}
			}
		}
		return -1;
	}
	public static void checkIfInBounds(){
		for(int i = 0; i < maxEnemies; i++){
			if(enemy[i] != null && enemy[i].isOnScreen){
				int x = Main.b.getX();
				int y = Main.b.getY();
				int w = Main.b.getWidth();
				int h = Main.b.getHeight();
				
				int eX = enemy[i].getX();
				int eY = enemy[i].getY();
				int eW = enemy[i].getWidth();
				int eH = enemy[i].getHeight();
				//Checking general if the enemy is being touched by the ball
				//0,0
				boolean one = x > eX && x < eX + eW && y > eY && y < eY + eH;
				//1,0
				boolean two = x + w> eX && x + w< eX + eW && y > eY && y < eY + eH;
				//1,1
				boolean three = x + w> eX && x + w< eX + eW && y + h> eY && y + h< eY + eH;
				//0,1
				boolean four = x > eX && x < eX + eW && y + h> eY && y + h< eY + eH;
				
				//Checking direction rebound from enemy
				//BOTTOM
				boolean oneZeroZero = x > eX && x < eX + eW && y >= eY + eH - 6 && y < eY + eH;
				boolean oneOneZero = x + w > eX && x + w< eX + eW && y >= eY + eH - 6 && y < eY + eH;
				//LEFT
				boolean twoZeroZero = x > eX && x < eX + 6 && y > eY && y < eY + eH;
				boolean twoOneZero = x > eX && x < eX + 6 && y + h > eY && y + h < eY + eH;
				//RIGHT
				boolean threeOneZero = x > eX + eW  - 6 && x < eX + eW && y > eY && y < eY + eH;
				boolean threeZeroOne = x > eX + eW  - 6 && x < eX + eW && y + h> eY && y + h < eY + eH;
				//TOP
				boolean fourZeroZero = x > eX && x < eX + eW && y >= eY && y < eY + 6;
				boolean fourOneZero = x + w > eX && x + w< eX + eW && y >= eY && y < eY + 6;
				
				boolean intersectEnemy = one || two || three || four;
				
				if(oneZeroZero || oneOneZero){
					Main.b.changeDirection("bottom");
				}else if(twoZeroZero || twoOneZero){
					Main.b.changeDirection("left");
				}else if(threeOneZero || threeZeroOne){
					Main.b.changeDirection("right");
				}else if(fourOneZero || fourZeroZero){
					Main.b.changeDirection("top");
				}
				if(intersectEnemy){
					Random random = new Random();
					int ranBuffGen = 1+random.nextInt(2);
					if(ranBuffGen == 2){
						
						BuffList.addBuff(new BuffList.buffs(BuffType.BIGGER_PAD, enemy[i].getX(), enemy[i].getY()));
					}
					//Declaring enemy dead! Ha, you is dead! :p but not really deleting it, just declaring it invisible... need it for 
					//loading saves and so
					enemy[i].isOnScreen = false;
					//I added this break because it would keep hitting off other enemies and changing direction twice
					//so it would look like it is ignoring collision
					break;
				}
			}
		}
	}
}
