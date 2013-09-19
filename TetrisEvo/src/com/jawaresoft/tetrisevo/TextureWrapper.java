package com.jawaresoft.tetrisevo;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class TextureWrapper {
	
	TextureRegion region;
	int alto;
	int ancho;
	Vector2 posicion;
	
	float escalaX, escalaY;
	float origenX, origenY, rotacion;
	
	public TextureWrapper(TextureRegion region, Vector2 posicion){
		this.region = region;
		establecerTexturaRegion(region);
	}

	private void establecerTexturaRegion(TextureRegion region) {
		this.region = region;
		
		alto = region.getRegionWidth();
		ancho = region.getRegionHeight();
		
		origenX = ancho/2f;
		origenY = alto/2f;
		
		escalaX = 1f;
		escalaY = 1f;
	}
	
	public int getAncho(){return ancho;}
	public int getAlto(){return alto;}
	
	public void setPosicion(float x, float y){
		posicion.set(x, y);
	}
	
	public void setRotacion(float r){
		rotacion = r;
	}
	
	public void dibujar(SpriteBatch SB){
		SB.draw(region, posicion.x - ancho/2, posicion.y - alto/2, origenX, origenY, ancho,alto, escalaX, escalaY, rotacion);
	}
}
