package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;
    //player reprensentation
    //0-x
    //1-o
    int activePlayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    //state meanings
    // 0-x
    //1-o
    //2-null
    int[][] winPositions={{0,1,2},{3,4,5},
            {6,7,8},{0,3,6},
            {1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};
    public void playerTap(View view){
        ImageView img=(ImageView) view;
        int tappedImage=Integer.parseInt(img.getTag().toString());
        if(!gameActive) {
            gamereset(view);

        }
        if(gameState[tappedImage]==2  ){
            gameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0){
                img.setImageResource(R.drawable.x1);
                activePlayer=1;
                TextView status=findViewById(R.id.status);
                status.setText("O's turn-tap to play");
                
            }
            else{
                img.setImageResource(R.drawable.o);
                activePlayer=0;
                TextView status=findViewById(R.id.status);
                status.setText("X's turn-tap to play");

            }
            img.animate().translationYBy(1000f).setDuration(400);
        }

        //check if any player has won
        for(int[] winPosition:winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                //somebody has won!=find out who
                String winnerstr;
                gameActive = false;
                if (gameState[winPosition[0]] == 0) {
                    winnerstr = "X has won";

                } else {
                    winnerstr = "o has won";
                }
                //update the status bar for winner announcement
                TextView status = findViewById(R.id.status);
                status.setText(winnerstr);


            }
        }
            boolean emptySquare=false;
            for(int squareState:gameState){
                if(squareState==2){
                       emptySquare = true;
                    break;
                }
            }
            if (!emptySquare && gameActive) {
                // Game is a draw
                gameActive = false;
                String winnerStr;
                winnerStr = "No one won";
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
                }
            }




    public void gamereset(View view){
        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++){
        gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView35)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView45)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView25)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        TextView status=findViewById(R.id.status);
        status.setText("X's turn-tap to play");

        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

