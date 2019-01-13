package edu.uw.pmpee590.funwithflags;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import edu.uw.pmpee590.funwithflags.model.Flags;

public class FlagsActivity extends AppCompatActivity {
    int id;
    Fragment fragmentObject;
    public static final String KEY = "pmp590";

    int mIndex;
    ImageView mFlagPic_land;
    TextView mFlagDesc_land;
    TextView mFlagName_land;


    Flags[] mFlagsBank = new Flags[] {
            new Flags (R.drawable.unitedstates, R.string.flag_name_unitedstates,  R.string.details_unitedstates),
            new Flags (R.drawable.germany, R.string.flag_name_germany,  R.string.details_germany),
            new Flags (R.drawable.italy, R.string.flag_name_italy,  R.string.details_italy),
            new Flags (R.drawable.spain, R.string.flag_name_spain,  R.string.details_spain)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flags);

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
        switch(id) {
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
}
