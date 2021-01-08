package com.example.wordapp.common;

import android.content.Context;
import android.content.SharedPreferences;

public class Memory {

    private static final String SHARED_PREFERENCES_NAME = "com.example.wordapp";
    private static String highStartKey = "theme_%d_difficulty_%d";

    public static int getHighStars(int theme, int category) {

        SharedPreferences sharedPreferences = Shared.context.getSharedPreferences(SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        String key = String.format(highStartKey, theme, category);
        return sharedPreferences.getInt(key, 0);
    }



}
