package edu.uw.pmpee590.funwithflags;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import Utils.Data;
import edu.uw.pmpee590.funwithflags.model.Flags;

public class DetailsActivity extends AppCompatActivity {

    ImageView mFlagPic;
    TextView mFlagDesc;
    TextView mFlagName;

    int mIndex;
    Data mData = new Data();
    Flags[] mFlagsBank = mData.createFlags();


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

        mIndex = mData.returnFlagIndex(extras.getInt("KEY"));
        update_flag(mIndex);
    }


}
