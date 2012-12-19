package com.gmail.robmadeyou;



public class BuffList {
	public static int maxBuffsOnScreen = 50;
	static Buff buff[] = new Buff[maxBuffsOnScreen];
	
	public static class buffs extends Buff{
		public buffs(BuffType type, int x, int y) {
			super(type, x, y);
		}
	}
	
	public static void addBuff(Buff b){
		for(int i = 0; i < maxBuffsOnScreen; i++){
			if(buff[i] == null){
				buff[i] = b;
				break;
			}
		}
	}
	public static void onUpdate(int delta){
		for(int i = 0; i < maxBuffsOnScreen; i++){
			if(buff[i] != null){
				buff[i].onUpdate(delta);
				buff[i].draw();
				int x = buff[i].getX();
				int y = buff[i].getY();
				int bX = Main.p.getX();
				int bY = Main.p.getY();
				int bW = Main.p.getWidth();
				int bH = Main.p.getHeight();
				if(x > bX && x < bX + bW && y > bY && y < bY + bH){
					buff[i].doEffect();
					buff[i] = null;
				}
			}
		}
	}
	
}
