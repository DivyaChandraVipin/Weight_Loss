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

public class Eggs  extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.eggs_fragment,container,false);
        TextView txtEgg = (TextView)rootView.findViewById(R.id.txtViewEgg);
        TextView tx = (TextView)rootView.findViewById(R.id.txtViewEggs);
        //Typeface custom_font = Typeface.createFromAsset(getAssets(),"Fun Raiser.ttf");
        Typeface font_head = Typeface.createFromAsset(getActivity().getAssets(), "DroidSerif-Bold.ttf");
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "DroidSerif-Italic.ttf");
        tx.setTypeface(font);
        txtEgg.setTypeface(font_head);
        return rootView;
    }
}
