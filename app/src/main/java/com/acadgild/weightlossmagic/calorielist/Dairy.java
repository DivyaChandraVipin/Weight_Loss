package com.acadgild.weightlossmagic.calorielist;

import android.graphics.Color;
import android.os.Bundle;
import android.support.test.espresso.core.deps.guava.primitives.Ints;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.acadgild.weightlossmagic.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by DivyaVipin on 2/28/2017.
 */

public class Dairy extends AppCompatActivity {
    ArrayList<String> deslist;
    ArrayList<String> asclist;
    List<Integer> ascCalList;
    List<Integer> desCalList;
    ArrayAdapter<String> adapter;
    Toolbar toolbar;
    //initialize view's
    ListView simpleListView;
    String[] food={"Choclate beverage prepared with milk(100gms)","Strawberry beverage prepared with milk(100 gms)",
            "Vanilla beverage prepared with milk(100gms)","Concentrated Milk(100gms),Condensed Skimmed sweetened milk(100gms)",
            "Condensed swetened milk(100gms)","cow's milk(100gms)","evaported milk(100gms)",
            "sheep milk(100gms)","goats milk(100gms)","human milk(100gms)","Butter,salted(100gm)",
            "Butter,whipped with salt(100gm)","Butter oil,anhydrous(100gm)","Cheese,blue(100gm)","Cheese,brick(100gm)"};
    int[] calorie={84,66,63,131,282,336,65,151,96,66,68,717,718,876,353,371};
    SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.babyfood_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        simpleListView=(ListView)findViewById(R.id.simpleListView);
        SimpleAdapter simpleAdapter;
        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for (int i=0;i<food.length;i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("name",food[i]);
            hashMap.put("calorie",calorie[i]+"");
            arrayList.add(hashMap);//add the hashmap into arrayList
        }
        String[] from={"name","calorie"};//string array
        int[] to={R.id.textViewBabyFdName,R.id.textViewBabyCalorieValue};//int array of views id's
        simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.babyfood_listitems,from,to);//Create object and set the parameters for simpleAdapter
        simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView

        //perform listView item click event
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.calorie_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menuNameAscending:
            {
                asclist = new ArrayList<String>(Arrays.asList(food));
                Collections.sort(asclist);
                String[] sortedArr = new String[asclist.size()];
                sortedArr = asclist.toArray(sortedArr);
                ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
                for (int i=0;i<sortedArr.length;i++)
                {
                    HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
                    hashMap.put("name",sortedArr[i]);
                    hashMap.put("calorie",calorie[i]+"");
                    arrayList.add(hashMap);//add the hashmap into arrayList
                }
                String[] from={"name","calorie"};//string array
                int[] to={R.id.textViewBabyFdName,R.id.textViewBabyCalorieValue};//int array of views id's
                simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.babyfood_listitems,from,to);//Create object and set the parameters for simpleAdapter
                simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView
                simpleAdapter.notifyDataSetChanged();
                return  true;
            }
            case R.id.menuNameDescending: {
                deslist = new ArrayList<String>(Arrays.asList(food));
                Collections.sort(deslist, Collections.reverseOrder());

                String[] sorteddesArr = new String[deslist.size()];
                sorteddesArr = deslist.toArray(sorteddesArr);
                ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
                for (int i = 0; i < sorteddesArr.length; i++) {
                    HashMap<String, String> hashMap = new HashMap<>();//create a hashmap to store the data in key value pair
                    hashMap.put("name", sorteddesArr[i]);
                    hashMap.put("calorie", calorie[i] + "");
                    arrayList.add(hashMap);//add the hashmap into arrayList
                }
                String[] from = {"name", "calorie"};//string array
                int[] to = {R.id.textViewBabyFdName, R.id.textViewBabyCalorieValue};//int array of views id's
                simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.babyfood_listitems, from, to);//Create object and set the parameters for simpleAdapter
                simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView
                simpleAdapter.notifyDataSetChanged();
                return true;
            }
            case R.id.menuCalorieAscending: {
                ascCalList= Ints.asList(calorie);

                Collections.sort(ascCalList);

                Integer[] sortedAscCalArr = new Integer[ascCalList.size()];
                sortedAscCalArr = ascCalList.toArray(sortedAscCalArr);
                ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
                for (int i = 0; i < sortedAscCalArr.length; i++) {
                    HashMap<String, String> hashMap = new HashMap<>();//create a hashmap to store the data in key value pair
                    hashMap.put("name", food[i]);
                    hashMap.put("calorie", sortedAscCalArr[i] + "");
                    arrayList.add(hashMap);//add the hashmap into arrayList
                }
                String[] from = {"name", "calorie"};//string array
                int[] to = {R.id.textViewBabyFdName, R.id.textViewBabyCalorieValue};//int array of views id's
                simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.babyfood_listitems, from, to);//Create object and set the parameters for simpleAdapter
                simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView
                simpleAdapter.notifyDataSetChanged();
                return true;
            }
            case R.id.menuCalorieDescending: {
                desCalList= Ints.asList(calorie);

                Collections.sort(desCalList,Collections.reverseOrder());

                Integer[] sortedDesCalArr = new Integer[desCalList.size()];
                sortedDesCalArr = ascCalList.toArray(sortedDesCalArr);
                ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
                for (int i = 0; i < sortedDesCalArr.length; i++) {
                    HashMap<String, String> hashMap = new HashMap<>();//create a hashmap to store the data in key value pair
                    hashMap.put("name", food[i]);
                    hashMap.put("calorie", sortedDesCalArr[i] + "");
                    arrayList.add(hashMap);//add the hashmap into arrayList
                }
                String[] from = {"name", "calorie"};//string array
                int[] to = {R.id.textViewBabyFdName, R.id.textViewBabyCalorieValue};//int array of views id's
                simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.babyfood_listitems, from, to);//Create object and set the parameters for simpleAdapter
                simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView
                simpleAdapter.notifyDataSetChanged();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}