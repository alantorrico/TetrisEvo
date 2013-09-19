package com.jawaresoft.tetrisevo;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public abstract class BoxObjetoBase {
	
	private World mundo;
	public Body cuerpo;
	static final float MUNDO_A_BOX = 0.01f;
	static final float BOX_A_MUNDO = 100f;
	
	static final float BOX_PASO = 1/120f;
	static final int BOX_VELOCIDAD_ITERACIONES = 8;
	static final int BOX_POSICION_ITERACIONES = 3;
	
	private int acumulador;
	protected BoxDatosUsuario datosUsuario;
    protected Vector2 posicionMundo;
    
    float convertirABox(float x){
    	return x * MUNDO_A_BOX;
    }
    
    float convertirAMundo(float x){
        return x * BOX_A_MUNDO;
    }
    
    
    
    public BoxObjetoBase(Vector2 posicion,World mundo, int indexBox, int grupoColisiones){
    	
          datosUsuario = new BoxDatosUsuario(indexBox,grupoColisiones);
          posicionMundo = new Vector2();
          crearCuerpo(mundo,posicion,0);    
          
          cuerpo.setUserData(datosUsuario);
    } 
    
    public void crearCuerpo(World mundo, Vector2 posicion,float angulo){
        BodyDef defCuerpo = new BodyDef(); 
        defCuerpo.type = BodyType.DynamicBody;
        defCuerpo.position.set(convertirABox(posicion.x),convertirABox(posicion.y));
        defCuerpo.angle = angulo;
        cuerpo = mundo.createBody(defCuerpo);
    }

    public void hacerAccesorioRectangular(float ancho,float alto,BodyDef.BodyType tipoCuerpo,
       float densidad,float restitucion, Vector2 posicion,float angulo){
       PolygonShape formaCuerpo = new PolygonShape();

       float w = convertirABox(ancho/2f);
       float h = convertirABox(alto/2f);
       formaCuerpo.setAsBox(w,h);

       FixtureDef defAccesorio=new FixtureDef();
       defAccesorio.density = densidad;
       defAccesorio.restitution = restitucion;
       defAccesorio.shape = formaCuerpo;

       cuerpo.createFixture(defAccesorio);
       formaCuerpo.dispose();
    }
    
    public void hacerAccesorioCircular(float radio,BodyDef.BodyType tipoCuerpo,
       float densidad,float restitucion, Vector2 posicion,float angulo){

       FixtureDef defAccesorio=new FixtureDef();
       defAccesorio.density = densidad;
       defAccesorio.restitution = restitucion;
       defAccesorio.shape = new CircleShape();
       defAccesorio.shape.setRadius(convertirABox(radio));

       cuerpo.createFixture(defAccesorio);
       defAccesorio.shape.dispose();
    }
    public void ActualizarPosicionMundo(){
        posicionMundo.set(convertirAMundo(cuerpo.getPosition().x),convertirAMundo(cuerpo.getPosition().y));
    }

}
