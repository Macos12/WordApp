package com.example.wordapp.events;

import com.example.wordapp.events.ui.BackGameEvent;
import com.example.wordapp.events.ui.CategorySelectedEvent;
import com.example.wordapp.events.ui.GameSelectedEvent;
import com.example.wordapp.events.ui.DifficultySelectedEvent;
import com.example.wordapp.events.ui.StartEvent;


public class EventObserverAdapter implements EventObserver {

	@Override
	public void onEvent(DifficultySelectedEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(CategorySelectedEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(StartEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(GameSelectedEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(BackGameEvent event) {
		throw new UnsupportedOperationException();
	}

}
