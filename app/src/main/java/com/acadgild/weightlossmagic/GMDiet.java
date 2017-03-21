package com.acadgild.weightlossmagic;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by DivyaVipin on 3/2/2017.
 */

public class GMDiet extends AppCompatActivity {
    Button btnGo;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gm_diet);
        toolbar=(Toolbar)findViewById(R.id.toolbar) ;
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        TextView tx = (TextView)findViewById(R.id.txtViewGM);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"DroidSerif-Italic.ttf");

        tx.setTypeface(custom_font);
        btnGo=(Button)findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lossweight=new Intent(GMDiet.this,LossWeightFragment.class);
                startActivity(lossweight);

            }
        });
    }

};