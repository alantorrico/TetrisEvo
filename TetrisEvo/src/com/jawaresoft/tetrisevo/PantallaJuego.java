package com.jawaresoft.tetrisevo;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class PantallaJuego extends Pantalla {
	
	private Stage escenario;
	private Personaje personaje;
	private Bala bala;

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
		bala = new Bala();
		
		escenario.addActor(personaje);
		escenario.addActor(bala);
		personaje.setPosition(50, 50);
		bala.setPosition(80, 110);
	}

	public void hide() {
	}
	
	public void dispose() {
		escenario.dispose();
	}

}
