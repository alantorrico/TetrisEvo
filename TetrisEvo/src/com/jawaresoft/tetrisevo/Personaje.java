package com.jawaresoft.tetrisevo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Personaje extends Actor {
	
	public static final int IZQUIERDA = 0;
	public static final int DERECHA = 1;
	
	private int movimiento;
	private float estadoTiempo;
	
	private Vector2 velocidad = new Vector2(0, 0);
	private Animation animacionIzquierda, animacionDerecha;
	private TextureRegion frameActual;

	public Personaje() {
		animacionIzquierda = new Animation(0.1f, cargarSprites("PersonajeIzquierda.png", 1, 8));
		animacionDerecha = new Animation(0.1f, cargarSprites("PersonajeDerecha.png", 1, 8));
		estadoTiempo = 0.0f;
		frameActual = animacionDerecha.getKeyFrame(estadoTiempo, true);
		movimiento  = DERECHA;
		setSize(frameActual.getRegionWidth(), frameActual.getRegionHeight());
	}
	
	public int getMovimiento(){	
		return movimiento;
	}
	
	public void setMovimiento(int nuevoMovimiento){
		movimiento = nuevoMovimiento;
	}
	
	public Vector2 getVelocidad()
	{
		return velocidad;
	}
	
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
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		estadoTiempo += Gdx.graphics.getDeltaTime();
		
		if(movimiento == DERECHA){
			frameActual = animacionDerecha.getKeyFrame(estadoTiempo, true);
		}
		else if(movimiento == IZQUIERDA){
			frameActual = animacionIzquierda.getKeyFrame(estadoTiempo, true);
		}
		
		batch.draw(frameActual, getX(), getY());
	}
	
	public TextureRegion[] cargarSprites(String nombre, int filas, int columnas){
		int posicion = 0;
		
		Texture textura = TetrisEvo.ADMINISTRADOR_RECURSOS.get(nombre, Texture.class);
		TextureRegion[][] imagenes = TextureRegion.split(textura, textura.getWidth()/columnas, textura.getHeight()/filas);
		TextureRegion[] frames = new TextureRegion[columnas*filas];
		
		for(int i = 0; i < filas; i++){
			for(int j = 0; j < columnas; j++){
				frames[posicion++] = imagenes[i][j];
			}
		}
		return frames;
	}
	
}
