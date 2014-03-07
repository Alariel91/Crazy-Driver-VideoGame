package com.mony.crazydriver.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.mony.crazydriver.CrazyDriver;
import com.mony.crazydriver.util.Constants;

public class Instructions implements Screen {
	 final CrazyDriver game;
	 OrthographicCamera camara;
		Texture fondo;
	 public Instructions(CrazyDriver game){
	  this.game=game;
	  
	  camara = new OrthographicCamera();
	  /*
	   * Si queremos que haya gravedad == false;
	   */
	  fondo = new Texture(Gdx.files.internal("imagenes/instrucciones.png"));
	  camara.setToOrtho(false, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
	 }
	 
	 @Override
	 public void render(float arg0) {
	  Gdx.gl.glClearColor(0, 0, 0, 1);
	  //Limpio la pantalla en el bucle render todo el rato.
	  Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	  
	  camara.update();
	  //Para ajustar la camara
	  game.batch.setProjectionMatrix(camara.combined);
	  
	  // Muestra un menú de inicio
	  game.batch.begin();
	  
	  game.batch.draw(fondo, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	  //Pinto los textos y en qué posicion y las coordenadas donde quiero pintarlo.
	  game.font.draw(game.batch, "  ", 100, 375);
	  game.font.draw(game.batch, "Salva a los peatones de los coches.", 100, 350);
	  game.font.draw(game.batch, "Utiliza las flechas para moverte", 100, 325);
	  game.font.draw(game.batch, "Los monstruos rosas te reducen la velocidad.", 100, 200);
	  game.font.draw(game.batch, "Si chocas con un coche, pierdes.", 100, 175);
	  
	  game.font.draw(game.batch, "Pulsa ESC para volver", 100, 100);
	  game.batch.end();
	  
	  /*
	   * Si el usuario toca la pantalla se inicia la partida
	   */
	  if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
	   game.setScreen(new MainMenuScreen(game));
	   dispose();
	  }
	  
	 }

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
}
	
