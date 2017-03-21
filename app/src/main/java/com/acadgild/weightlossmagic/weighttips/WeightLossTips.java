package com.acadgild.weightlossmagic.weighttips;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.acadgild.weightlossmagic.R;
import com.acadgild.weightlossmagic.weighttips.listview.WeightTipAdapter;

/**
 * Created by DivyaVipin on 3/2/2017.
 */

public class WeightLossTips extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WeightTipAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager ;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weightip_recycler);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        toolbar=(Toolbar)findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // weightLossTips();
        mAdapter = new WeightTipAdapter();
        recyclerView.setAdapter(mAdapter);

    }

}
