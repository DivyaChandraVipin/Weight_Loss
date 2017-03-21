package com.acadgild.weightlossmagic.losskgs;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.acadgild.weightlossmagic.R;

/**
 * Created by DivyaVipin on 1/17/2017.
 */

public class SecondDay extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_day);
        TextView tx = (TextView)findViewById(R.id.txtViewSecond);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"DroidSerif-Italic.ttf");
        tx.setTypeface(custom_font);
        TextView txtHead = (TextView)findViewById(R.id.txtViewHead);
        Typeface font_head = Typeface.createFromAsset(getAssets(), "DroidSerif-Bold.ttf");
        txtHead.setTypeface(font_head);
    }
}
