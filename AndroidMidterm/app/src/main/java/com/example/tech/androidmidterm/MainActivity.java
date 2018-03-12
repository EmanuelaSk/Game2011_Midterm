/*
Android Memory Game  (Midterm)

Ivan Echavarria     101092562        2018/03/12
Emanuela Sklarzyk   101033593        2018/03/12

Android out of scope of what we have learned in class.

 */


package com.example.tech.androidmidterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    int[] ImageButtonList = new int[]{R.drawable.card_1c, R.drawable.card_1d, R.drawable.card_1h, R.drawable.card_1s,
                                      R.drawable.card_2c, R.drawable.card_2d, R.drawable.card_2h , R.drawable.card_2s,
                                      R.drawable.card_3c, R.drawable.card_3d, R.drawable.card_3h,   R.drawable.card_3s,
                                      R.drawable.card_4c, R.drawable.card_4d, R.drawable.card_4h, R.drawable.card_4s,
                                        R.drawable.card_5c, R.drawable.card_5d, R.drawable.card_5h, R.drawable.card_5s,
                                        R.drawable.card_6c, R.drawable.card_6d, R.drawable.card_6h, R.drawable.card_6s,
                                        R.drawable.card_7c, R.drawable.card_7d, R.drawable.card_7h, R.drawable.card_7s,
                                        R.drawable.card_8c, R.drawable.card_8d, R.drawable.card_8h, R.drawable.card_8s,
                                        R.drawable.card_9c, R.drawable.card_9d, R.drawable.card_9h, R.drawable.card_9s,
                                        R.drawable.card_10c, R.drawable.card_10d, R.drawable.card_10h, R.drawable.card_10s,
                                        R.drawable.card_11c,R.drawable.card_11d, R.drawable.card_11h, R.drawable.card_11s,
                                        R.drawable.card_12c, R.drawable.card_12d, R.drawable.card_12h, R.drawable.card_12s,
                                        R.drawable.card_13c, R.drawable.card_13d, R.drawable.card_13h, R.drawable.card_13s
    };

    private ImageButton one;
    private ImageButton two;
    private ImageButton three;
    private ImageButton four;
    private ImageButton five;
    private ImageButton six;
    private ImageButton seven;
    private ImageButton eight;
    private ImageButton nine;
    private ImageButton ten;
    private ImageButton eleven;
    private ImageButton twelve;
    private ImageButton thirteen;
    private ImageButton fourteen;
    private ImageButton fifteen;
    private ImageButton sixteen;

private TextView timerText;

    ImageButton[] randomButtons = new ImageButton[8];
    int[] duplicates = new int[8];
    int[][] grid = new int[4][4];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerText = (TextView) findViewById(R.id.timer);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerText.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timerText.setText("times up!");
            }
        }.start();

        ImageButton one = (ImageButton) findViewById(R.id.image1);
        plusOneBtnListener plusUno = new plusOneBtnListener();
        one.setOnClickListener(plusUno);

        for(int i= 0; i < duplicates.length; i++)
        {
            duplicates[i] = -1;
        }

        for(int i = 0; i < randomButtons.length ; i++ )
        {
            int newRandom = selectRandomCards();
            randomButtons[i].setImageResource(ImageButtonList[newRandom]);
        }

        for(int i = 0; i < 4 ; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                grid[i][j] = -1;
            }
        }

        for(int i = 0; i < 4 ; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                int newCard = randomGrid();

                grid[i][j] = newCard;
            }
        }

    }

    private int selectRandomCards() {

        int randomCard = (int) Math.floor(Math.random() * ImageButtonList.length);
        for(int j = 0; j < duplicates.length ; j++)
        {
            if(randomCard == duplicates[j])
            {
                selectRandomCards();
                break;
            }
            else
            {
                duplicates[j] = randomCard;
                break;
            }
        }
        return randomCard;
    }

    private int randomGrid() {

        int randomCard = (int) Math.floor(Math.random() * randomButtons.length);

        return randomCard;
    }

    private class plusOneBtnListener implements View.OnClickListener{
        @Override
        public void onClick(View v)
        {
            one.setImageResource(ImageButtonList[0]);
        }
    }


}




