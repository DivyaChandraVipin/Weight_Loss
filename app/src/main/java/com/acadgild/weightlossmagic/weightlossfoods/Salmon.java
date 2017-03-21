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
 * Created by DivyaVipin on 1/20/2017.
 */

public class Salmon extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.salmon_fragment,container,false);
        TextView tx = (TextView)rootView.findViewById(R.id.txtViewSalmon);
        //Typeface custom_font = Typeface.createFromAsset(getAssets(),"Fun Raiser.ttf");
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "DroidSerif-Italic.ttf");
        tx.setTypeface(font);
        TextView txt = (TextView)rootView.findViewById(R.id.txtSalmon);
        //Typeface custom_font = Typeface.createFromAsset(getAssets(),"Fun Raiser.ttf");
        Typeface txfont = Typeface.createFromAsset(getActivity().getAssets(), "DroidSerif-Bold.ttf");
        txt.setTypeface(txfont);
        return rootView;
    }
}