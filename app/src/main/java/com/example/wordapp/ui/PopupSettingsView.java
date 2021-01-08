package com.example.wordapp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wordapp.R;
import com.example.wordapp.utils.FontLoader;
import com.example.wordapp.utils.FontLoader.Font;

public class PopupSettingsView extends LinearLayout {

	private ImageView mSoundImage;
	private TextView mSoundText;
	private int c=0;
	public PopupSettingsView(Context context) {
		this(context, null);
	}

	public PopupSettingsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOrientation(LinearLayout.VERTICAL);
		setBackgroundResource(R.drawable.settings_popup);
		LayoutInflater.from(getContext()).inflate(R.layout.popup_settings_view, this, true);
		mSoundText = (TextView) findViewById(R.id.sound_off_text);
		TextView rateView = (TextView) findViewById(R.id.rate_text);
		FontLoader.setTypeface(context, new TextView[] { mSoundText, rateView }, Font.GROBOLD);
		mSoundImage = (ImageView) findViewById(R.id.sound_image);
		View soundOff = findViewById(R.id.sound_off);
		soundOff.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				c++;
				setMusicButton(c);
			}
		});
		View rate = findViewById(R.id.rate);
		rate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//rate
			}
		});
		setMusicButton(c);
	}

	private void setMusicButton(int music) {
		if (music % 2 == 1) {
			mSoundText.setText("Ήχος κλειστός");
			mSoundImage.setImageResource(R.drawable.button_music_off);
		} else {
			mSoundText.setText("Ήχος ανοιχτός");
			mSoundImage.setImageResource(R.drawable.button_music_on);
		}
	}
}
