package com.acadgild.weightlossmagic.login;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.acadgild.weightlossmagic.R;

/**
 * Created by DivyaVipin on 3/2/2017.
 */

public class LoginViewPager  extends PagerAdapter{
    int[] image;
    LayoutInflater inflater;
    Context context;
    public LoginViewPager(Login login,int[] img)
    {
        this .context=login;
        this.image=img;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==((LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView trailing;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=inflater.inflate(R.layout.indicator_item,container,false);
        trailing=(ImageView)itemView.findViewById(R.id.imgIndicator);
        trailing.setImageResource(image[position]);
        ((ViewPager)container).addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((LinearLayout)object);
        //super.destroyItem(container, position, object);
    }
}
