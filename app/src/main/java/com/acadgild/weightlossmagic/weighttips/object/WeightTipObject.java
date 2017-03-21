package com.acadgild.weightlossmagic.weighttips.object;

/**
 * Created by DivyaVipin on 3/2/2017.
 */

public class  WeightTipObject {
    public WeightTipObject()
    {

    }
    public WeightTipObject(String weightLossTip) {
        this.weightLossTip = weightLossTip;
    }

    public String getWeightLossTip() {
        return weightLossTip;
    }

    public void setWeightLossTip(String weightLossTip) {
        this.weightLossTip = weightLossTip;
    }

    private String weightLossTip;
}
