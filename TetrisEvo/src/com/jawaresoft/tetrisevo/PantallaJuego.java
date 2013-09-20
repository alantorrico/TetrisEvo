package com.jawaresoft.tetrisevo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PantallaJuego extends Pantalla {
	
	private Stage escenario;
	private Personaje personaje;

	public PantallaJuego(TetrisEvo juego) {
		super(juego);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
		escenario.act();
		escenario.draw();
	}

	@Override
	public void show() {
		escenario = new Stage();
		personaje = new Personaje();
		Gdx.input.setInputProcessor(escenario);
		
		escenario.addActor(personaje);
		
		personaje.setPosition(50, 50);
		escenario.setKeyboardFocus(personaje);
		personaje.addListener(new InputListener(){

			@Override
			public boolean keyDown(InputEvent evento, int codigoTecla) {
				switch(codigoTecla){
				case Input.Keys.RIGHT:
					personaje.getVelocidad().x = 250;
					personaje.setMovimiento(Personaje.DERECHA);
					return true;
				case Input.Keys.LEFT:
					personaje.getVelocidad().x = -250;
					personaje.setMovimiento(Personaje.IZQUIERDA);
					return true;
				default:
					return false;
				}
			}

			@Override
			public boolean keyUp(InputEvent evento, int codigoTecla) {
				switch(codigoTecla){
				case Input.Keys.RIGHT:
					personaje.getVelocidad().x = 0;
					return true;
				case Input.Keys.LEFT:
					personaje.getVelocidad().x = 0;
					return true;
				default:
					return false;
				}
			}

			@Override
			public boolean keyTyped(InputEvent evento, char caracter) {
				if(caracter != ' '){
					return false;
				}
				Bala bala = new Bala();
				bala.setPosition(personaje.getX()+(personaje.getWidth()/2), personaje.getY()+personaje.getHeight()+10);
				escenario.addActor(bala);
				return true;
			}
			
		});
	}

	@Override
	public void hide() {
	}
	
	@Override
	public void dispose() {
		escenario.dispose();
	}

	@Override
	public void resize(int width, int height) {
		escenario.setViewport(width, height, true);
	}
	

}
