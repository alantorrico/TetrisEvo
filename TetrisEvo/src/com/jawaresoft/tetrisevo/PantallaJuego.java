package com.jawaresoft.tetrisevo;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class PantallaJuego extends Pantalla {
	
	private Stage escenario;
	private Personaje personaje;

	public PantallaJuego(TetrisEvo juego) {
		super(juego);
	}

	public void render(float delta) {
		escenario.act();
		escenario.draw();
	}

	public void show() {
		escenario = new Stage();
		personaje = new Personaje();
		
		//escenario.addActor(personaje);
		//personaje.setPosition(50, 50);
	}

	public void hide() {
	}
	
	public void dispose() {
		escenario.dispose();
	}

}
