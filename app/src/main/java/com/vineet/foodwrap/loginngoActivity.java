package com.vineet.foodwrap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class loginngoActivity extends AppCompatActivity {

    Button ngobuttn; //continue button
    TextView ngoSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginngo);

        //HIDE STATUS BAR
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);



        //HIDE TOOLBAR
        getSupportActionBar().hide();

        ngobuttn = findViewById(R.id.button3);


        ngoSignup =findViewById(R.id.textView8);


        ngoSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginngoActivity.this, NGOSignUpActivity.class));
            }
        });
    }
}