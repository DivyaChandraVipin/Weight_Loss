package com.acadgild.weightlossmagic.weeklytracker.database;

/**
 * Created by DivyaVipin on 1/19/2017.
 */

public class Constants {

    //COLUMNS
  public  static final String ROW_ID="id";
    static final String WEIGHT="weight";
    static final String HIP ="hipsize";
    static final String CHEST="chestsize";
    static final String WAIST="waistsize";
    static final String ACTIVITY_DATE="date";
    //DB
   public static final String DB_NAME="CALORIE_DB";
     public static final String TB_NAME="WEEKLYTRACKER_TB";
    static final int DB_VERSION=1;

    //CREATE TB
    static final String CREATE_TB="CREATE TABLE WEEKLYTRACKER_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            +WEIGHT+ " INTEGER NOT NULL ,"+HIP+" INTEGER NOT NULL,"+CHEST+" INTEGER NOT NULL,"+WAIST+" INTEGER NOT NULL,"+ACTIVITY_DATE+" TEXT NOT NULL);";

    //DROP TB
    static final String DROP_TB="DROP TABLE IF EXISTS "+TB_NAME;
}
