package com.acadgild.weightlossmagic.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.acadgild.weightlossmagic.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by DivyaVipin on 2/28/2017.
 */

public class HomeExcercise  extends AppCompatActivity {
    ListView listFitness;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_excercise);
        listFitness=(ListView)findViewById(R.id.lstfitness);

        String[] fitness= new String[]{"BirdDog", "Bridge", "Leaps", "PlankCrawl", "Push Up", "SidePlank", "SingleLeg", "Squates",
                "Superman",
                "Walking Lunges"};

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,fitness);

        listFitness.setAdapter(adapter);//sets the adapter for listView

        listFitness.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0)
                {
                    Intent bicycle=new Intent(HomeExcercise.this,BirdDog.class);
                    startActivity(bicycle);
                }
                else  if(i == 1)
                {
                    Intent bridge=new Intent(HomeExcercise.this,Bridge.class);
                    startActivity(bridge);
                }
                else  if(i == 2)
                {
                    Intent leaps=new Intent(HomeExcercise.this,Leaps.class);
                    startActivity(leaps);
                }
                else  if(i == 3)
                {
                    Intent plank=new Intent(HomeExcercise.this,PlankCrawl.class);
                    startActivity(plank);
                }
                else  if(i == 4)
                {
                    Intent push_up=new Intent(HomeExcercise.this,PushUp.class);
                    startActivity(push_up);
                }
                else if(i == 5)
                {
                    Intent side_plank=new Intent(HomeExcercise.this,SidePlank.class);
                    startActivity(side_plank);
                }
                else  if(i == 6)
                {
                    Intent single_leg=new Intent(HomeExcercise.this,SingleLeg.class);
                    startActivity(single_leg);
                }
                else  if(i == 7)
                {
                    Intent squats=new Intent(HomeExcercise.this,Squats.class);
                    startActivity(squats);
                }
                else  if(i == 8)
                {
                    Intent superman=new Intent(HomeExcercise.this,Superman.class);
                    startActivity(superman);
                }
                else
                {
                    Intent walking_lunges=new Intent(HomeExcercise.this,WalkingLunges.class);
                    startActivity(walking_lunges);
                }

            }
        });
    }
}
