package com.example.wordapp.events.ui;

import com.example.wordapp.events.AbstractEvent;
import com.example.wordapp.events.EventObserver;
import com.example.wordapp.modes.Mode;

public class GameSelectedEvent extends AbstractEvent {

	public static final String TYPE = GameSelectedEvent.class.getName();
	public final Mode mode;

	public GameSelectedEvent(Mode mode) {
		this.mode = mode;
	}

	@Override
	protected void fire(EventObserver eventObserver) {
		eventObserver.onEvent(this);
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
