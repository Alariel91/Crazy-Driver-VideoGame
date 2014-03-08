package com.mony.crazydriver.characters;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Character {
	Vector2 position;
	Animation animation;
	TextureRegion currentFrame;
	float stateTime;
	public Rectangle rect;
	Texture texture;
	
	public Character(Animation animation,float x,float y){
		
		this.animation=animation;
		currentFrame=animation.getKeyFrame(0);
		position = new Vector2(x,y);
		
		
		rect=new Rectangle(x,y,
				animation.getKeyFrame(0).getRegionWidth(),
				animation.getKeyFrame(0).getRegionHeight());
	}
	
	public Character(TextureRegion texture,float x,float y){
		
		currentFrame=texture;
		position = new Vector2(x,y);
		
		
		rect=new Rectangle(x,y,
				currentFrame.getRegionWidth(),
				currentFrame.getRegionHeight());
		
	}
	
	public void render(SpriteBatch batch){
		batch.draw(currentFrame,position.x,position.y);
	}
	public void update(float dt,long ultimaPersona){
		//tiempo que llevo jugando
		stateTime+=dt;
		//se repite la animacion con el tiempo de juego
		if(animation!=null)
		currentFrame=animation.getKeyFrame(stateTime,true);
	
	}
	
	public void update(float dt){
		//tiempo que llevo jugando
		stateTime+=dt;
		//se repite la animacion con el tiempo de juego
		if(animation!=null)
		currentFrame=animation.getKeyFrame(stateTime,true);
	
	}
	
}
