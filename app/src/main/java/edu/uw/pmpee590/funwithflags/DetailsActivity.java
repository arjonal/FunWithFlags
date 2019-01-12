package edu.uw.pmpee590.funwithflags;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent data = getIntent();
        Bundle extras = data.getExtras();
        int id =  extras.getInt("KEY");

        ImageView flag_details= (ImageView) findViewById(R.id.flagView);
        // Capture the layout's TextView and set the string as its text
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
