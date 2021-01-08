package com.example.wordapp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.wordapp.R;

public class CategoryView extends LinearLayout {
    private ImageView mTitle;
    public CategoryView(Context context) {
        this(context, null);
    }
    public CategoryView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.category_view, this, true);
        setOrientation(LinearLayout.VERTICAL);
        mTitle = (ImageView) findViewById(R.id.title);
    }

    public void setCategory(int category) {
        //String titleResource = String.format(Locale.US, "button_difficulty_%d_star_%d", difficulty, stars);
        //int drawableResourceId = Shared.context.getResources().getIdentifier(titleResource, "drawable", Shared.context.getPackageName());
        //mTitle.setImageResource(drawableResourceId);
    }
}
