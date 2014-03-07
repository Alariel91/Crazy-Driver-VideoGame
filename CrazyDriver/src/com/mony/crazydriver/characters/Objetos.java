package com.mony.crazydriver.characters;




import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.mony.crazydriver.managers.SpriteManager;
import com.mony.crazydriver.util.Constants;


public class Objetos extends Character{
	private float speed=0f;
	public Objetos(Animation animation, float x, float y,float velocidad) {
		super(animation, x, y);
		velocidad=this.speed;
	}
	@Override
	public void update(float dt){
		super.update(dt);
		
	}
}
