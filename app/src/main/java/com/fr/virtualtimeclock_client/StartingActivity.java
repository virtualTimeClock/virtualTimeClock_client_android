package com.fr.virtualtimeclock_client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class StartingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);   // | retire la barre de notification android pour que le jeu soit en plein écran
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Hide ActionBar
        getSupportActionBar().hide();

        setContentView(R.layout.activity_starting);
        //Timer qui a bout de 5s lance l'activité de l'écran d'acceuil
        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try { sleep(4000); }
                catch (Exception e) { e.printStackTrace(); }
                finally {
                    Intent mainIntent = new Intent(StartingActivity.this, MissionManagerActivity.class);
                    startActivity(mainIntent);
                }
            }
        };
        thread.start();
    }
    //ferme cette activité une fois le temps écouler
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
