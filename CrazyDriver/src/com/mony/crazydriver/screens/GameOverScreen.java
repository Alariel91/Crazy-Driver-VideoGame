package com.mony.crazydriver.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mony.crazydriver.CrazyDriver;
import com.mony.crazydriver.util.Constants;

/**
 * Pantalla de fin de partida. Se muestra cuando el usuario termina una partida
 * Se presenta un menú de juego
 *
 */
public class GameOverScreen implements Screen {
	
	final CrazyDriver game;
	
	Stage stage;
	Texture fondo;
	public GameOverScreen(CrazyDriver game) {
		this.game = game;
		 fondo = new Texture(Gdx.files.internal("imagenes/gameover.png"));
	}
	
	private void loadScreen() {
		
		// Grafo de escena que contendrá todo el menú
		stage = new Stage();
					
		// Crea una tabla, donde añadiremos los elementos de menú
		final Table table = new Table();
		table.setPosition(Constants.SCREEN_WIDTH / 2.5f, Constants.SCREEN_HEIGHT / 1.5f);
		// La tabla ocupa toda la pantalla
	    table.setFillParent(true);
	    table.setHeight(512);
	    stage.addActor(table);
		
		final Label label = new Label("", game.getSkin());
		table.addActor(label);
	
			TextButton buttonQuit = new TextButton("Volver", game.getSkin());
			buttonQuit.setPosition(label.getOriginX()-50, label.getOriginY()-320);
			buttonQuit.setWidth(200);
			buttonQuit.setHeight(40);
			buttonQuit.addListener(new InputListener() {
				public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
					return true;	
				}
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					game.setScreen(new MainMenuScreen(game));
				}
			});
			table.addActor(buttonQuit);
			Gdx.input.setInputProcessor(stage);
		}
	@Override
	public void show() {
		loadScreen();
	}
	
	@Override
	public void render(float dt) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(fondo, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		game.batch.end();
		// Pinta el menú
		stage.act(dt);
		stage.draw();
	}
	
	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
