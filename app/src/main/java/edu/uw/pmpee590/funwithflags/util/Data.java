package edu.uw.pmpee590.funwithflags.util;

import edu.uw.pmpee590.funwithflags.R;
import edu.uw.pmpee590.funwithflags.model.Flags;

public class Data {

    public Flags[]  createFlags(){
        Flags[] mFlagsBank = new Flags[] {
                new Flags (R.drawable.unitedstates, R.string.flag_name_unitedstates,  R.string.details_unitedstates),
                new Flags (R.drawable.germany, R.string.flag_name_germany,  R.string.details_germany),
                new Flags (R.drawable.italy, R.string.flag_name_italy,  R.string.details_italy),
                new Flags (R.drawable.spain, R.string.flag_name_spain,  R.string.details_spain)
        };

        return mFlagsBank;

    }

    public int returnFlagIndex (int FlagResourceID){
        int mIndex = 0;
        switch(FlagResourceID) {
            case R.id.flag_unitedstates:
                mIndex = 0;
                break;
            case  R.id.flag_germnay:
                mIndex = 1;
                break;
            case R.id.flag_italy:
                mIndex = 2;
                break;
            case R.id.flag_spain:
                mIndex = 3;
                break;
        }
        return mIndex;

    }

}
