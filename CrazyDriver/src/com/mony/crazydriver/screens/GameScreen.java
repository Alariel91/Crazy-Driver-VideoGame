package com.mony.crazydriver.screens;





import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.mony.crazydriver.CrazyDriver;
import com.mony.crazydriver.characters.Car;
import com.mony.crazydriver.managers.LevelManager;
import com.mony.crazydriver.managers.ResourceManager;
import com.mony.crazydriver.managers.SpriteManager;

public class GameScreen implements Screen{
	CrazyDriver game;
	LevelManager levelManager;
	SpriteManager spriteManager;
	public GameScreen(CrazyDriver game){
		
		this.game=game;
		ResourceManager.loadAllResources();
		spriteManager= new SpriteManager(game);
		
		levelManager=new LevelManager(spriteManager);
		levelManager.loadCurrentLevel();
		//ESTO LO HE PUESTO PARA PASAR DE NIVEL
		spriteManager.setLevelManager(levelManager);
		
	}
	
	/**
	 * Muestra la información de juego del personaje
	 */
	private void drawOnscreenText() {
		Car car= spriteManager.getCar();
	
		// Muestra la puntuación y nivel del jugador
		if(levelManager.getCurrentLevel()==1){
			game.font.draw(game.batch, "SALVADOS: " + car.getScore() + " / " + "5", 15, 20);
		}else{
			game.font.draw(game.batch, "SALVADOS: " + car.getScore() + " / " + "10", 15, 20);
		}
		game.font.draw(game.batch, "NIVEL: " + levelManager.getCurrentLevel(), 420, 500);
	}
	@Override
	public void show() {
		game.paused = false;
		
	}
	@Override
	public void render(float dt) {
	
		spriteManager.update(dt);
		spriteManager.render(game.batch);
		update(dt);
		game.batch.begin();
			drawOnscreenText();
		game.batch.end();
	}
	@Override
	public void dispose() {
		
		
	}

	/**
	 * Cuando esta pantalla se oculta, se pausa
	 */
	@Override
	public void hide() {
		
		game.paused = true;
	}

	@Override
	public void pause() {
		
		game.paused = true;
	}

	@Override
	public void resize(int arg0, int arg1) {
	}

	@Override
	public void resume() {
		game.paused = false;
	}
	private void update(float dt) {
	
		  handleKeyboard();
	}

	private void handleKeyboard() {
		  
		  /*
		   * Si el usuario pulsa la tecla ESCAPE se muestra un menú durante el juego
		   */
		  if (Gdx.input.isKeyPressed(Keys.P)) {
		   game.setScreen(new InGameMenuScreen(game, this));
		   
		  }
		 }




	
}
