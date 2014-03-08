package com.mony.crazydriver.managers;






import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.mony.crazydriver.CrazyDriver;
import com.mony.crazydriver.characters.Enemy;
import com.mony.crazydriver.characters.Car;
import com.mony.crazydriver.characters.Friend;
import com.mony.crazydriver.characters.Objetos;
import com.mony.crazydriver.screens.EndScreen;
import com.mony.crazydriver.screens.GameOverScreen;



public class SpriteManager {
//actualiza la logica del juego (choques, mover las cosas...)
	CrazyDriver game;
	Car car;
	Sprite sprite;
	Array<Enemy> enemies;
	Array<Friend> friends;
	Array<Objetos> objetos;

	private Texture texture;
	float scrollTimer=0;
	long ultimaPersona;
	long ultimoObjeto;
	LevelManager levelManager;

	
	public SpriteManager(CrazyDriver game){
		//poner donde empieza el coche en 150 x y en 0 y
		car = new Car(ResourceManager.getAtlas("imagenes")
				   .findRegion("car_up"), 150, 0);
		//instancia los arrays de amigos y enemigos	
		enemies=new Array<Enemy>();
		friends=new Array<Friend>();
		objetos=new Array<Objetos>();
		//esto es para que el fondo de mueva
		texture = new Texture(Gdx.files.internal("suelo/tunnel_road.jpg"));
		texture.setWrap(TextureWrap.Repeat,TextureWrap.Repeat);
		sprite = new Sprite(texture, 0, 0, 512, 512);
		//genero aleatoriamente peatones
		//generarPersonas();
		generarObjetos();
		this.game = game;

	}
	public void setLevelManager(LevelManager levelManager){
		this.levelManager=levelManager;
	}
	public  void finishLevel() {
		enemies.clear();
		friends.clear();
	}
	
	public void render(SpriteBatch batch){
		Gdx.gl.glClearColor(0, 0, 0, 1);
		  //Limpio la pantalla en el bucle render todo el rato.
		  Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		  batch.begin();
		  batch.draw(sprite,0,0);
		  //tengo que multiplicar x 0.2f para que vaya mas despacio
		  scrollTimer+=Gdx.graphics.getDeltaTime()*0.2f;
		  
		   if(scrollTimer>1.0f)
		         scrollTimer = 0.0f;

		  	sprite.setV(scrollTimer);
		    sprite.setV2(scrollTimer-1);
		 
		    car.render(batch);
		    
		    for (Enemy enemy : enemies) {
				enemy.render(batch);
			}
		    for (Friend friend : friends) {
				friend.render(batch);
			}
		   
		    for (Objetos objeto : objetos) {
		    	objeto.render(batch);
			}
		  
		batch.end();
	}
	public void update(float dt){
		handleInput(dt);
		
		if(car.getScore()==5 && levelManager.getCurrentLevel()==1){
			car.setScore(0);
			levelManager.currentLevel=2;
			finishLevel();
			levelManager.loadNextLevel();
			  }
		if(car.getScore()==10 && levelManager.getCurrentLevel()==2){
			game.setScreen(new EndScreen(game));

		}	  
		car.update(dt);
		for (Friend friend : friends) {
			friend.update(dt);
		}
		for(Enemy enemy:enemies){
			enemy.update(dt);
		}
		for (Objetos objeto : objetos) {
		    objeto.update(dt);
		}
		checkCollisions(dt);
		
		if (TimeUtils.nanoTime() - ultimaPersona > 2099000000){
			generarPersonas();
		}
		System.out.println(car.getSpeed());
		
		
	}
	private void handleInput(float dt){
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			car.state = Car.State.LEFT;
			car.move(new Vector2(-dt, 0));
		}
		else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			car.state = Car.State.RIGHT;
			car.move(new Vector2(dt, 0));
		}
		else if (Gdx.input.isKeyPressed(Keys.UP)) {
			car.state = Car.State.UP;
			car.move(new Vector2(0, dt));
		}
		else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			car.state = Car.State.DOWN;
			car.move(new Vector2(0, -dt));
		}
		else 
			car.state = Car.State.IDLE;
	}
	private void checkCollisions(float dt){
		//Cuando un coche choca con un peatón
		Enemy enemy = null;
		Friend friend=null;
		Objetos objeto=null;
		for (int i = enemies.size-1; i >= 0; i--) {
			enemy = enemies.get(i);
			for (int j = friends.size-1; j >= 0; j--) {
				friend=friends.get(j);
				if(enemy.rect.overlaps(friend.rect)){
					friends.removeIndex(j);
					if (game.configurationManager.isSoundEnabled()){
					ResourceManager.getSound("atropellar").play();
					}
				}
			}
			
			}
		
		//Cuando un coche choca con un monstruo rosita
		for (int i = enemies.size-1; i >= 0; i--) {
			enemy = enemies.get(i);
			for (int j = objetos.size-1; j >= 0; j--) {
				objeto=objetos.get(j);
				if(enemy.rect.overlaps(objeto.rect)){
					objetos.removeIndex(j);
					if(car.getSpeed()>150){
						generarObjetos();
						}
					
				}
			}
			
			}
			
		//cuando mi coche choca con un enemigo coche	
		for (Enemy enemy1 : enemies) {
			if(car.rect.overlaps(enemy1.rect)){
				if (game.configurationManager.isSoundEnabled()){
				ResourceManager.getSound("shit").play();
				}
				game.setScreen(new GameOverScreen(game));
			}
		}
		//cuando recojo personas
		for (int i = friends.size-1; i >=0; i--) {
			friend=friends.get(i);
			if(car.rect.overlaps(friend.rect)){
				if (game.configurationManager.isSoundEnabled()){
				ResourceManager.getSound("ty").play();
				}
				car.addScore(1);
				friends.removeIndex(i);
			}
		}
		//si cojo un mostruo rosa me quita 50 de velocidad en el coche
		for (int i = objetos.size-1; i >= 0; i--) {
			objeto=objetos.get(i);
			if(car.rect.overlaps(objeto.rect)){
				car.setSpeed(car.getSpeed()-50);
				objetos.removeIndex(i);
				if(car.getSpeed()>150){
				generarObjetos();
				}
			}
		}
	
	}
	
	public void generarPersonas(){
			int x = MathUtils.random(0, 512 - 32);
			int y = MathUtils.random(0, 512-55);
		  Friend friend = new Friend(ResourceManager.getAnimation("woman_andando"), x, y,50f);
		  friends.add(friend);
	
		  ultimaPersona = TimeUtils.nanoTime();
	}
	
	public void generarObjetos(){
		int x = MathUtils.random(0, 500-16);
		int y = MathUtils.random(0, 500-16);
		Objetos objeto = new Objetos(ResourceManager.getAnimation("enemy_pink"), x, y,0f);
		objetos.add(objeto);
	
	}
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	
}
