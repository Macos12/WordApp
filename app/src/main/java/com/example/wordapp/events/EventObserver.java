package com.example.wordapp.events;

import com.example.wordapp.events.ui.BackGameEvent;
import com.example.wordapp.events.ui.CategorySelectedEvent;
import com.example.wordapp.events.ui.DifficultySelectedEvent;
import com.example.wordapp.events.ui.StartEvent;
import com.example.wordapp.events.ui.GameSelectedEvent;


public interface EventObserver {

	void onEvent(DifficultySelectedEvent event);

	void onEvent(CategorySelectedEvent event);

	void onEvent(StartEvent event);

	void onEvent(GameSelectedEvent event);

	void onEvent(BackGameEvent event);
}
