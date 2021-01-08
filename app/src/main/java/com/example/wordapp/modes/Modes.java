package com.example.wordapp.modes;



public class Modes {

	public static String URI_DRAWABLE = "drawable://";

	public static Mode Train() {
		Mode mode = new Mode();
		mode.id = 1;
		mode.backgroundImageUrl = URI_DRAWABLE + "background";

		return mode;
	}

	public static Mode oneVSone() {
		Mode mode = new Mode();
		mode.id = 2;
		mode.backgroundImageUrl = URI_DRAWABLE + "background";

		return mode;
	}

	public static Mode Online() {
		Mode mode = new Mode();
		mode.id = 3;
		mode.backgroundImageUrl = URI_DRAWABLE + "background";

		return mode;
	}
	


}
