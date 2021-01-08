package com.example.wordapp.events.ui;

import com.example.wordapp.events.AbstractEvent;
import com.example.wordapp.events.EventObserver;
import com.example.wordapp.model.Category;

public class CategorySelectedEvent  extends AbstractEvent {

    public static final String TYPE = CategorySelectedEvent.class.getName();

    public final Category category;

    public CategorySelectedEvent(Category category) { this.category = category; }

    @Override
    protected void fire(EventObserver eventObserver) {
        eventObserver.onEvent(this);
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
