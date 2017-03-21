package com.acadgild.weightlossmagic;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CalendarView;

/**
 * Created by DivyaVipin on 3/2/2017.
 */

public class Calender  extends AppCompatActivity {
    CalendarView calenderView;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender_view);
        init();

        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
    }
    public void init()
    {
        calenderView=(CalendarView) findViewById(R.id.calendar);
        toolbar=(Toolbar)findViewById(R.id.toolbar) ;
    }
}
