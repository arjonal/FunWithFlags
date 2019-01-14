package edu.uw.pmpee590.funwithflags;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import edu.uw.pmpee590.funwithflags.util.Data;
import edu.uw.pmpee590.funwithflags.model.Flags;

public class DetailsActivity extends AppCompatActivity {

    ImageView mFlagPic;
    TextView mFlagDesc;
    TextView mFlagName;

    int mIndex;
    Data mData = new Data();
    Flags[] mFlagsBank = mData.createFlags();

    private static final String TAG = "DetailsActivity";


    @Override    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }
    @Override    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }
    @Override    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }
    @Override    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }
    @Override    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

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
