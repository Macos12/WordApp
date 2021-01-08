package com.example.wordapp.events.ui;

import com.example.wordapp.events.AbstractEvent;
import com.example.wordapp.events.EventObserver;

/**
 * When the 'back to menu' was pressed.
 */
public class BackGameEvent extends AbstractEvent {

    public static final String TYPE = BackGameEvent.class.getName();

    @Override
    protected void fire(EventObserver eventObserver) {
        eventObserver.onEvent(this);
    }

    @Override
    public String getType() {
        return TYPE;
    }

}
