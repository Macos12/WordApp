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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wordapp.R;
import com.example.wordapp.common.Shared;

public class Game1vs1Fragment extends BaseFragment {

    private ImageView TimeImage,TimeImage1;
    private TextView Time,Time1;
    private LinearLayout ads;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.game_1vs1fragment, container, false);
        //getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //view?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        Time = (TextView) view.findViewById(R.id.time_bar_text);
        TimeImage = (ImageView) view.findViewById(R.id.time_bar_image);
        Time1 = (TextView) view.findViewById(R.id.time_bar_text1);
        TimeImage1 = (ImageView) view.findViewById(R.id.time_bar_image1);

        Typeface type = Typeface.createFromAsset(Shared.context.getAssets(), "fonts/grobold.ttf");


        TextView text1 = (TextView) view.findViewById(R.id.choice1);
        text1.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text1.setTypeface(type);
        text1.setText("Επιλογή 1");

        TextView text2 = (TextView) view.findViewById(R.id.choice2);
        text2.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text2.setTypeface(type);
        text2.setText("Επιλογή 2");

        TextView text3 = (TextView) view.findViewById(R.id.choice3);
        text3.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text3.setTypeface(type);
        text3.setText("Επιλογή 3");

        TextView text4 = (TextView) view.findViewById(R.id.choice4);
        text4.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text4.setTypeface(type);
        text4.setText("Επιλογή 4");

        animate(text1,text2,text3,text4);

        TextView text5 = (TextView) view.findViewById(R.id.choice5);
        text5.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text5.setTypeface(type);
        text5.setText("Επιλογή 1");

        TextView text6 = (TextView) view.findViewById(R.id.choice6);
        text6.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text6.setTypeface(type);
        text6.setText("Επιλογή 2");

        TextView text7 = (TextView) view.findViewById(R.id.choice7);
        text7.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text7.setTypeface(type);
        text7.setText("Επιλογή 3");

        TextView text8 = (TextView) view.findViewById(R.id.choice8);
        text8.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text8.setTypeface(type);
        text8.setText("Επιλογή 4");

        animate(text5,text6,text7,text8);

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
