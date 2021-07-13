package com.example.fonnoti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class DrugaGodinaActivity extends AppCompatActivity {


    SwitchCompat arosSw;
    SwitchCompat p2;
    SwitchCompat m3;
    SwitchCompat marketing;
    SwitchCompat tv;
    SwitchCompat eng2;
    SwitchCompat fra2;

    SwitchCompat spa;
    SwitchCompat stat;
    SwitchCompat mtr;
    SwitchCompat fmir;
    SwitchCompat num;
    SwitchCompat dms;
    SwitchCompat mljr;

    SwitchCompat epip;
    SwitchCompat rac;
    SwitchCompat ofm;
    SwitchCompat ut;
    SwitchCompat ok;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_druga_godina);

        arosSw = (SwitchCompat) findViewById(R.id.arosSw);
        swithHandler(arosSw,"arosSave","aros");

        p2 = (SwitchCompat) findViewById(R.id.p2Sw);
        swithHandler(p2,"p2Save","programiranje-2");

        m3 = (SwitchCompat) findViewById(R.id.m3Sw);
        swithHandler(m3, "m3Save","matematika3");

        marketing = (SwitchCompat) findViewById(R.id.marketingSw); //ne znam gde je sajt
        swithHandler(marketing, "markSave","none");

        tv = (SwitchCompat) findViewById(R.id.tvSw);
        swithHandler(tv, "tvSave","teorija-verovatnoce-2");

        eng2 = (SwitchCompat) findViewById(R.id.eng2Sw);
        swithHandler(eng2, "eng2Save","engleski2");

        fra2 = (SwitchCompat) findViewById(R.id.fra2Sw);
        swithHandler(fra2, "fra2Save","uvod-u-informacione-sisteme");


        spa = (SwitchCompat) findViewById(R.id.spaSw);
        swithHandler(spa,"spaSave","strukture-podataka-i-algoritmi");

        stat = (SwitchCompat) findViewById(R.id.statSw);
        swithHandler(stat,"statSave","statistika-2");

        mtr = (SwitchCompat) findViewById(R.id.mtrSw);
        swithHandler(mtr, "mtrSave","menadzment-tehnologije-i-razvoja");

        fmir = (SwitchCompat) findViewById(R.id.fmirSw);
        swithHandler(fmir, "fmirSave","finansijski-menadzment-i-racunovodstvo");

        num = (SwitchCompat) findViewById(R.id.numSw);
        swithHandler(num, "numSave","numericka-analiza");

        dms = (SwitchCompat) findViewById(R.id.dmsSw);
        swithHandler(dms, "dmsSave","dms");

        mljr = (SwitchCompat) findViewById(R.id.mljrSw);
        swithHandler(mljr, "mljrSave","mljr");


        epip = (SwitchCompat) findViewById(R.id.epipSw); //nema sajta
        swithHandler(epip,"epipSave","none");

        rac = (SwitchCompat) findViewById(R.id.racSw);
        swithHandler(rac,"racSave","racunovodstvo");

        ofm = (SwitchCompat) findViewById(R.id.ofmSw);
        swithHandler(ofm, "ofmSave","finansijski-menadzment");

        ut = (SwitchCompat) findViewById(R.id.utSw); //nema sajta
        swithHandler(ut, "utSave","none");

        ok = (SwitchCompat) findViewById(R.id.okSw);
        swithHandler(ok, "okSave","oснове-квалитета");



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