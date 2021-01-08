package com.example.wordapp.fragments;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import com.example.wordapp.R;
import com.example.wordapp.common.Memory;
import com.example.wordapp.common.Shared;
import com.example.wordapp.events.ui.CategorySelectedEvent;
import com.example.wordapp.events.ui.DifficultySelectedEvent;
import com.example.wordapp.model.Category;
import com.example.wordapp.modes.Mode;
import com.example.wordapp.ui.DifficultyView;

public class DifficultySelectFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        View view = LayoutInflater.from(Shared.context).inflate(R.layout.difficulty_select_fragment, container, false);
        //Theme theme = Shared.engine.getSelectedTheme();
        Mode mode = Shared.engine.getSelectedMode();
        Category category = Shared.engine.getSelectedCategory();

        DifficultyView difficulty1 = (DifficultyView) view.findViewById(R.id.select_difficulty_1);
        difficulty1.setDifficulty(1, Memory.getHighStars(mode.id, 1));
        setOnClick(difficulty1, 1);

        DifficultyView difficulty2 = (DifficultyView) view.findViewById(R.id.select_difficulty_2);
        difficulty2.setDifficulty(2, Memory.getHighStars(mode.id, 2));
        setOnClick(difficulty2, 2);

        DifficultyView difficulty3 = (DifficultyView) view.findViewById(R.id.select_difficulty_3);
        difficulty3.setDifficulty(3, Memory.getHighStars(mode.id, 3));
        setOnClick(difficulty3, 3);



        animate(difficulty1, difficulty2, difficulty3);

        Typeface type = Typeface.createFromAsset(Shared.context.getAssets(), "fonts/grobold.ttf");


        TextView text1 = (TextView) view.findViewById(R.id.time_difficulty_1);
        text1.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text1.setTypeface(type);
        text1.setText(getBestTimeForStage());

        TextView text2 = (TextView) view.findViewById(R.id.time_difficulty_2);
        text2.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text2.setTypeface(type);
        text2.setText(getBestTimeForStage());

        TextView text3 = (TextView) view.findViewById(R.id.time_difficulty_3);
        text3.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text3.setTypeface(type);
        text3.setText(getBestTimeForStage());

        return view;

    }

    private String getBestTimeForStage() {
        String result = "ΚΑΛΥΤΕΡΟΣ : 00:60";
        return result;
    }

    private void animate(View... view) {
        AnimatorSet animatorSet = new AnimatorSet();
        Builder builder = animatorSet.play(new AnimatorSet());
        for (int i = 0; i < view.length; i++) {
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(view[i], "scaleX", 0.8f, 1f);
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(view[i], "scaleY", 0.8f, 1f);
            builder.with(scaleX).with(scaleY);
        }
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.start();
    }

    private void setOnClick(View view, final int difficulty) {
        view.setOnClickListener(new View.OnClickListener() { public void onClick(View v) {Shared.eventBus.notify(new DifficultySelectedEvent(difficulty)); }});

    }


}
