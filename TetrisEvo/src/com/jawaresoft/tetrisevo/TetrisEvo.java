package com.jawaresoft.tetrisevo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class TetrisEvo extends Game {
	
	public static final AssetManager ADMINISTRADOR_RECURSOS = new AssetManager();
	//Trabajando con Box2D
	private World mundo;
	private Body cuerpo;
	static final float MUNDO_A_BOX = 0.01f;
	static final float BOX_DEL_MUNDO = 100f;
	
	static final float BOX_PASO = 1/120f;
	static final int BOX_VELOCIDAD_ITERACIONES = 8;
	static final int BOX_POSICION_ITERACIONES = 3;
	
	private int acumulador;
	
	
	//Fin Box2D
	public TetrisEvo(){
		
	}	
	
	public void create() {
		ADMINISTRADOR_RECURSOS.load("Personaje.png", Texture.class);
		ADMINISTRADOR_RECURSOS.load("Bala.png", Texture.class);
		ADMINISTRADOR_RECURSOS.load("Personaje1.png", Texture.class);
		while(!ADMINISTRADOR_RECURSOS.update()){
		}
		setScreen(new PantallaJuego(this));
		
		mundo = new World(new Vector2(0,10), true);
	}

	public void dispose() {
		super.dispose();
		ADMINISTRADOR_RECURSOS.dispose();
	}
	/*
	 * Metodo que convierte de pixeles a unidades fisicas
	 */
	 private float convertirABox(float x){
		 return x * MUNDO_A_BOX;
	 }
	 
	 /*
	  * Para crear un cuerpo se define  con el objeto BodyDef del objeto, el cual guarda propiedades fisicas
	  * Despues lo referenciamos al objeto mundo.
	  */
	 private void  crearCuerpo(World mundo, Vector2 posicion, float angulo){
		 BodyDef defCuerpo = new BodyDef();
		 defCuerpo.type = BodyType.DynamicBody;
		 defCuerpo.position.set(convertirABox(posicion.x),convertirABox(posicion.y));
		 defCuerpo.angle = angulo;
		 cuerpo = mundo.createBody(defCuerpo);
	 }
	 
	 /*
	  * Una vez que el cuerpo fue definido, agregamos una forma fisica (Fixture)
	  */
	 
	 private void hacerCuerpoRectangular(float ancho, float alto, BodyDef.
			 BodyType tipoCuerpo, float densidad, float restitucion, Vector2 posicion,float angulo){
		 //Forma de la figura
		 PolygonShape formaCuerpo = new PolygonShape();
		 
		 float w = convertirABox(ancho/2f);
		 float h = convertirABox(alto/2f);
		 
		 formaCuerpo.setAsBox(w,h);
		 //Definimos el Fixture
		 FixtureDef defFixture = new FixtureDef();
		 defFixture.density = densidad;
		 defFixture.restitution = restitucion;
		 defFixture.shape = formaCuerpo;
		 
		 cuerpo.createFixture(defFixture);
		 formaCuerpo.dispose();
	 }
	 
	 private void actualizarMundo(float tiempoDelta){
		 acumulador = (int) (acumulador + tiempoDelta);
		 
		 while(acumulador > BOX_PASO){
			 mundo.step(BOX_PASO, BOX_VELOCIDAD_ITERACIONES, BOX_POSICION_ITERACIONES);
			 acumulador = (int) (acumulador - BOX_PASO);
		 }
	 }
}
