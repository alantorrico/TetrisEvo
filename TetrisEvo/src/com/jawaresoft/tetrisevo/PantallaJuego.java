package com.jawaresoft.tetrisevo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PantallaJuego extends Pantalla {
	
	private Stage escenario;
	private Personaje personaje;
	private Bala bala;

	public PantallaJuego(TetrisEvo juego) {
		super(juego);
	}

	public void render(float delta) {
		Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
		escenario.act();
		escenario.draw();
	}

	public void show() {
		escenario = new Stage();
		personaje = new Personaje();
		bala = new Bala();
		Gdx.input.setInputProcessor(escenario);
		
		escenario.addActor(personaje);
		escenario.addActor(bala);
		
		personaje.setPosition(50, 50);
		escenario.setKeyboardFocus(personaje);
		personaje.addListener(new InputListener(){

			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				switch(keycode){
				case Input.Keys.RIGHT:
					personaje.velocidad.x = 150;
					return true;
				case Input.Keys.LEFT:
					personaje.velocidad.x = -150;
					return true;
				default:
					return false;
				}
			}

			@Override
			public boolean keyUp(InputEvent event, int keycode) {
				boolean respuesta = true;
				switch(keycode){
				case Input.Keys.RIGHT:
					personaje.velocidad.x = 0;
				case Input.Keys.LEFT:
					personaje.velocidad.x = 0;
				default:
					respuesta = false;
				}
				return respuesta;
			}

			@Override
			public boolean keyTyped(InputEvent event, char character) {
				// TODO Auto-generated method stub
				return super.keyTyped(event, character);
			}
			
		});
		
		
		
		
		bala.setPosition(80, 110);
	}

	public void hide() {
	}
	
	public void dispose() {
		escenario.dispose();
	}

	@Override
	public void resize(int width, int height) {
		escenario.setViewport(width, height, true);
	}
	

}
