package com.jawaresoft.tetrisevo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class TetrisEvo extends Game {
	
	public static final AssetManager ADMINISTRADOR_RECURSOS = new AssetManager();
	
	public TetrisEvo(){
	}	
	
	public void create() {
		ADMINISTRADOR_RECURSOS.load("Personaje.png", Texture.class);
		ADMINISTRADOR_RECURSOS.load("Bala.png", Texture.class);
		while(!ADMINISTRADOR_RECURSOS.update()){
		}
		setScreen(new PantallaJuego(this));
	}

	public void dispose() {
		super.dispose();
		ADMINISTRADOR_RECURSOS.dispose();
	}
	
}
