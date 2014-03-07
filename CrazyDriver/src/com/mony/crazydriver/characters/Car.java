package com.mony.crazydriver.characters;


import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mony.crazydriver.managers.ResourceManager;
import com.mony.crazydriver.util.Constants;

public class Car extends Character{
	
	public float SPEED = 250f;
	
	public enum State {
		RIGHT, LEFT, UP, DOWN, IDLE
	}
	public State state;
	private int score;
	Animation rightAnimation;
	Animation leftAnimation;
	Animation upAnimation;
	Animation downAnimation;
	TextureRegion idleFrame;
	
	public Car(TextureRegion texture,float x, float y) {
		super(texture,x, y);
		idleFrame=texture;
		rightAnimation = ResourceManager.getAnimation("car_right");
		leftAnimation = ResourceManager.getAnimation("car_left");
		upAnimation = ResourceManager.getAnimation("car_up");
		 downAnimation = ResourceManager.getAnimation("car_down");
		  //La posicion inicial es idle
		  state= State.IDLE;
		  score = 0;
	}
	public void update(float dt) {
		
		// Calcula el tiempo para cargar el frame que proceda de la animación
		stateTime += dt;
		
		// Carga el frame según su posición y el momento del juego
		switch (state) {
		case RIGHT:
			currentFrame = rightAnimation.getKeyFrame(stateTime, true);
			break;
		case LEFT:
			currentFrame = leftAnimation.getKeyFrame(stateTime, true);
			break;
		case UP:
			currentFrame = upAnimation.getKeyFrame(stateTime, true);
			break;
		case DOWN:
			currentFrame = downAnimation.getKeyFrame(stateTime, true);
			break;
		case IDLE:
			currentFrame = idleFrame;
			break;
		default:
			currentFrame = idleFrame;
			
		}
		
	}
	public void move(Vector2 movement) {

		movement.scl(SPEED);
		position.add(movement);
		
		rect.x=position.x;
		rect.y=position.y;
		
		if (position.x <= 0)
			position.x = 0;
		
		if ((position.x + currentFrame.getRegionWidth()) > Constants.SCREEN_WIDTH)
			position.x = Constants.SCREEN_WIDTH - currentFrame.getRegionWidth();
		
		if (position.y <= 0)
			position.y = 0;
		
		if ((position.y + currentFrame.getRegionHeight()) > Constants.SCREEN_HEIGHT)
			position.y = Constants.SCREEN_HEIGHT - currentFrame.getRegionHeight();
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int score) {
		this.score += score;
	}
	public  float getSpeed() {
		return SPEED;
	}
	public void setSpeed(float speed) {
		this.SPEED=speed;
		
	}
}
