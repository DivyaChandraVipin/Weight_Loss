package com.acadgild.weightlossmagic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.acadgild.weightlossmagic.weightlossfoods.BeansLegumes;
import com.acadgild.weightlossmagic.weightlossfoods.BoiledPotatos;
import com.acadgild.weightlossmagic.weightlossfoods.ChiaSeeds;
import com.acadgild.weightlossmagic.weightlossfoods.Chicken;
import com.acadgild.weightlossmagic.weightlossfoods.ChilliPepper;
import com.acadgild.weightlossmagic.weightlossfoods.CruciferousVegetables;
import com.acadgild.weightlossmagic.weightlossfoods.Eggs;
import com.acadgild.weightlossmagic.weightlossfoods.LeafyGreens;
import com.acadgild.weightlossmagic.weightlossfoods.Salmon;
import com.acadgild.weightlossmagic.weightlossfoods.Tuna;

/**
 * Created by DivyaVipin on 1/16/2017.
 */

public class Pager extends FragmentPagerAdapter {


    int tabCount;
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Chicken chicken_fragment = new Chicken();
                return chicken_fragment;
            case 1:
                Eggs eggs_fragment = new Eggs();
                return eggs_fragment;
            case 2:
                ChiaSeeds chia_fragment = new ChiaSeeds();
                return chia_fragment;
            case 3:
                ChilliPepper chilli_fragment = new ChilliPepper();
                return chilli_fragment;
            case 4:
                LeafyGreens leafyGreens = new LeafyGreens();
                return leafyGreens;


            case 5:
                Salmon salmon = new Salmon();
                return salmon;
           case 6:
                CruciferousVegetables cruciferousVegetables = new CruciferousVegetables();
                return cruciferousVegetables;
            case 7:
                BoiledPotatos boiledPotatos = new BoiledPotatos();
                return boiledPotatos;
            case 8:
                Tuna tuna = new Tuna();
                return tuna;


            case 9:
                BeansLegumes beansLegumes = new BeansLegumes();
                return beansLegumes;





            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
