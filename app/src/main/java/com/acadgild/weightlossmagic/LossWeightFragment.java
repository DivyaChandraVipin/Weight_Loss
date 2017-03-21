package com.acadgild.weightlossmagic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import com.acadgild.weightlossmagic.losskgs.FifthDay;
import com.acadgild.weightlossmagic.losskgs.FirstDay;
import com.acadgild.weightlossmagic.losskgs.FourthDay;
import com.acadgild.weightlossmagic.losskgs.SecondDay;
import com.acadgild.weightlossmagic.losskgs.SeventhDay;
import com.acadgild.weightlossmagic.losskgs.SixthDay;
import com.acadgild.weightlossmagic.losskgs.ThirdDay;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by DivyaVipin on 3/2/2017.
 */

public class LossWeightFragment extends AppCompatActivity {
    ListView listGM;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lossweight_fragment);
        listGM=(ListView)findViewById(R.id.lstViewGM);
        int [] gmImages={R.drawable.dayone,R.drawable.daytwo,R.drawable.daythree,R.drawable.dayfour,R.drawable.dayfive,R.drawable.daysix,R.drawable.dayseven};
        String[] gm= new String[]{"First Day", "Second Day", "Third Day", "Fourth Day", "Fifth Day", "Sixth Day", "Seventh Day" };
        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for (int i=0;i<gm.length;i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("name",gm[i]);
            hashMap.put("image",gmImages[i]+"");
            arrayList.add(hashMap);//add the hashmap into arrayList
        }
        String[] from={"name","image"};//string array
        int[] to={R.id.textViewGM,R.id.imageViewGM};//int array of views id's
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.gm_list,from,to);//Create object and set the parameters for simpleAdapter
        listGM.setAdapter(simpleAdapter);
       // ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,gm);

       // listGM.setAdapter(adapter);//sets the adapter for listView

        listGM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0)
                {
                    Intent first_day=new Intent(LossWeightFragment.this,FirstDay.class);
                    startActivity(first_day);
                }
                else  if(i == 1)
                {
                    Intent second_day=new Intent(LossWeightFragment.this,SecondDay.class);
                    startActivity(second_day);
                }
                else  if(i == 2)
                {
                    Intent third_day=new Intent(LossWeightFragment.this,ThirdDay.class);
                    startActivity(third_day);
                }
                else  if(i == 3)
                {
                    Intent fourth_day=new Intent(LossWeightFragment.this,FourthDay.class);
                    startActivity(fourth_day);
                }
                else  if(i == 4)
                {
                    Intent fifth_day=new Intent(LossWeightFragment.this,FifthDay.class);
                    startActivity(fifth_day);
                }
                else if(i == 5)
                {
                    Intent sixth_day=new Intent(LossWeightFragment.this,SixthDay.class);
                    startActivity(sixth_day);
                }
                else
                {
                    Intent seventh_day=new Intent(LossWeightFragment.this,SeventhDay.class);
                    startActivity(seventh_day);
                }


            }
        });

        //return myView;
    }





}
