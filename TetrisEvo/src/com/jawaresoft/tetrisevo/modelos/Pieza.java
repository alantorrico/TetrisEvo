package com.jawaresoft.tetrisevo.modelos;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Pieza {

		public static final float SIZE = 1f;
			
		Vector2 	position = new Vector2();
		Rectangle 	bounds = new Rectangle();
			
		public Pieza(Vector2 pos) {
			this.position = pos;
			this.bounds.width = SIZE;
			this.bounds.height = SIZE;
		}

		public Vector2 getPosition() {
			return position;
		}

		public Rectangle getBounds() {
			return bounds;
		}
	}