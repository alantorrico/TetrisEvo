package com.jawaresoft.tetrisevo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Personaje extends Actor {
	
	private TextureRegion imagen;
	public Vector2 velocidad = new Vector2(0, 0);

	@Override
	public void act(float delta) {
		translate(velocidad.x*delta, velocidad.y*delta);
		
		if(getX() < 0){
			setX(0);
			velocidad.x = 0;
		}
		else if(getRight() > getStage().getWidth()){
			setX(getStage().getWidth() - getWidth());
			velocidad.x = 0;
		}
		
		if(getY() < 0){
			setY(0);
			velocidad.y = 0;
		}
		else if(getTop() > getStage().getHeight()){
			setY(getStage().getHeight() - getHeight());
			velocidad.y = 0;
		}
		
		
	}

	public Personaje() {
		imagen = new TextureRegion(TetrisEvo.ADMINISTRADOR_RECURSOS.get("Personaje.png", Texture.class), 64, 64);
		setSize(imagen.getRegionWidth(), imagen.getRegionHeight());
	}

	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.draw(imagen, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
}
