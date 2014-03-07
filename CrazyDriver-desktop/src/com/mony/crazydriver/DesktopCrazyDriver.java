package com.mony.crazydriver;



import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mony.crazydriver.util.Constants;


/**
 * Clase principal de la versión de escritorio (PC) del juego
 *
 */
public class DesktopCrazyDriver {

	public static void main(String[] args) {
		LwjglApplicationConfiguration configuracion = new LwjglApplicationConfiguration();
		configuracion.title = "CrazyDriver";

		configuracion.width = Constants.SCREEN_WIDTH;
		configuracion.height = Constants.SCREEN_HEIGHT;
				
		new LwjglApplication(new CrazyDriver(), configuracion);
	}
}
