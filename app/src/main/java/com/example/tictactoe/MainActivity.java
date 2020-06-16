package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean xTurn = true;

    public void clickFun(View view){
        ImageView currentImg = (ImageView) view;

        if(currentImg.getAlpha() == 0) {
            if (xTurn)
                currentImg.setImageResource(R.drawable.x);
            else
                currentImg.setImageResource(R.drawable.o);
            xTurn = !xTurn;

            // Move the img up out of the screen instantly
            currentImg.setY(-1000 + currentImg.getY());

            // Set Alpha to 1, making it visible
            currentImg.animate().alpha(1);

            // Move the img back down to the screen
            currentImg.animate().translationYBy(1000).setDuration(2000);
        }
    }

    public void check(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img = (ImageView) findViewById(R.id.imgView1);
        img.animate().alpha(0);
        img = (ImageView) findViewById(R.id.imgView2);
        img.animate().alpha(0);
        img = (ImageView) findViewById(R.id.imgView3);
        img.animate().alpha(0);
        img = (ImageView) findViewById(R.id.imgView4);
        img.animate().alpha(0);
        img = (ImageView) findViewById(R.id.imgView5);
        img.animate().alpha(0);
        img = (ImageView) findViewById(R.id.imgView6);
        img.animate().alpha(0);
        img = (ImageView) findViewById(R.id.imgView7);
        img.animate().alpha(0);
        img = (ImageView) findViewById(R.id.imgView8);
        img.animate().alpha(0);
        img = (ImageView) findViewById(R.id.imgView9);
        img.animate().alpha(0);
    }
}
