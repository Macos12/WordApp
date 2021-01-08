package com.example.wordapp;

import android.app.Application;

import com.example.wordapp.utils.FontLoader;

public class GameApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		FontLoader.loadFonts(this);

	}
}
