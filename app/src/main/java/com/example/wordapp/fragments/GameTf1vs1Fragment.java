package com.example.wordapp.fragments;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wordapp.R;
import com.example.wordapp.common.Shared;

public class GameTf1vs1Fragment extends BaseFragment {

    private ImageView TimeImage,TimeImage1;
    private TextView Time,Time1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.gametf_1vs1fragment, container, false);


        Time = (TextView) view.findViewById(R.id.time_bar_text);
        Time1 = (TextView) view.findViewById(R.id.time_bar_text1);
        TimeImage = (ImageView) view.findViewById(R.id.time_bar_image);
        TimeImage1 = (ImageView) view.findViewById(R.id.time_bar_image1);

        Typeface type = Typeface.createFromAsset(Shared.context.getAssets(), "fonts/grobold.ttf");

        TextView text0 = (TextView) view.findViewById(R.id.question);
        text0.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text0.setTypeface(type);
        text0.setText("Ερώτηση Εδώ");

        TextView text1 = (TextView) view.findViewById(R.id.truee);
        text1.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text1.setTypeface(type);
        text1.setText("Σωστό");

        TextView text2 = (TextView) view.findViewById(R.id.falsee);
        text2.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text2.setTypeface(type);
        text2.setText("Λάθος");

        animate(text1,text2);

        TextView text3 = (TextView) view.findViewById(R.id.question1);
        text3.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text3.setTypeface(type);
        text3.setText("Ερώτηση Εδώ");

        TextView text4 = (TextView) view.findViewById(R.id.truee1);
        text4.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text4.setTypeface(type);
        text4.setText("Σωστό");

        TextView text5 = (TextView) view.findViewById(R.id.falsee1);
        text5.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text5.setTypeface(type);
        text5.setText("Λάθος");

        animate(text4,text5);

        return view;
    }

    private void animate(View... view) {
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet.Builder builder = animatorSet.play(new AnimatorSet());
        for (int i = 0; i < view.length; i++) {
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(view[i], "scaleX", 0.8f, 1f);
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(view[i], "scaleY", 0.8f, 1f);
            builder.with(scaleX).with(scaleY);
        }
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.start();
    }
}
