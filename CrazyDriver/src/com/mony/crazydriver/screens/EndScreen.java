package com.mony.crazydriver.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mony.crazydriver.CrazyDriver;

public class EndScreen implements Screen {
	final CrazyDriver game;
	
	Stage stage;
	Texture fondo;
	public EndScreen(CrazyDriver game) {
		this.game = game;
		 fondo = new Texture(Gdx.files.internal("imagenes/fin.png"));
	}
	 @Override
	 public void render(float arg0) {
	  Gdx.gl.glClearColor(0, 0, 0, 1);
	  //Limpio la pantalla en el bucle render todo el rato.
	  Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	
	  // Muestra un menú de inicio
	  game.batch.begin();
	  game.batch.draw(fondo, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	
	  //Pinto los textos y en qué posicion y las coordenadas donde quiero pintarlo.
	  game.font.draw(game.batch, "", 100, 375);
	  
	  game.font.draw(game.batch, "Pulsa ESC para volver al menú principal.", 120, 20);
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
