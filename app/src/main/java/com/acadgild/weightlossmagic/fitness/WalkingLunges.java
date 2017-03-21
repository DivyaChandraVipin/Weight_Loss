package com.acadgild.weightlossmagic.fitness;

import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.acadgild.weightlossmagic.R;

/**
 * Created by DivyaVipin on 2/28/2017.
 */

public class WalkingLunges extends AppCompatActivity {
    ImageView walking_lunges;
    AnimationDrawable frameAnimation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walkinglunges_fitness);
        walking_lunges=(ImageView)findViewById(R.id.imgWalking);
        // Setting animation_list.xml as the background of the image view
        walking_lunges.setBackgroundResource(R.drawable.walkinglunges);
        TextView txtHead = (TextView)findViewById(R.id.txtViewHead);
        Typeface font_head = Typeface.createFromAsset(getAssets(), "DroidSerif-Bold.ttf");
        txtHead.setTypeface(font_head);
        TextView tx = (TextView)findViewById(R.id.txtViewWalkingLunges);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"DroidSerif-Italic.ttf");

        tx.setTypeface(custom_font);
        // Typecasting the Animation Drawable
        frameAnimation = (AnimationDrawable)walking_lunges.getBackground();
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            // Starting the animation when in Focus
            frameAnimation.start();
        } else {
            // Stoping the animation when not in Focus
            frameAnimation.stop();
        }
    }
}
