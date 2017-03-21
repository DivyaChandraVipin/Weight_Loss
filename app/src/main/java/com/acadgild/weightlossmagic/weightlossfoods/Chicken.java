package com.acadgild.weightlossmagic.weightlossfoods;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.acadgild.weightlossmagic.R;

/**
 * Created by DivyaVipin on 1/16/2017.
 */

public class Chicken extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.chicken_fragment,container,false);
        TextView tx = (TextView)rootView.findViewById(R.id.txtViewChicken);
        TextView txt = (TextView)rootView.findViewById(R.id.txtChicken);
        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(),"DroidSerif-Bold.ttf");
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "DroidSerif-Italic.ttf");
        tx.setTypeface(font);
        txt.setTypeface(custom_font);
        return rootView;
    }
}
