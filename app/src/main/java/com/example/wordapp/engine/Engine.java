package com.example.wordapp.engine;

import android.os.Handler;
import android.widget.ImageView;

import com.example.wordapp.common.Shared;
import com.example.wordapp.engine.ScreenController.Screen;
import com.example.wordapp.events.EventObserverAdapter;
import com.example.wordapp.events.ui.CategorySelectedEvent;
import com.example.wordapp.events.ui.DifficultySelectedEvent;
import com.example.wordapp.events.ui.StartEvent;
import com.example.wordapp.events.ui.GameSelectedEvent;
import com.example.wordapp.fragments.SelectGameFragment;
import com.example.wordapp.model.Category;
import com.example.wordapp.model.Game;
import com.example.wordapp.modes.Mode;

public class Engine extends EventObserverAdapter {

	private static Engine mInstance = null;
	private Game mPlayingGame = null;
	private ScreenController mScreenController;
	private Mode mSelectedMode;
	private Category mSelectedCategory;
	private ImageView mBackgroundImage;
	private Handler mHandler;

	private Engine() {
		mScreenController = ScreenController.getInstance();
		mHandler = new Handler();
	}

	public static Engine getInstance() {
		if (mInstance == null) {
			mInstance = new Engine();
		}
		return mInstance;
	}

	public void start() {
		Shared.eventBus.listen(DifficultySelectedEvent.TYPE, this);
		Shared.eventBus.listen(CategorySelectedEvent.TYPE, this);
		Shared.eventBus.listen(StartEvent.TYPE, this);
		Shared.eventBus.listen(GameSelectedEvent.TYPE, this);
	}

	public void stop() {
		mPlayingGame = null;
		mBackgroundImage.setImageDrawable(null);
		mBackgroundImage = null;
		mHandler.removeCallbacksAndMessages(null);
		mHandler = null;

		Shared.eventBus.unlisten(DifficultySelectedEvent.TYPE, this);
		Shared.eventBus.unlisten(CategorySelectedEvent.TYPE, this);
		Shared.eventBus.unlisten(StartEvent.TYPE, this);
		Shared.eventBus.unlisten(GameSelectedEvent.TYPE, this);

		mInstance = null;
	}

	@Override
	public void onEvent(StartEvent event) {
		mScreenController.openScreen(Screen.THEME_SELECT);
	}

	@Override
	public void onEvent(GameSelectedEvent event) {
		mSelectedMode = event.mode;
		mScreenController.openScreen(Screen.CATEGORY);

	}
	@Override
	public void onEvent(CategorySelectedEvent event) {
		mSelectedCategory=event.category;
		mScreenController.openScreen(Screen.DIFFICULTY);
	}
	@Override
	public void onEvent(DifficultySelectedEvent event) {
		mPlayingGame = new Game();
		mPlayingGame.mode = mSelectedMode;
		mPlayingGame.category=mSelectedCategory;
		if (mSelectedMode.id==1)
		{
			if (mSelectedCategory.id==1)
			{
				mScreenController.openScreen(Screen.GAMETF);
			}
			else if (mSelectedCategory.id==2)
			{
				mScreenController.openScreen(Screen.GAME);
			}
		}
		else if (mSelectedMode.id==2)
		{
			if (mSelectedCategory.id==1)
			{
				mScreenController.openScreen(Screen.GAMETF1VS1);
			}
			else if (mSelectedCategory.id==2)
			{
				mScreenController.openScreen(Screen.GAME1VS1);
			}
		}
		else if (mSelectedMode.id==3)
		{
			if (mSelectedCategory.id==1)
			{
				mScreenController.openScreen(Screen.GAMETF);
			}
			else if (mSelectedCategory.id==2)
			{
				mScreenController.openScreen(Screen.GAME);
			}
		}
	}

	public Mode getSelectedMode() {
		return mSelectedMode;
	}

	public Category getSelectedCategory() { return mSelectedCategory;}

	public void setBackgroundImageView(ImageView backgroundImage) {
		mBackgroundImage = backgroundImage;
	}
}
