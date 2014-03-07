package com.mony.crazydriver.characters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.mony.crazydriver.util.Constants;

public class Enemy extends Character{
	float speed;
	public Enemy(Animation animation, float x, float y,float speed) {
		super(animation, x, y);
	this.speed=speed;
	}
	@Override
	public void update(float dt){
		super.update(dt);
		//va hacia la derecha
		position.add(new Vector2(0,-dt*speed));
		
		rect.x=position.x;
		rect.y=position.y;
		
		if(position.y < 0 - rect.height)
			position.y = Constants.SCREEN_HEIGHT;
	}
}
