package com.dionnecondorfarrell.cookieclicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int currentScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageCookie = (ImageView)findViewById(R.id.image_cookie);

        final TextView  totalLabel = (TextView)findViewById(R.id.totalLabel);

        imageCookie.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                currentScore++;

                totalLabel.setText(String.valueOf(currentScore));

                    if(currentScore < 10){
                        totalLabel.setTextColor(Color.RED);
                        imageCookie.setImageResource(R.drawable.cookie);

                    }
                    else if (currentScore >= 10  && currentScore < 20){
                        totalLabel.setTextColor(Color.BLUE);
                        imageCookie.setImageResource(R.drawable.cookies_three);
                    }
                    else if (currentScore >= 20 && currentScore < 30 ){
                        totalLabel.setTextColor(Color.GREEN);
                        imageCookie.setImageResource(R.drawable.cookies_loads);

                    }
                    else if (currentScore == 30){
                        totalLabel.setText(R.string.congratulations);
                        imageCookie.setImageResource(R.drawable.cookies_eight);
                        currentScore = 0;
                    }
                }


        });

    }
}
