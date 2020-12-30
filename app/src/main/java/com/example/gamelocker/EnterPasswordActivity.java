package com.example.gamelocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPasswordActivity extends AppCompatActivity {
    EditText editText;
    Button button;

    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);



        SharedPreferences settings = getSharedPreferences("PRESS", 0);
        password = settings.getString("Password", "");

        editText =(EditText) findViewById(R.id.editTextTextPassword);
        button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
//testing
                int shift = 3;
                String s = "";
                int len = password.length();
                for (int x = 0; x < len; x++) {
                    char c = (char) (password.charAt(x) + shift);
                    if (c > 'z' || (c > 'Z' && c < 'd'))
                    {
                        c -= 26;
                    }

                    s += c;
                }



//test ended
                if (text.equals(s)){
                    Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();

                }
                else{
                    Toast.makeText(EnterPasswordActivity.this, "Wrong Passowrd", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}