package com.example.wordapp.engine;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.wordapp.R;
import com.example.wordapp.common.Shared;
import com.example.wordapp.fragments.CategoryFragment;
import com.example.wordapp.fragments.DifficultySelectFragment;
import com.example.wordapp.fragments.Game1vs1Fragment;
import com.example.wordapp.fragments.GameFragment;
import com.example.wordapp.fragments.GameTf1vs1Fragment;
import com.example.wordapp.fragments.GameTfFragment;
import com.example.wordapp.fragments.MenuFragment;
import com.example.wordapp.fragments.SelectGameFragment;


public class ScreenController {

	private static ScreenController mInstance = null;
	private static List<Screen> openedScreens = new ArrayList<Screen>();
	private FragmentManager mFragmentManager;

	private ScreenController() {
	}

	public static ScreenController getInstance() {
		if (mInstance == null) {
			mInstance = new ScreenController();
		}
		return mInstance;
	}

	public static enum Screen {
		MENU,
		GAME,
		DIFFICULTY,
		CATEGORY,
		THEME_SELECT,
		GAMETF,
		GAMETF1VS1,
		GAME1VS1
	}
	
	public static Screen getLastScreen() {
		return openedScreens.get(openedScreens.size() - 1);
	}

	public void openScreen(Screen screen) {
		mFragmentManager = Shared.activity.getSupportFragmentManager();
		
		if (screen == Screen.GAME && openedScreens.get(openedScreens.size() - 1) == Screen.GAME) {
			openedScreens.remove(openedScreens.size() - 1);
		} else if (screen == Screen.DIFFICULTY && openedScreens.get(openedScreens.size() - 1) == Screen.GAME) {
			openedScreens.remove(openedScreens.size() - 1);
			openedScreens.remove(openedScreens.size() - 1);
		}
		else if (screen == Screen.CATEGORY && screen == Screen.DIFFICULTY && openedScreens.get(openedScreens.size() - 1) == Screen.GAME) {
			openedScreens.remove(openedScreens.size() - 1);
			openedScreens.remove(openedScreens.size() - 1);
			openedScreens.remove(openedScreens.size() - 1);
		}
		Fragment fragment = getFragment(screen);
		FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.fragment_container, fragment);
		fragmentTransaction.commit();
		openedScreens.add(screen);
	}

	public boolean onBack() {
		if (openedScreens.size() > 0) {
			Screen screenToRemove = openedScreens.get(openedScreens.size() - 1);
			openedScreens.remove(openedScreens.size() - 1);
			if (openedScreens.size() == 0) {
				return true;
			}
			Screen screen = openedScreens.get(openedScreens.size() - 1);
			openedScreens.remove(openedScreens.size() - 1);
			openScreen(screen);
			return false;
		}
		return true;
	}

	private Fragment getFragment(Screen screen) {
		switch (screen) {
			case GAME:
				return new GameFragment();
			case MENU:
				return new MenuFragment();
			case DIFFICULTY:
				return new DifficultySelectFragment();
			case CATEGORY:
				return new CategoryFragment();
			case THEME_SELECT:
				return new SelectGameFragment();
			case GAMETF:
				return new GameTfFragment();
				case GAMETF1VS1:
					return new GameTf1vs1Fragment();
			case GAME1VS1:
				return new Game1vs1Fragment();

		default:
			break;
		}
		return null;
	}
}
