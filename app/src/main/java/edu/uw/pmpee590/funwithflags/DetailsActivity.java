package edu.uw.pmpee590.funwithflags;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import edu.uw.pmpee590.funwithflags.model.Flags;

public class DetailsActivity extends AppCompatActivity {

    ImageView mFlagPic;
    TextView mFlagDesc;
    TextView mFlagName;

    int mIndex;

    Flags[] mFlagsBank = new Flags[] {
            new Flags (R.drawable.unitedstates, R.string.flag_name_unitedstates,  R.string.details_unitedstates),
            new Flags (R.drawable.germany, R.string.flag_name_germany,  R.string.details_germany),
            new Flags (R.drawable.italy, R.string.flag_name_italy,  R.string.details_italy),
            new Flags (R.drawable.spain, R.string.flag_name_spain,  R.string.details_spain)
    };

    public void update_flag(int index){

        int flag_name_selected = mFlagsBank[index].getFlagName();
        int flag_descrip_selected = mFlagsBank[index].getFlagDetail();
        int flag_pic_selected = mFlagsBank[index].getFlagPict();

        mFlagPic.setImageResource(flag_pic_selected);
        mFlagDesc.setText(flag_descrip_selected);
        mFlagName.setText(flag_name_selected);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent data = getIntent();
        Bundle extras = data.getExtras();

        mFlagPic = (ImageView) findViewById(R.id.flag_pic_land);
        mFlagDesc = (TextView) findViewById(R.id.flag_descrip_port);
        mFlagName = (TextView) findViewById(R.id.flag_name_port);

        // Capture the layout's TextView and set the string as its text
        switch(extras.getInt("KEY")) {
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
        update_flag(mIndex);
    }


}
