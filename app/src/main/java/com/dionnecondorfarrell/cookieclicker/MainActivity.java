package com.dionnecondorfarrell.cookieclicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int currentScore = 0;

    //advanced steps
    private int totalRoundsSinceGameReset = 0;
    private int totalPointsSinceGameReset = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageCookie = (ImageView)findViewById(R.id.image_cookie);

        final TextView  currentTotalLabel = (TextView)findViewById(R.id.currentTotalLabel);

        final TextView statusCheck = (TextView)findViewById(R.id.statusCheck);

        final TextView totalRoundsSinceGameLabel = (TextView)findViewById(R.id.totalRoundsThisGameLabel);

        final TextView totalPointsSinceResetLabel = (TextView)findViewById(R.id.totalPointsSinceResetLabel);

        final Button resetBtn = (Button)findViewById(R.id.resetBtn);

        imageCookie.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                currentScore++;

                currentTotalLabel.setText(String.valueOf(currentScore));

                if (currentScore > 0) {
                    resetBtn.setVisibility(View.VISIBLE);

                    //advanced steps
                    totalRoundsSinceGameLabel.setVisibility(View.INVISIBLE);
                    totalPointsSinceResetLabel.setVisibility(View.INVISIBLE);
                }

                if (currentScore < 10) {
                    currentTotalLabel.setTextColor(Color.RED);
                    imageCookie.setImageResource(R.drawable.cookie);
                    statusCheck.setText(R.string.statusCheckTxt2);
                } else if (currentScore >= 10 && currentScore < 20) {
                    currentTotalLabel.setTextColor(Color.BLUE);
                    imageCookie.setImageResource(R.drawable.cookies_three);
                    statusCheck.setText(R.string.statusCheckTxt3);
                } else if (currentScore >= 20 && currentScore < 30) {
                    currentTotalLabel.setTextColor(Color.GREEN);
                    imageCookie.setImageResource(R.drawable.cookies_loads);
                    statusCheck.setText(R.string.statusCheckTxt4);

                } else if (currentScore == 30) {
                    currentTotalLabel.setText(R.string.congratulations);
                    imageCookie.setImageResource(R.drawable.cookies_eight);
                    statusCheck.setText(R.string.statusCheckTxt5);


                    //advanced steps - Show total number of rounds since game reset
                    totalRoundsSinceGameReset++;
                    totalRoundsSinceGameLabel.setText(getString(R.string.total_rounds_text, totalRoundsSinceGameReset));
                    totalRoundsSinceGameLabel.setVisibility(View.VISIBLE);

                    //advanced steps - Show total points since game reset
                    totalPointsSinceGameReset = totalPointsSinceGameReset + currentScore;
                    totalPointsSinceResetLabel.setText(getString(R.string.total_points_text, totalPointsSinceGameReset));
                    totalPointsSinceResetLabel.setVisibility(View.VISIBLE);

                    currentScore = 0;

                }
            }

        });


        //Add Game Reset Button - recreate this Activity if reset button click
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

    }
}
