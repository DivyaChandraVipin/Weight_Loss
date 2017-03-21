package com.acadgild.weightlossmagic.weighttips.listview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.acadgild.weightlossmagic.R;
import com.acadgild.weightlossmagic.weighttips.WeightLossTips;

/**
 * Created by DivyaVipin on 3/2/2017.
 */

public class WeightTipAdapter extends RecyclerView.Adapter<WeightTipAdapter.ViewHolder>{
    int last_position=-1;
Context context;
    private String[] tips = {"Drink Green Tea", "Eat Spices", "Eat Eggs", "Drink plenty of water", "Start your day with a glass of water",
            "Drink glass of water before your meal", "If you do have a craving for fruit juice then go for fresh fruit juice",
            "Eat fresh fruit instead of drinking fruit juice","Include in your diet things that contain more water " +
            "like tomatoes and water melons","Stay away from sweetened bottle drinks,especially sodas",
            "Eat More Fiber","Do Aerobic Excercise" ,"Eat Spicy Foods","Use smaller plates","Drink Coffee","Cook with Coconut Oil","Cut Back on Added Sugar","Eat less Refined Carbs"};
    class ViewHolder extends RecyclerView.ViewHolder{



        public int currentItem;



        public TextView itemTitle;





        public ViewHolder(View itemView) {

            super(itemView);


            itemTitle = (TextView)itemView.findViewById(R.id.weightTip);




            itemView.setOnClickListener(new View.OnClickListener() {

                @Override public void onClick(View v) {

                    int position = getAdapterPosition();


                    ;



                }

            });

        }

    }
    @Override

    public WeightTipAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())

                .inflate(R.layout.weighttip_cardview, viewGroup, false);
        context = viewGroup.getContext();
        WeightTipAdapter.ViewHolder viewHolder = new WeightTipAdapter.ViewHolder(v);

        return viewHolder;

    }



    @Override

    public void onBindViewHolder(WeightTipAdapter.ViewHolder viewHolder, int i) {

        viewHolder.itemTitle.setText(tips[i]);
        if(i >last_position) {
          Animation animation = AnimationUtils.loadAnimation(context,R.anim.up_bottom);
            viewHolder.itemView.startAnimation(animation);
            last_position = i;
            }

    }



    @Override

    public int getItemCount() {

        return tips.length;

    }
}



