package com.acadgild.weightlossmagic;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.acadgild.weightlossmagic.calorielist.BabyFood;
import com.acadgild.weightlossmagic.calorielist.Dairy;
import com.acadgild.weightlossmagic.calorielist.Fats;
import com.acadgild.weightlossmagic.calorielist.Sweets;
import com.acadgild.weightlossmagic.calorielist.VariedBabyFormula;
import com.acadgild.weightlossmagic.calorielist.Vegetables;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by DivyaVipin on 3/3/2017.
 */

public class CalorieList extends AppCompatActivity {

    //initialize view's
    Toolbar toolbar;
    ListView simpleListView;
    String[] calorieList={"BabyFood","Dairy Products","Fats and Oil","Sweets","Varied Baby Formula","Vegetables"};
    int[] calorieListImages={R.drawable.babyfood,R.drawable.dairy,R.drawable.fats,R.drawable.sweets,R.drawable.baby_formula,
            R.drawable.cruciferous};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie_list);
        simpleListView=(ListView)findViewById(R.id.simpleListView);
        toolbar=(Toolbar)findViewById(R.id.toolbar) ;
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for (int i=0;i<calorieList.length;i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("name",calorieList[i]);
            hashMap.put("image",calorieListImages[i]+"");
            arrayList.add(hashMap);//add the hashmap into arrayList
        }
        String[] from={"name","image"};//string array
        int[] to={R.id.textViewFood,R.id.imageViewFood};//int array of views id's
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.calorie_listview_item,from,to);//Create object and set the parameters for simpleAdapter
        simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView

        //perform listView item click event
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               if(i== 0)
               {
                   Intent weight=new Intent(CalorieList.this,BabyFood.class);
                   startActivity(weight);
               }
               else if(i == 1)
               {
                   Intent dairy=new Intent(CalorieList.this,Dairy.class);
                   startActivity(dairy);
               }
                else if(i == 2)
               {
                   Intent fats=new Intent(CalorieList.this,Fats.class);
                   startActivity(fats);
               }
               else if(i == 3)
               {
                   Intent sweets=new Intent(CalorieList.this,Sweets.class);
                   startActivity(sweets);
               }
               else if(i == 4)
               {
                   Intent varied_babyformula=new Intent(CalorieList.this,VariedBabyFormula.class);
                   startActivity(varied_babyformula);
               }
               else
               {
                   Intent vegetables=new Intent(CalorieList.this,Vegetables.class);
                   startActivity(vegetables);
               }
            }
        });
    }


}