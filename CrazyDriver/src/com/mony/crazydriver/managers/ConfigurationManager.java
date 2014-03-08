package com.mony.crazydriver.managers;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.mony.crazydriver.util.Constants;

public class ConfigurationManager {
private Preferences prefs;
	
	public ConfigurationManager() {
		prefs = Gdx.app.getPreferences(Constants.APP);
	}
	
	public boolean isSoundEnabled() {
		
		return prefs.getBoolean("sound");
	}
	
}
