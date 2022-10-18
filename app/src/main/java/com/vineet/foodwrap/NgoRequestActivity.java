package com.vineet.foodwrap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NgoRequestActivity extends AppCompatActivity {
    TextView details, daterequest;
    int y1,m2,d3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_request);

        //HIDE STATUS BAR
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);



        //HIDE TOOLBAR
        getSupportActionBar().hide();


        daterequest = findViewById(R.id.textView6);
        details = findViewById(R.id.textView4);

        Bundle b =getIntent().getExtras();
        String fi = b.getString("food_item_key");
        String fc= b.getString("food_count_key");
        String date = b.getString("date_key");
        String NgoName = b.getString("ngo_name_key");
        String mn = b.getString("member_name_key");
        details.setText(" Food Item:- "+fi+"\n Food Count:- "+fc+"\n NGO Name:- "+NgoName+"\n Member Name:- "+mn);
        daterequest.setText("Date:- "+date);

    }
}