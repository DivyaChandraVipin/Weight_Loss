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

public class Tuna extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.tuna_fragment,container,false);
        TextView tx = (TextView)rootView.findViewById(R.id.txtViewTuna);
        TextView txtHead = (TextView)rootView.findViewById(R.id.txtViewHead);
        Typeface font_head = Typeface.createFromAsset(getActivity().getAssets(), "DroidSerif-Bold.ttf");
        txtHead.setTypeface(font_head);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "DroidSerif-Italic.ttf");
        tx.setTypeface(font);

        return rootView;
    }
}