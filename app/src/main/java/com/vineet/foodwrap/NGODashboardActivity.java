package com.vineet.foodwrap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NGODashboardActivity extends AppCompatActivity {

    Button raiserequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngodashboard);

        //HIDE STATUS BAR
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);





        //HIDE TOOLBAR
        getSupportActionBar().hide();

        raiserequest = findViewById(R.id.raiserequest);

        raiserequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NGODashboardActivity.this, RaiseRequest.class));
            }
        });
    }
}