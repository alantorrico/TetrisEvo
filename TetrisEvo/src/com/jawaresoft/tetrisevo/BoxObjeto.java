package com.jawaresoft.tetrisevo;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class BoxObjeto extends BoxObjetoBase {

	TextureWrapper texturaWrapper;
	
    public static final int OBJETO_CIRCULO = 1;
    public static final int OBJETO_POLIG = 2;
    
    public BoxObjeto(TextureRegion region,Vector2 posicion, int tipoCuerpo, World mundo, int index, int grupoColisiones){
           super(posicion, mundo,index,grupoColisiones);
           texturaWrapper = new TextureWrapper(region,posicion);
           if(tipoCuerpo == OBJETO_CIRCULO){
        	   
                   hacerAccesorioCircular(texturaWrapper.getAncho()/2,BodyDef.BodyType.StaticBody,1,1,posicion,0);
           }else{
                   hacerAccesorioRectangular(texturaWrapper.getAncho(),texturaWrapper.getAlto(),BodyDef.BodyType.StaticBody,1,1,posicion,0);
           }
    } 
   public void dibujar(SpriteBatch SB){
	   texturaWrapper.dibujar(SB);
   } 
   public void actualizar(float dt){
         ActualizarPosicionMundo();
         texturaWrapper.setPosicion(posicionMundo.x, posicionMundo.y);
         //MathUtils is a class available in box2d which has useful math functions
         texturaWrapper.setRotacion(cuerpo.getAngle() * MathUtils.radiansToDegrees); 
   } 
}
