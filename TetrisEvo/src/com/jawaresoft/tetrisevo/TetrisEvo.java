package com.jawaresoft.tetrisevo;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class TetrisEvo extends Game {
	
	public static final AssetManager ADMINISTRADOR_RECURSOS = new AssetManager();

	public void create() {
		ADMINISTRADOR_RECURSOS.load("bala.png", Texture.class);
		setScreen(new PantallaJuego(this));
	}

	public void dispose() {
		super.dispose();
		ADMINISTRADOR_RECURSOS.dispose();
	}
	
}
