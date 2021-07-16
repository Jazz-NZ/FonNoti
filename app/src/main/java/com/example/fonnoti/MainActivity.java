package com.example.fonnoti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;


public class MainActivity extends AppCompatActivity {

    private Button prva;
    private Button druga;
    private Button treca;

    private static final String TAG = "FirebaseMessagingSevise";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast

                        //Log.d(TAG, token);
                        Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
                    }
                });


        FirebaseMessaging.getInstance().subscribeToTopic("highScores") // uspostavlja se konekcija sa serverom
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Uspesno";
                        if (!task.isSuccessful()) {
                            msg = "Neuspesno";
                        }
                        Log.d(TAG, msg);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });


            prva = (Button) findViewById(R.id.prvaGodBtn);
            prva.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openPrvaGodina();
                }
            });

        druga = (Button) findViewById(R.id.drugaGodBtn);
        druga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrugaGodina();
            }
        });

        treca = (Button) findViewById(R.id.trecaGodBtn);
        treca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrecaGodina();
            }
        });

    }



    public void openPrvaGodina(){

        Intent intentPrvaGodina = new Intent(this, PrvaGodinaActivity.class);
        startActivity(intentPrvaGodina);
    }

    public void openDrugaGodina(){

        Intent intentDrugaGodina = new Intent(this, DrugaGodinaActivity.class);
        startActivity(intentDrugaGodina);
    }

    public void openTrecaGodina(){

        Intent intentTrecaGodina = new Intent(this, TrecaGodinaActivity.class);
        startActivity(intentTrecaGodina);
    }

    public static void subToTopic(String topic){

        FirebaseMessaging.getInstance().subscribeToTopic(topic) // uspostavlja se konekcija sa serverom
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Uspesno";
                        if (!task.isSuccessful()) {
                            msg = "Neuspesno";
                        }
                        Log.d(TAG, msg);

                    }
                });

    }
    public static void unsubFromTopic(String topic){

        FirebaseMessaging.getInstance().unsubscribeFromTopic(topic);

    }


}