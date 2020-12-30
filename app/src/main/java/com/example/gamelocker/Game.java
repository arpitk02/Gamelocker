package com.example.gamelocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game extends AppCompatActivity {

    TextView tv_info, tv_word;
    EditText et_guess;
    Button b_check;

    Random r;

    String currentword;
    String[] dictionary = {
            "DELHI",
            "MUMBAI",
            "PATNA",
            "VIJAYAWADA",
            "FARIDABAD",
            "VALAMORGULIS",
            "UNIVERSITY",
            "DILATORY",
            "HOIPOLLOI",
            "HEELODEELO"


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tv_info = (TextView) findViewById(R.id.tv_info);
        tv_word = (TextView) findViewById(R.id.tv_word);

        et_guess = (EditText) findViewById(R.id.et_guess);

        b_check = (Button) findViewById(R.id.b_check);

        r = new Random();


        newGame();


        b_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_guess.getText().toString().equalsIgnoreCase(currentword)) {
                    tv_info.setText("You have done it!!");
                    b_check.setEnabled(false);
                    Intent intent= new Intent(getApplicationContext(), EnterPasswordActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    tv_info.setText("Try Again");
                }
            }
        });
    }

    private String shuffledWord(String word) {
        List<String> letters = Arrays.asList(word.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for (String letter : letters) {
            shuffled += letter;
        }
        return shuffled;
    }

    private void newGame() {
        currentword = dictionary[r.nextInt(dictionary.length)];

        tv_word.setText(shuffledWord(currentword));

        et_guess.setText("");

        b_check.setEnabled(true);


    }

}