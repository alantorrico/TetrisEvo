package com.jawaresoft.tetrisevo;

import com.badlogic.gdx.Screen;

public abstract class Pantalla implements Screen {
	
	protected TetrisEvo juego;
	
	public Pantalla(TetrisEvo juego){
		this.juego = juego;
	}

	public void resize(int width, int height) {
	}

	public void pause() {
	}

	public void resume() {
	}
}
