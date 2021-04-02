package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean xTurn = true;
    int[] tableArray = new int[10];
    int numTurn;

    public void clickFun(View view){
        ImageView currentImg = (ImageView) view;

        if(currentImg.getAlpha() == 0) {
            if (xTurn) {
                currentImg.setImageResource(R.drawable.x);
                tableArray[Integer.parseInt(currentImg.getTag().toString())] = 'x';
            }
            else {
                currentImg.setImageResource(R.drawable.o);
                tableArray[Integer.parseInt(currentImg.getTag().toString())] = 'o';
            }

            xTurn = !xTurn;
            numTurn++;

            // Move the img up out of the screen instantly
            currentImg.setY(-1000 + currentImg.getY());

            // Set Alpha to 1, making it visible
            currentImg.animate().alpha(1);

            // Move the img back down to the screen
            currentImg.animate().translationYBy(1000).setDuration(0);

            /* // For debugging
            String str = "tableArray:";
            int[] arr = check();
            for(int i = 0; i < 3; i++)
                str += " " + arr[i];
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
            */

            //Check if there is a winner
            int[] checkResult = check();
            if(checkResult[0] != 0){
                TextView outputText = (TextView) findViewById(R.id.textView);
                Button restartButton = (Button) findViewById(R.id.buttonRestart);
                if(checkResult[2] == 3){
                    outputText.setText("X is the winner!");
                }
                else {
                    outputText.setText("o is the winner!");
                }
                outputText.animate().alpha(1).setDuration(1000);
                restartButton.animate().alpha(1).setDuration(1000);
            }
            if(numTurn >= 9){
                TextView outputText = (TextView) findViewById(R.id.textView);
                Button restartButton = (Button) findViewById(R.id.buttonRestart);
                outputText.setText("It's a draw!");
                outputText.animate().alpha(1).setDuration(1000);
                restartButton.animate().alpha(1).setDuration(1000);
            }
        }
    }

    public int[] check(){
        int[] arr = {0,0,0};
        int result = 0;

        //check row
        for(int i = 0; i < 3; i++){
            for(int j = i*3; j < (3*i)+3; j++){
                if(tableArray[j] == 'x')
                    result += 1;
                if(tableArray[j] == 'o')
                    result += 4;
                if(result == 3 || result == 12){
                    arr[0] = 1;
                    arr[1] = i;
                    arr[2] = result;
                    return arr;
                }
            }
            result = 0;
        }

        //check col
        for(int i = 0; i < 3; i++){
            for(int j = i; j < i+7; j+=3){
                if(tableArray[j] == 'x')
                    result += 1;
                if(tableArray[j] == 'o')
                    result += 4;
                if(result == 3 || result == 12){
                    arr[0] = 2;
                    arr[1] = i;
                    arr[2] = result;
                    return arr;
                }
            }
            result = 0;
        }

        //check cross
        for(int i = 0; i < 9; i+=4){
            if(tableArray[i] == 'x')
                result += 1;
            if(tableArray[i] == 'o')
                result += 4;
            if(result == 3 || result == 12){
                arr[0] = 3;
                arr[1] = 0;
                arr[2] = result;
                return arr;
            }
        }
        result = 0;

        //check cross /
        for(int i = 2; i < 9; i+=2){
            if(tableArray[i] == 'x')
                result += 1;
            if(tableArray[i] == 'o')
                result += 4;
            if(result == 3 || result == 12){
                arr[0] = 3;
                arr[1] = 1;
                arr[2] = result;
                return arr;
            }
        }

        // return [0,0,0] if there are no winner
        return arr;
    }

    public void restartGame() {
        tableArray = new int[10];
        xTurn = true;
        numTurn = 0;

        // Make restart button and text invisible
        TextView outputText = (TextView) findViewById(R.id.textView);
        Button restartButton = (Button) findViewById(R.id.buttonRestart);
        outputText.animate().alpha(0).setDuration(0);
        restartButton.animate().alpha(0).setDuration(0);

        // Set all images on table to invisible
        ImageView img = (ImageView) findViewById(R.id.imgView1);
        img.animate().alpha(0).setDuration(0);
        img = (ImageView) findViewById(R.id.imgView2);
        img.animate().alpha(0).setDuration(0);
        img = (ImageView) findViewById(R.id.imgView3);
        img.animate().alpha(0).setDuration(0);
        img = (ImageView) findViewById(R.id.imgView4);
        img.animate().alpha(0).setDuration(0);
        img = (ImageView) findViewById(R.id.imgView5);
        img.animate().alpha(0).setDuration(0);
        img = (ImageView) findViewById(R.id.imgView6);
        img.animate().alpha(0).setDuration(0);
        img = (ImageView) findViewById(R.id.imgView7);
        img.animate().alpha(0).setDuration(0);
        img = (ImageView) findViewById(R.id.imgView8);
        img.animate().alpha(0).setDuration(0);
        img = (ImageView) findViewById(R.id.imgView9);
        img.animate().alpha(0).setDuration(0);
    }

    public void testFun(View view){

    }

    public void restartFun(View view){
        restartGame();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restartGame();
    }
}
