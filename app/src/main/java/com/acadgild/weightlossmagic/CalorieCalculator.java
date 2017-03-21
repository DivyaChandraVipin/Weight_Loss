package com.acadgild.weightlossmagic;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by DivyaVipin on 3/2/2017.
 */

public class CalorieCalculator extends AppCompatActivity {
   private  Spinner gender;
    private EditText weight,height,age;
    private Button count,clear;
    private int calorie_value;
    private String finalCalorie;
    private TextView textResult;
    private Toolbar toolbar;
    private TextView txtContent;
    private String selectedSpinnerValue;
    private int weight_value,height_value;
    int age_value;
    private String s_weight,s_height,s_age;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie_calculator);
        init();
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        String[] items = new String[] { "Male","Female" };
        Typeface font_content = Typeface.createFromAsset(getAssets(), "DroidSerif-Italic.ttf");
        txtContent.setTypeface(font_content);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
        gender.setAdapter(adapter);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                height.setText("");
                age.setText("");
                weight.setText("");
            }
        });
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedSpinnerValue=gender.getSelectedItem().toString();
                 s_weight=weight.getText().toString();
                 s_height=height.getText().toString();
                weight_value=Integer.parseInt(s_weight);
                 height_value=Integer.parseInt(s_height);
                 s_age=age.getText().toString();
                 age_value=Integer.parseInt(s_age);
                checkEmpty();
                checkCalorieValue();

            }
        });

    }
    public void checkEmpty()
    {
        if(TextUtils.isEmpty(s_age)){
            age.setError("Please enter your age");
            age.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(s_weight)){
            weight.setError("Please enter your weight");
            weight.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(s_height)){
            height.setError("Please enter your height");
            height.requestFocus();
            return;
        }
    }
    public void init()
    {
        toolbar=(Toolbar)findViewById(R.id.toolbar) ;
        textResult=(TextView)findViewById(R.id.txtViewResult) ;
        gender=(Spinner)findViewById(R.id.spnGender);
        weight=(EditText) findViewById(R.id.editTextWeight);
        height=(EditText)findViewById(R.id.editTextHeight) ;
        age=(EditText)findViewById(R.id.editTextAge) ;
        count=(Button) findViewById(R.id.btnCount);
        clear=(Button)findViewById(R.id.btnClear);
        gender = (Spinner)findViewById(R.id.spnGender);
         txtContent = (TextView)findViewById(R.id.txtViewContent);
    }
    public void checkCalorieValue()
    {
        if (selectedSpinnerValue.equals("Male"))
        {
            calorie_value = (int) Math.round(1.2 * (66 + (13.7 * weight_value) + (5 * height_value) - (6.8 * age_value)));
        }
        else
        {
            calorie_value = (int) Math.round(1.2*(655 + (9.6 * weight_value) + (1.8 * height_value) - (4.7 * age_value)));
        }
        finalCalorie=calorie_value+"kcal/day";
        textResult.setText(finalCalorie);
    }
}
