package com.acadgild.weightlossmagic.weeklytracker.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.acadgild.weightlossmagic.R;
import com.acadgild.weightlossmagic.weeklytracker.object.WeeklyObject;

import java.util.ArrayList;

/**
 * Created by DivyaVipin on 3/7/2017.
 */

public class WeeklyAdapter extends BaseAdapter {
    Context c;

    public ArrayList<WeeklyObject> getWeeklyDetails() {
        return weeklyDetails;
    }

    public void setWeeklyDetails(ArrayList<WeeklyObject> weeklyDetails) {
        this.weeklyDetails = weeklyDetails;
    }

    ArrayList<WeeklyObject> weeklyDetails;


    LayoutInflater inflater;
    public WeeklyAdapter(Context c, ArrayList<WeeklyObject> weeklyDetails) {
        this.c = c;
        this.weeklyDetails = weeklyDetails;

    }


    @Override
    public int getCount() {
        return weeklyDetails.size();
    }

    @Override
    public Object getItem(int i) {
        return weeklyDetails.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) { if(inflater==null)
    {
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
        if(view==null)
        {
            view=inflater.inflate(R.layout.weekly_tracker_listitem,viewGroup,false);
        }
        TextView cal_Txt= (TextView)view.findViewById(R.id.weeklydetail);

        Integer weight=weeklyDetails.get(i).getWeight();
        Integer waist=weeklyDetails.get(i).getWaist();
        Integer chest=weeklyDetails.get(i).getChest();
        Integer hip=weeklyDetails.get(i).getHip();

        String date=weeklyDetails.get(i).getDate();
        //String activity_name=calDetails.get(i).getActivity();
        cal_Txt.setText("Weight: "+weight+"\n"+"Waist Size: 4"+waist+"\n"+"Chest size: "+chest+"\n"+"Hip size: "+hip
                +"\n"+"Date: "+date);

        return view;

    }
}
