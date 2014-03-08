package com.mony.crazydriver.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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
import com.mony.crazydriver.managers.ResourceManager;
import com.mony.crazydriver.util.Constants;

public class MainMenuScreen implements Screen{
	CrazyDriver game;
	Stage stage;
	Texture fondo;
	public MainMenuScreen(CrazyDriver game){
	 this.game = game;
	 
	 fondo = new Texture(Gdx.files.internal("imagenes/fondoinicio.png"));
	}
	
	private void loadScreen() {
		
		// Grafo de escena que contendrá todo el menú
		stage = new Stage();
					
		// Crea una tabla, donde añadiremos los elementos de menú
		Table table = new Table();
		table.setPosition(Constants.SCREEN_WIDTH/2.5f,Constants.SCREEN_HEIGHT/1.5f);
		// La tabla ocupa toda la pantalla
	    table.setFillParent(true);
	    table.setHeight(512);
	    stage.addActor(table);
		
	    // Etiqueta de texto
		Label label = new Label("", game.getSkin());
		label.setPosition(label.getOriginX()+20, label.getOriginY());
		table.addActor(label);
		
		// Botón
		TextButton buttonPlay = new TextButton("Jugar", game.getSkin());
		buttonPlay.setPosition(label.getOriginX()-50, label.getOriginY() - 60);
		buttonPlay.setWidth(200);
		buttonPlay.setHeight(40);
		buttonPlay.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				
				dispose();
				game.setScreen(new GameScreen(game));
				
	
			}
		});
		table.addActor(buttonPlay);
		
		// Botón
		   TextButton buttonHistory = new TextButton("Instrucciones", game.getSkin());
		   buttonHistory.setPosition(label.getOriginX()-50, label.getOriginY() - 180);
		   buttonHistory.setWidth(200);
		   buttonHistory.setHeight(40);
		   buttonHistory.addListener(new InputListener() {
		    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
		     return true;
		    }
		    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
		     
		     dispose();
		     game.setScreen(new Instructions(game));
		    }
		   });
		   table.addActor(buttonHistory);  
		   
		   
		   
		   Gdx.input.setInputProcessor(stage);	
		// Botón
		TextButton buttonQuit = new TextButton("Salir", game.getSkin());
		buttonQuit.setPosition(label.getOriginX()-50, label.getOriginY() - 120);
		buttonQuit.setWidth(200);
		buttonQuit.setHeight(40);
		buttonQuit.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;	
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				
				game.dispose();
				System.exit(0);
			}
		});
		table.addActor(buttonQuit);
		
		Gdx.input.setInputProcessor(stage);
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
	public void show() {
		loadScreen();
		
	}
	
	@Override
	public void dispose() {
		stage.dispose();
		
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

	

}
