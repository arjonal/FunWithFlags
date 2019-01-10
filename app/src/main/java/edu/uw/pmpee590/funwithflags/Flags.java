package edu.uw.pmpee590.funwithflags;

import java.util.Date;

public class Flags {

    private String mTitle;
    private Date mDate;

    public Flags() {
        mDate = new Date();
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

}
