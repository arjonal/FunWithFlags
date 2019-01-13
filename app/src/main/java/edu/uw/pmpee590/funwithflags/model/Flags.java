package edu.uw.pmpee590.funwithflags.model;

public class Flags {

    private int mFlagName; //Will contain the name of the country/flag
    private int mFlagPict;
    private int mFlagDetail;

    public Flags(int flagPict, int flagName, int flagDetail) {
        mFlagPict = flagPict;
        mFlagName = flagName;
        mFlagDetail = flagDetail;
    }


    public int getFlagPict() { return mFlagPict;  }

    public void setFlagPict(int flagPict) { mFlagPict = flagPict; }

    public int getFlagName() {
        return mFlagName;
    }

    public void setFlagName(int flagName) {
        mFlagName = flagName;
    }

    public int getFlagDetail() {
        return mFlagDetail;
    }

    public void setFlagDetail(int flagDetail) {
        mFlagDetail = flagDetail;
    }


}
