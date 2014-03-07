package com.mony.crazydriver.managers;

import com.mony.crazydriver.characters.Enemy;


public class LevelManager {
	SpriteManager spriteManager;
	public int currentLevel;
	public LevelManager(SpriteManager spriteManager){
		this.spriteManager=spriteManager;
		this.currentLevel=1;
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}
	public void loadCurrentLevel(){
	
		Enemy cocheazul=new Enemy(ResourceManager.getAnimation("car_azul"),20,500,150f);
		spriteManager.enemies.add(cocheazul);
		
		Enemy cochegris=new Enemy(ResourceManager.getAnimation("car_gris"),150,500,200);
		spriteManager.enemies.add(cochegris);
		
		Enemy camion=new Enemy(ResourceManager.getAnimation("camion"),300,500,130f);
		spriteManager.enemies.add(camion);
		
		Enemy cocheazul2=new Enemy(ResourceManager.getAnimation("car_azul"),410,500,210f);
		spriteManager.enemies.add(cocheazul2);
		
	}
	public void loadNextLevel(){
		spriteManager.enemies.clear();
		SpriteManager.friends.clear();
		SpriteManager.objetos.clear();
		Enemy cocheazul=new Enemy(ResourceManager.getAnimation("car_azul"),20,500,190f);
		spriteManager.enemies.add(cocheazul);
		
		Enemy cochegris=new Enemy(ResourceManager.getAnimation("car_gris"),150,500,230f);
		spriteManager.enemies.add(cochegris);
		
		Enemy camion=new Enemy(ResourceManager.getAnimation("camion"),300,500,200f);
		spriteManager.enemies.add(camion);
		
		Enemy cocheazul2=new Enemy(ResourceManager.getAnimation("car_azul"),410,500,210f);
		spriteManager.enemies.add(cocheazul2);
		
		SpriteManager.generarPersonas();
		SpriteManager.generarObjetos();
	}
	

}
