package com.example.fonnoti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class PrvaGodinaActivity extends AppCompatActivity {

    SwitchCompat mataAktSw;
    SwitchCompat mata1Sw;
    SwitchCompat mata2Sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prva_godina);

        mataAktSw = (SwitchCompat) findViewById(R.id.mataAktSw);
        swithHandler(mataAktSw,"mataAktSave","Matematika");

        mata1Sw = (SwitchCompat) findViewById(R.id.mata1Sw);
        swithHandler(mata1Sw,"mata1Save","matematika1");

        mata2Sw = (SwitchCompat) findViewById(R.id.mata2Sw);
        swithHandler(mata2Sw, "mata2Save","matematika2");






        /*//sacuvati stanje za mata1 swith
        SharedPreferences sharedPreferences = getSharedPreferences("saveMata1",MODE_PRIVATE);

        mata1Sw.setChecked(sharedPreferences.getBoolean("value",false));

        if(mata1Sw.isChecked()) {
            MainActivity.subToTopic("Matematika1");
        }else{
            MainActivity.unsubFromTopic("Matematika1");
        }



        mata1Sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mata1Sw.isChecked()) {

                    SharedPreferences.Editor editor = getSharedPreferences("saveMata1", MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    mata1Sw.setChecked(true);
                    MainActivity.subToTopic("Matematika1");
                }
                else{

                    SharedPreferences.Editor editor = getSharedPreferences("saveMata1", MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    mata1Sw.setChecked(false);
                    MainActivity.unsubFromTopic("Matematika1");


                }
            }
        });
*/




    }

    public void swithHandler(final SwitchCompat switchCompat, String save, final String topic){

        //sacuvati stanje za mata1 swith
        SharedPreferences sharedPreferences = getSharedPreferences(save,MODE_PRIVATE);

        // jer mora da bude final u inner class
        final String saveNew = save;

        switchCompat.setChecked(sharedPreferences.getBoolean("value",false));

        if(switchCompat.isChecked()) {
            MainActivity.subToTopic(topic);
        }else{
            MainActivity.unsubFromTopic(topic);
        }



        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchCompat.isChecked()) {

                    SharedPreferences.Editor editor = getSharedPreferences(saveNew, MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    switchCompat.setChecked(true);
                    MainActivity.subToTopic(topic);
                }
                else{

                    SharedPreferences.Editor editor = getSharedPreferences(saveNew, MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    switchCompat.setChecked(false);
                    MainActivity.unsubFromTopic(topic);


                }
            }
        });

    }
}