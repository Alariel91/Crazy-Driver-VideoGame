package com.mony.crazydriver.screens;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mony.crazydriver.CrazyDriver;
import com.mony.crazydriver.util.Constants;

/**
 * Pantalla de configuración del juego
 * @author Santiago Faci
 * @version 1.0
 *
 */
public class ConfigurationScreen implements Screen {

	CrazyDriver game;
	Stage stage;
	// Almacena las preferencias (en %UserProfile%/.prefs/PreferencesName)
	Preferences prefs;
	GameScreen gameScreen;
	public ConfigurationScreen(CrazyDriver game,GameScreen gameScreen) {
		this.game = game;
		this.gameScreen=gameScreen;
	}
	
	private void loadScreen() {
		
	
		stage = new Stage();
					

		Table table = new Table();
		table.setPosition(Constants.SCREEN_WIDTH / 2.5f, Constants.SCREEN_HEIGHT / 1.5f);

	    table.setFillParent(true);
	    table.setHeight(500);
	    stage.addActor(table);
		
		Label label = new Label("Configurar CrazyDriver", game.getSkin());
		table.addActor(label);
		
		final CheckBox checkSound = new CheckBox(" Sonido", game.getSkin());
		checkSound.setChecked(prefs.getBoolean("sound"));
		checkSound.setPosition(label.getOriginX(), label.getOriginY() - 40);
		checkSound.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;	
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				
				prefs.putBoolean("sound", checkSound.isChecked());
			}
		});
		table.addActor(checkSound);
		
		TextButton buttonMainMenu = new TextButton("Volver", game.getSkin());
		buttonMainMenu.setPosition(label.getOriginX(), label.getOriginY() - 220);
		buttonMainMenu.setWidth(200);
		buttonMainMenu.setHeight(40);
		buttonMainMenu.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;	
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				
				prefs.flush();
				dispose();
				game.setScreen(new InGameMenuScreen(game,gameScreen));
			}
		});
		table.addActor(buttonMainMenu);
		
		Gdx.input.setInputProcessor(stage);
	}
	
	/**
	 * Carga las preferencias del juego
	 */
	private void loadPreferences() {
		
		prefs = Gdx.app.getPreferences(Constants.APP);
		
		// Coloca los valores por defecto (para la primera ejecución)
		if (!prefs.contains("sound"))
			prefs.putBoolean("sound", true);
	}
	
	@Override
	public void show() {
	
		loadPreferences();
		loadScreen();
	}
	
	@Override
	public void render(float dt) {
	
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
		stage.act(dt);
		stage.draw();
	}

	@Override
	public void dispose() {
	
		stage.dispose();
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
