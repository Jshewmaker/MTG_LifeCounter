package com.example.yeti.mtg_lifecounter;

import android.app.Activity;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Player_1_Fragment player1Fragment;
    Player_2_Fragment player2Fragment;
    DiceFragment diceFragment;
    private ImageButton menuButton;
    int player1_life, player2_life, diceLower, diceUpper;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framelayout);
        player1_life = 20;
        player2_life = 20;
        diceLower = 1;
        diceUpper = 6;
        hideSystemUI();

        player1Fragment = new Player_1_Fragment();
        player2Fragment = new Player_2_Fragment();
        diceFragment = new DiceFragment();





        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.player1, player1Fragment, "player1");
        transaction.add(R.id.player2, player2Fragment, "player2");

        transaction.commit();

        menuButton = findViewById(R.id.menubutton);
        menuButton.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v){

                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.add(R.id.player1,  diceFragment, "dice");
                    ft.add(R.id.player2, new DiceOutPutFragment(), "diceOutput");
                    ft.addToBackStack(null);
                    ft.commit();

            }
        });




    }//end onCreate

    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI();

    }


    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);

    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}