package com.mony.crazydriver.characters;




import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.mony.crazydriver.managers.SpriteManager;
import com.mony.crazydriver.util.Constants;


public class Objetos extends Character{
	private float speed=0f;
	private long ultimoObjeto;
	public Objetos(Animation animation, float x, float y,float velocidad) {
		super(animation, x, y);
		velocidad=this.speed;
	}
	@Override
	public void update(float dt){
		super.update(dt);
		
		if (TimeUtils.nanoTime() - ultimoObjeto > 5099000000l){
			 position.x = MathUtils.random(0, 500-16);
			 position.y = MathUtils.random(0, 500-16);
			 rect.x=position.x;
			 rect.y=position.y;
			
			ultimoObjeto=TimeUtils.nanoTime();
		}
		
	}
}
