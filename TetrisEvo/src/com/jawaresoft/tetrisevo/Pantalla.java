package com.jawaresoft.tetrisevo;

import com.badlogic.gdx.Screen;

public abstract class Pantalla implements Screen {
	
	protected TetrisEvo juego;
	
	public Pantalla(TetrisEvo juego){
		this.juego = juego;
	}
	
	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}
	
	@Override
	public void resume() {
	}
}
