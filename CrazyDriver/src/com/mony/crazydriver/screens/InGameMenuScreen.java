package com.mony.crazydriver.screens;





import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mony.crazydriver.CrazyDriver;
import com.mony.crazydriver.util.Constants;


/**
 * Menú InGame
 * Se muestra cuando el jugador pulsa la tecla P y muestra algunas opciones de la partida
 * y la opción de salir del juego
 *
 */
public class InGameMenuScreen implements Screen {

	CrazyDriver game;
	GameScreen gameScreen;
	Stage stage;
	Texture fondo;
	
	public InGameMenuScreen(CrazyDriver game, GameScreen gameScreen) {
		this.game = game;
		this.gameScreen = gameScreen;
		 fondo = new Texture(Gdx.files.internal("imagenes/pausa.png"));
	}
	
	private void loadScreen() {
		
	
		stage = new Stage();
					
		
		Table table = new Table();
		table.setPosition(Constants.SCREEN_WIDTH / 2.5f, Constants.SCREEN_HEIGHT / 1.5f);
	
	    table.setFillParent(true);
	    table.setHeight(500);
	    stage.addActor(table);
		
		Label label = new Label("", game.getSkin());
		table.addActor(label);
		
		TextButton buttonResume = new TextButton("Continuar", game.getSkin());
		buttonResume.setPosition(label.getOriginX()-50, label.getOriginY() - 60);
		buttonResume.setWidth(200);
		buttonResume.setHeight(40);
		buttonResume.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;	
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				
				dispose();
				game.setScreen(gameScreen);
			}
		});
		table.addActor(buttonResume);
		
		TextButton buttonMainMenu = new TextButton("Volver al Menu Principal", game.getSkin());
		buttonMainMenu.setPosition(label.getOriginX()-50, label.getOriginY() - 180);
		buttonMainMenu.setWidth(200);
		buttonMainMenu.setHeight(40);
		buttonMainMenu.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;	
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				
				dispose();
				game.setScreen(new MainMenuScreen(game));
			}
		});
		table.addActor(buttonMainMenu);
		

		// Botón
		TextButton buttonConfig = new TextButton("Configurar", game.getSkin());
		buttonConfig.setPosition(label.getOriginX()-50, label.getOriginY() - 2);
		buttonConfig.setWidth(200);
		buttonConfig.setHeight(40);
		buttonConfig.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				
				dispose();
				game.setScreen(new ConfigurationScreen(game,gameScreen));
			}
		});
		table.addActor(buttonConfig);
		TextButton buttonQuit = new TextButton("Salir", game.getSkin());
		buttonQuit.setPosition(label.getOriginX()-50, label.getOriginY() - 120);
		buttonQuit.setWidth(200);
		buttonQuit.setHeight(40);
		buttonQuit.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;	
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				
				dispose();
				System.exit(0);
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
	
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(fondo, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		game.batch.end();
		// Pinta el menu
		stage.act(dt);
		stage.draw();
	}
	
	@Override
	public void dispose() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {	
	}

	@Override
	public void resize(int arg0, int arg1) {
	}

	@Override
	public void resume() {		
	}
}
