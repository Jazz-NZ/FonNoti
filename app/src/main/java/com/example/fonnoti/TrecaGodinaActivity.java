package com.example.fonnoti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class TrecaGodinaActivity extends AppCompatActivity {



    SwitchCompat rmt;
    SwitchCompat oi1;
    SwitchCompat ts;
    SwitchCompat mljr;
    SwitchCompat up;
    SwitchCompat oi2;
    SwitchCompat bp;

    SwitchCompat pj;
    SwitchCompat mpp;
    SwitchCompat to;
    SwitchCompat lins;
    SwitchCompat ur;
    SwitchCompat ek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treca_godina);

        rmt = (SwitchCompat) findViewById(R.id.rmtSw);
        swithHandler(rmt,"rmtSave","rmt");

        oi1 = (SwitchCompat) findViewById(R.id.oi1Sw);
        swithHandler(oi1,"oi1Save","operaciona-istrazivanja-1");

        ts = (SwitchCompat) findViewById(R.id.tsSw); //teorija sistema
        swithHandler(ts, "tsSave","none");

        mljr = (SwitchCompat) findViewById(R.id.mljrItSw); //ne znam gde je sajt
        swithHandler(mljr, "mljrITSave","mljr");

        up = (SwitchCompat) findViewById(R.id.upSw);
        swithHandler(up, "upSave","управљање-квалитетом-основне");

        oi2 = (SwitchCompat) findViewById(R.id.oi2Sw);
        swithHandler(oi2, "oi2Save","operaciona-istrazivanja-2");

        bp = (SwitchCompat) findViewById(R.id.bpSw);
        swithHandler(bp, "bpSave","baze-podataka");


        pj = (SwitchCompat) findViewById(R.id.pjSw);
        swithHandler(pj,"pjSave","programski-jezici");

        mpp = (SwitchCompat) findViewById(R.id.mppSw);
        swithHandler(mpp,"mppSave","modelovanje-poslovnih-procesa");

        to = (SwitchCompat) findViewById(R.id.toSw);
        swithHandler(to, "toSave","menadzment-tehnologije-i-razvoja"); //ne radi sajt

        lins = (SwitchCompat) findViewById(R.id.linsSw);
        swithHandler(lins, "linsSave","linearni-statisticki-modeli-2");

        ur = (SwitchCompat) findViewById(R.id.urSw);
        swithHandler(ur, "urSave","upravljacko-racunovodstvo");

        ek = (SwitchCompat) findViewById(R.id.emSw);
        swithHandler(ek, "ekSave","ekonometrijske-metode-2");


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