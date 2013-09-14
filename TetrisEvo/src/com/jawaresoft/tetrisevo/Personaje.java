package com.jawaresoft.tetrisevo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Personaje extends Actor {
	
	private TextureRegion imagen;

	public Personaje() {
	imagen = new TextureRegion(TetrisEvo.ADMINISTRADOR_RECURSOS.get("bala.png", Texture.class), 10, 10);
		//setSize(imagen.getRegionWidth(), imagen.getRegionHeight());
	}

//	public void draw(SpriteBatch batch, float parentAlpha) {
		//batch.draw(imagen, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
//	}

}
