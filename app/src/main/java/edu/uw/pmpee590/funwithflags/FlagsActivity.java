package edu.uw.pmpee590.funwithflags;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import edu.uw.pmpee590.funwithflags.util.Data;
import edu.uw.pmpee590.funwithflags.model.Flags;

public class FlagsActivity extends AppCompatActivity {
    int id;
    Fragment fragmentObject;
    public static final String KEY = "pmp590";
    private static final String TAG = "FlagsActivity";

    int mIndex;
    ImageView mFlagPic_land;
    TextView mFlagDesc_land;
    TextView mFlagName_land;

    Data mData = new Data();
    Flags[] mFlagsBank = mData.createFlags();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flags);

        Log.d(TAG, "onCreate(Bundle) called");

        int orientation = this.getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // code for landscape mode
            FragmentManager manager = getSupportFragmentManager();
            Fragment fragment = manager.findFragmentById(R.id.details);

            fragment = new FragmentFlag();
            manager.beginTransaction()
                    .add(R.id.details, fragment)
                    .commit();
        }

    }

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

        mFlagPic_land = (ImageView) findViewById(R.id.flag_pic_land);
        mFlagDesc_land = (TextView) findViewById(R.id.flag_descrip_land);
        mFlagName_land = (TextView) findViewById(R.id.flag_name_land);

        mFlagPic_land.setImageResource(flag_pic_selected);
        mFlagDesc_land.setText(flag_descrip_selected);
        mFlagName_land.setText(flag_name_selected);

    }

    public void flag_clic(View view) {

        id = view.getId();
        int orientation = this.getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent i = new Intent(FlagsActivity.this, DetailsActivity.class);
            i.putExtra("KEY",id);
            startActivity(i);

        } else {
            // code for landscape mode
            mIndex = mData.returnFlagIndex(id);
            update_flag(mIndex);
        }


    }
}
