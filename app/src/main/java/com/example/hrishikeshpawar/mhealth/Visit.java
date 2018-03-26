package com.example.hrishikeshpawar.mhealth;

/**
 * Created by Hrishikesh Pawar on 24-03-2018.
 */

public class Visit {
    public String mN1,mN2,mN3,mP1,mP2,mP3,mDiag,mDate;
    public int mD1,mD2,mD3;

    public Visit()
    {

    }

    public Visit(String mDiag, String mDate, String mN1, int mD1, String mP1, String mN2, int mD2, String mP2, String mN3, int mD3,  String mP3)
    {
        this.mDiag = mDiag;
        this.mDate = mDate;
        this.mN1 = mN1;
        this.mN2 = mN2;
        this.mN3 = mN3;
        this.mP1 = mP1;
        this.mP2 = mP2;
        this.mP3 = mP3;
        this.mD1 = mD1;
        this.mD2 = mD2;
        this.mD3 = mD3;
    }
}
