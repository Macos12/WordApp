package com.example.wordapp.fragments;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.example.wordapp.model.Categories;
import com.example.wordapp.model.Category;
import com.example.wordapp.modes.Mode;
import com.example.wordapp.ui.CategoryView;
import com.example.wordapp.ui.DifficultyView;

public class CategoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(Shared.context).inflate(R.layout.theme_select_game_type_fragment, container, false);

        //CategoryView category1 = (CategoryView) view.findViewById(R.id.select_category_1);
        //category1.setCategory(1);
        //setOnClick(category1, 1);
        //CategoryView category2 = (CategoryView) view.findViewById(R.id.select_category_2);
        //category2.setCategory(2);
        //setOnClick(category2, 2);

        final Category truefalse = Categories.TrueFalse();
        final Category multiple = Categories.Multiple();

        Typeface type = Typeface.createFromAsset(Shared.context.getAssets(), "fonts/grobold.ttf");


        TextView text1 = (TextView) view.findViewById(R.id.category_true_false);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shared.eventBus.notify(new CategorySelectedEvent(truefalse));
            }
        });
        //setOnClick(text1,1);
        text1.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text1.setTypeface(type);
        text1.setText("ΣΩΣΤΟ - ΛΑΘΟΣ");

        TextView text2 = (TextView) view.findViewById(R.id.multiple);
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shared.eventBus.notify(new CategorySelectedEvent(multiple));
            }
        });
        //setOnClick(text2,2);
        text2.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        text2.setTypeface(type);
        text2.setText("ΠΟΛΛΑΠΛΗΣ");


        animate(text1,text2);
        return view;

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
}
