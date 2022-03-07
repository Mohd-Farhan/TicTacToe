package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    // Player representation
    // 0 - X
    // 1 - O
    public static final String result="MainActivity.result";
    String winner="";
   int c=0;
    int activePlayer = 0;
    int[] gameState = {2, 2 , 2, 2, 2, 2, 2, 2, 2};
    //    State meanings:
    //    0 - X
    //    1 - O
    //    2 - Null
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};
    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        Intent intent=new Intent(this,resultActivity.class);
        Intent intent1= getIntent();
        String player1= intent1.getStringExtra(homeActivity.player1);
        String player2= intent1.getStringExtra(homeActivity.player2);
        if(c==0)
        {
            TextView status = findViewById(R.id.textView);
            status.setText(player1+"'s Turn - Tap to play");
        }
        if (gameState[tappedImage] == 2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                activePlayer = 1;
                c++;
                TextView status = findViewById(R.id.textView);
                status.setText(player2+"'s Turn - Tap to play");
                img.setImageResource(R.drawable.x);
            } else {

                activePlayer = 0;
                c++;
                TextView status = findViewById(R.id.textView);
                status.setText(player1+"'s Turn - Tap to play");
                img.setImageResource(R.drawable.o);
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
    // Check if any player has won

        for(int[] winPosition: winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                // Somebody has won! - Find out who!
                gameActive = false;

                if (gameState[winPosition[0]] == 0) {
                    winner = player1+" has won";
                } else {
                    winner = player2+" has won";
                }
                // Update the status bar for winner announcement
            intent.putExtra(result,winner);
                startActivity(intent);
                finish(); //change

            }

            else{
            if (c == 9) {
                winner="Tie";
             intent.putExtra(result,winner);
             startActivity(intent);
             finish();  //change
                gameActive = false;
            }}
        }
    }

//    public void gameReset(View view) {
//        gameActive = true;
//        activePlayer = 0;
//        for(int i=0; i<gameState.length; i++){
//            gameState[i] = 2;
//        }
//        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
//        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
//        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
//        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
//        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
//        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
//        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
//        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
//        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
//          c=0;
//        TextView status = findViewById(R.id.textView);
//        Intent intent1= getIntent();
//        String player1= intent1.getStringExtra(homeActivity.player1);
//        status.setText(player1+"'s Turn - Tap to play");
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

