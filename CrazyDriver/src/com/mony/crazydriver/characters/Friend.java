package com.mony.crazydriver.characters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.mony.crazydriver.managers.SpriteManager;
import com.mony.crazydriver.util.Constants;

public class Friend extends Character{
	float speed;
	public Friend(Animation animation, float x, float y,float speed) {
		super(animation, x, y);
		this.speed=speed;
	}

	@Override
	public void update(float dt,long ultimaPersona){
		super.update(dt,ultimaPersona);
		if (TimeUtils.nanoTime() - ultimaPersona > 2099000000){
			   SpriteManager.generarPersonas();
			  }
		//va hacia la derecha
		position.add(new Vector2(dt*speed,0));
		
		rect.x=position.x;
		rect.y=position.y;
		
	}
}
