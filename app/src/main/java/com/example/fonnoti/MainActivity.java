package com.example.fonnoti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;


public class MainActivity extends AppCompatActivity {

    private Button button;

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


            button = (Button) findViewById(R.id.prvaGodBtn);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openPrvaGodina();
                }
            });


    }



    public void openPrvaGodina(){

        Intent intentPrvaGodina = new Intent(this, PrvaGodinaActivity.class);
        startActivity(intentPrvaGodina);
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