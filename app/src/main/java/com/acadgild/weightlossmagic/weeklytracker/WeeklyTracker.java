package com.acadgild.weightlossmagic.weeklytracker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.acadgild.weightlossmagic.R;
import com.acadgild.weightlossmagic.calorietracker.CalorieTracker;
import com.acadgild.weightlossmagic.weeklytracker.database.Constants;
import com.acadgild.weightlossmagic.weeklytracker.database.DBAdapter;
import com.acadgild.weightlossmagic.calorietracker.listview.CalorieAdapter;
import com.acadgild.weightlossmagic.calorietracker.object.CalorieObject;
import com.acadgild.weightlossmagic.weeklytracker.listview.WeeklyAdapter;
import com.acadgild.weightlossmagic.weeklytracker.object.WeeklyObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by DivyaVipin on 3/7/2017.
 */

public class WeeklyTracker extends AppCompatActivity {

    FloatingActionButton btnAdd;
    Dialog d;
    EditText calValueDialog;
    Spinner spactivity;
    String c_Value=null;
    int cValue=0;
    String activityname="";
    Button btnSave;
    Button btnDate;
    DBAdapter db;
    Constants c;
    String dmy;
    EditText chestWeekly;
    EditText weightWeekly;
    EditText waistWeekly;
    EditText hipWeekly;
    EditText dateWeekly;

    String cal_val_dialog;
    DatePicker datePicker;
    WeeklyAdapter weeklyAdapter;
    String new_Calorie;
    String weight_v,waist_v,hip_v,chest_v;
    int weight_value,waist_value,hip_value,chest_value;
    Calendar dateTime=Calendar.getInstance();
    ArrayList<WeeklyObject> weeklydetails=new ArrayList<>();
    ListView lv;
    int day,month,year;
    Toolbar toolbar;
    DateFormat formatDate=DateFormat.getDateInstance();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weekly_tracker);
        toolbar=(Toolbar)findViewById(R.id.toolbar) ;
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        btnAdd=(FloatingActionButton)findViewById(R.id.addDetails);
        lv=(ListView)findViewById(R.id.listViewWeekly) ;

        db=new DBAdapter(WeeklyTracker.this);
        db.openDB();

        weeklyAdapter=new WeeklyAdapter(WeeklyTracker.this,weeklydetails);
        lv.setAdapter(weeklyAdapter);
        registerForContextMenu(lv);

        getWeeklyDetails();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d=new Dialog(WeeklyTracker.this);
                d.setTitle("Add Weekly Details");
                d.setContentView(R.layout.weekly_track_dialog);
                dateWeekly=(EditText)d.findViewById(R.id.editTextWeeklyDate) ;
                weightWeekly=(EditText)d.findViewById(R.id.editTextWeightWeekly);
                waistWeekly=(EditText)d.findViewById(R.id.editTextWaistWeekly);
                hipWeekly=(EditText)d.findViewById(R.id.editTextHipWeekly);
                chestWeekly=(EditText)d.findViewById(R.id.editTextChestWeekly);

                btnDate=(Button)d.findViewById(R.id.btnCalDate);
                final  DatePickerDialog.OnDateSetListener dialog = new DatePickerDialog.OnDateSetListener() {

                    @Override

                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        dateTime.set(Calendar.YEAR, year);

                        dateTime.set(Calendar.MONTH, monthOfYear);

                        dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        dateTime.set(Calendar.HOUR_OF_DAY,0);
                        dateTime.set(Calendar.MINUTE,0);
                        dateTime.set(Calendar.SECOND,0);
                        dateTime.set(Calendar.MILLISECOND, 0);
                        dateWeekly.setText(formatDate.format(dateTime.getTime()));


                    }

                };
                btnDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new DatePickerDialog(WeeklyTracker.this,dialog, dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH)).show();
                    }
                });


                btnSave=(Button)d.findViewById(R.id.btnCSave);
                d.show();

                btnSave.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        try {
                            weight_v=weightWeekly.getText().toString();
                            weight_value = Integer.parseInt(weight_v);
                        }
                        catch(NumberFormatException e)
                        {
                            weight_value=0;
                        }
                        try {
                            waist_v=waistWeekly.getText().toString();
                            waist_value = Integer.parseInt(waist_v);
                        }
                        catch(NumberFormatException e)
                        {
                            waist_value=0;
                        }
                        try {
                            hip_v=hipWeekly.getText().toString();
                            hip_value = Integer.parseInt(hip_v);
                        }
                        catch(NumberFormatException e)
                        {
                            hip_value=0;
                        }
                        try {
                            chest_v=chestWeekly.getText().toString();
                            chest_value = Integer.parseInt(chest_v);
                        }
                        catch(NumberFormatException e)
                        {
                            chest_value=0;
                        }



                        // db.add(spactivity.getSelectedItem().toString(),Integer.parseInt(calValueDialog.getText().toString()),dmy);
                        db.add(weight_value,waist_value,hip_value,chest_value,dateWeekly.getText().toString());
                        d.dismiss();
                        getWeeklyDetails();

                    }
                });




            }
        });


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.listViewCalorie) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle("Select the Action");

            menu.add(0, v.getId(), 0, "Delete");
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int listPosition=info.position;
        int id=weeklyAdapter.getWeeklyDetails().get(listPosition).getId();
        if(item.getTitle()=="Delete")
        {
            deleteDetails(id);

        }



        return super.onContextItemSelected(item);

    }

    private void getWeeklyDetails()
    {
        weeklydetails.clear();
        WeeklyObject weeklyObject=null;
        Cursor c=db.retrieve();
        while (c.moveToNext())
        {
            int id=c.getInt(0);
            int weight=c.getInt(1);
            int waist=c.getInt(2);
            int hip=c.getInt(3);
            int chest=c.getInt(4);

            String date=c.getString(5);
            weeklyObject=new WeeklyObject();
            weeklyObject.setId(id);
            weeklyObject.setWeight(weight);
            weeklyObject.setWaist(waist);
            weeklyObject.setHip(hip);
            weeklyObject.setChest(chest);

            weeklyObject.setDate(" "+date);
            weeklydetails.add(weeklyObject);
        }
        lv.setAdapter(weeklyAdapter);

    }
    private void deleteDetails(int id)
    {
        Toast.makeText(getApplicationContext(), "This is deleted.", Toast.LENGTH_SHORT).show();

        db.deleteRecords(Constants.TB_NAME, Constants.ROW_ID+ " = '" +id+
                "' ", null);
        finish();
        getWeeklyDetails();
    }
}
