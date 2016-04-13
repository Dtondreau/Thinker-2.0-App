package com.dtondreau.thinker20;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Game1Activity extends AppCompatActivity {

    String mWord = "Adams";

    int mFailCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);


    }

    /**
     * This is the code for retrieving letters on the editText
     */

    public void introduceLetter(View v) {

        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);

        String letter = myEditText.getText().toString();

        Log.d("MYLOG", "The Letter introduced is " + letter);

        if (letter.length() == 1) {
            checkLetter(letter);
        } else {
            Toast.makeText(this, "Please Enter A Letter", Toast.LENGTH_SHORT).show();

        }
    }

    public void checkLetter(String introducedLetter) {

        char charIntroduced = introducedLetter.charAt(0);

        boolean letterGuessed = false;

        for (int i = 0; i < mWord.length(); i++) {

            char charFromTheWord = mWord.charAt(i);

            Log.d("My Log", "The Letter we are checking is " + charFromTheWord);

            if (charFromTheWord == charIntroduced) {

                Log.d("MYLOG", "There was one match ");

                letterGuessed = true;

                showLettersAtIndex(i, charIntroduced);
            }
        }

        if(letterGuessed == false){
            letterFailed(Character.toString(charIntroduced));
        }
    }

    public void letterFailed(String letterFailed){

        TextView textViewFailed = (TextView) findViewById(R.id.textView13);

        String previousFail = textViewFailed.getText().toString();

        textViewFailed.setText(previousFail+letterFailed);

        mFailCounter = mFailCounter++;
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        if (mFailCounter == 1) {
            imageView.setImageResource(R.drawable.g1);
        } else if (mFailCounter == 2) {
            imageView.setImageResource(R.drawable.g2);
        }else if (mFailCounter == 3) {
            imageView.setImageResource(R.drawable.g3);
        }else if (mFailCounter == 4) {
            imageView.setImageResource(R.drawable.g4);
        }else if (mFailCounter == 5) {
            imageView.setImageResource(R.drawable.g5);
        } else if (mFailCounter == 6){
            //TODO Game Over
        }

    }


        //Display a letter guesses by user

            public void showLettersAtIndex(int position, char letterGuessed) {

                LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);

                TextView textView = (TextView) layoutLetter.getChildAt(position);

                textView.setText(Character.toString(letterGuessed));

                //Show Letters on the screen

            }
        }



