package edu.uw.pmpee590.funwithflags;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FlagsActivity extends AppCompatActivity {
    int id;
    Fragment fragmentObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flags);
        int orientation = this.getResources().getConfiguration().orientation;

       FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.details);

        if (orientation == Configuration.ORIENTATION_PORTRAIT){
            if (fragment == null) {
                fragment = new FragmentFlag();
                manager.beginTransaction()
                        .add(R.id.details, fragment)
                        .hide(fragment)
                        .commit();
            }
        }
        else{
            if (fragment == null) {
                fragment = new FragmentFlag();
                manager.beginTransaction()
                        .add(R.id.details, fragment)
                        //.hide(fragment)
                        .commit();
            }
        }

    }






    public void flag_clic(View view) {

        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            // code for portrait mode
        } else {
            // code for landscape mode

       id = view.getId();
        ImageView flag_details = (ImageView) findViewById(R.id.flagView);

        switch(id) {
            case R.id.flag_france:
                //2131230912:
                //Log.v(TAG, "YAKI 1");
                flag_details.setImageResource(R.drawable.france);
                break;
            case  R.id.flag_italy:
                //Log.v(TAG, "YAKI 2");
                flag_details.setImageResource(R.drawable.italy);
                break;
            case R.id.flag_unitedstates:
                //2131230914:
                // Log.v(TAG, "YAKI 3");
                flag_details.setImageResource(R.drawable.unitedstates);
                break;
            case R.id.flag_germnay:
                //2131230914:
                // Log.v(TAG, "YAKI 3");
                flag_details.setImageResource(R.drawable.germany);
                break;
        }
        }


    }
}
