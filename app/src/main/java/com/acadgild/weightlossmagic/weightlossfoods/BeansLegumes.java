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

public class BeansLegumes extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.beans_fragment,container,false);
        TextView txtHead = (TextView)rootView.findViewById(R.id.txtViewHead);
        TextView txtContent = (TextView)rootView.findViewById(R.id.txtViewContent);
        //Typeface custom_font = Typeface.createFromAsset(getAssets(),"Fun Raiser.ttf");
        Typeface font_head = Typeface.createFromAsset(getActivity().getAssets(), "DroidSerif-Bold.ttf");
        Typeface font_content = Typeface.createFromAsset(getActivity().getAssets(), "DroidSerif-Italic.ttf");
        txtHead.setTypeface(font_head);
        txtContent.setTypeface(font_content);
        return rootView;
    }
}
