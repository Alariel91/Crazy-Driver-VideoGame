package com.mony.crazydriver;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mony.crazydriver.managers.ConfigurationManager;
import com.mony.crazydriver.screens.MainMenuScreen;
import com.mony.crazydriver.util.Constants;

public class CrazyDriver extends Game{
	OrthographicCamera camera;
	public SpriteBatch batch;
	public BitmapFont font;
	private Skin skin;
	public boolean paused;
	
	public ConfigurationManager configurationManager;
	
	@Override
	public void create() {
		configurationManager = new ConfigurationManager();
		batch= new SpriteBatch();
		font = new BitmapFont();
		
		// Crea la cámara y define la zona de visión del juego (toda la pantalla)
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		camera.update();

		setScreen(new MainMenuScreen(this));
	}
	@Override
	public void render() {
		super.render();
	}
	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}
	
	public Skin getSkin() {
        if(skin == null ) {
            skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        }
        return skin;
    }	
}
