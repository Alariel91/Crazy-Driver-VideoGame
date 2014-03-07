package com.mony.crazydriver.managers;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ResourceManager {
	
	private static Map<String,Animation> animations=new HashMap<String,Animation>();
	private static Map<String,TextureAtlas> atlas= new HashMap<String,TextureAtlas>();
	
	private static Map<String,Sound> sounds= new HashMap<String,Sound>();
	//cargar en memoria todos los recursos del programa 
	public static void loadAllResources(){
		
		loadResource("imagenes",new TextureAtlas(Gdx.files.internal("imagenes/crazydriver.pack")));
	
		
		animations.put("car_up",
				new Animation(0.25f,
				getAtlas("imagenes").findRegion("car_up")));
		
		animations.put("car_down",
				new Animation(0.25f,
				getAtlas("imagenes").findRegion("car_up")));
		
		animations.put("car_right",
				new Animation(0.25f,
				getAtlas("imagenes").findRegion("car_up")));
		
		animations.put("car_left",
				new Animation(0.25f,
				getAtlas("imagenes").findRegion("car_up")));
		
		animations.put("car_azul",
				new Animation(0.25f,
				getAtlas("imagenes").findRegion("azul_on"),
				getAtlas("imagenes").findRegion("azul_off")));
		
		animations.put("camion",
				new Animation(0.25f,
				getAtlas("imagenes").findRegion("camion_lucesoon"),
				getAtlas("imagenes").findRegion("camion_lucesoff")));
		
		animations.put("car_gris",
				new Animation(0.25f,
				getAtlas("imagenes").findRegion("gris_on"),
				getAtlas("imagenes").findRegion("gris_off")));
		
		
		animations.put("chica_rubia",
				new Animation(0.25f,
				getAtlas("imagenes").findRegion("r1"),
				getAtlas("imagenes").findRegion("r2")));
		
		animations.put("chica_morena",
				new Animation(0.25f,
				getAtlas("imagenes").findRegion("m1"),
				getAtlas("imagenes").findRegion("m2")));
		
		animations.put("woman_andando",
				new Animation(0.25f,
				getAtlas("imagenes").findRegion("woman_andando"),
				getAtlas("imagenes").findRegion("woman_andando2")));
		
		animations.put("enemy_pink",
				new Animation(0.25f,
				getAtlas("imagenes").findRegion("enemy_pink")));
		//sonidos
		ResourceManager.loadResource("atropellar", Gdx.audio.newSound(Gdx.files.internal("collision_squash.wav")));	
		ResourceManager.loadResource("shit", Gdx.audio.newSound(Gdx.files.internal("shit.wav")));
		ResourceManager.loadResource("ty", Gdx.audio.newSound(Gdx.files.internal("ty.mp3")));
		
	}
	
	private static void loadResource(String name,TextureAtlas texture){
		atlas.put(name, texture);
	}
	
	private static void loadResource(String name,Sound sound){
		sounds.put(name, sound);
	}
	public static Animation getAnimation(String name){
		return animations.get(name);
		
	}
	public static TextureAtlas getAtlas(String name) {
		
		return atlas.get(name);
	}
	
	public static Sound getSound(String name) {
		
		return sounds.get(name);
	}
	
}
