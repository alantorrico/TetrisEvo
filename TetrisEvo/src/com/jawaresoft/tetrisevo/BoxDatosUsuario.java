package com.jawaresoft.tetrisevo;

public class BoxDatosUsuario {
	
	int grupoColisiones;
	int indexBox;
	
	public BoxDatosUsuario(int indexBox, int grupoColisiones){
		 establecer(indexBox,grupoColisiones);
	}

	private void establecer(int indexBox, int grupoColisiones) {
		this.indexBox = indexBox;
		this.grupoColisiones = grupoColisiones;
	}
	
	public int getIdBox(){return this.indexBox;}
	public int getGrupoColisiones(){return this.grupoColisiones;}
}
