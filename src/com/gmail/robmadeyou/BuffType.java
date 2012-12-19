package com.gmail.robmadeyou;

import org.newdawn.slick.opengl.Texture;

public enum BuffType {
	
	
	BIGGER_PAD(Textures.turretArrow1, true);
	
	public final Texture tex;
	public final boolean good;
	BuffType(Texture tex, boolean good){
		this.tex = tex;
		this.good = good;
	}
}
