package com.vineet.foodwrap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class RaiseRequest extends AppCompatActivity {

    EditText fooditem,feedcount,datetext,ngoname,member;
    Button b;
    int y,m,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raise_request);


        //HIDE STATUS BAR
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);



        //HIDE TOOLBAR
        getSupportActionBar().hide();


        fooditem= findViewById(R.id.fooditem);
        feedcount = findViewById(R.id.feedcount);
        datetext = findViewById(R.id.date);
        ngoname= findViewById(R.id.ngoname);
        member= findViewById(R.id.membername);
        b = findViewById(R.id.button);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getSupportFragmentManager().beginTransaction().add(R.id.mainpage,new NgoRequestFragment()).addToBackStack("").commit();

                String fi = fooditem.getText().toString();
                String fc= feedcount.getText().toString();
                String date =datetext.getText().toString();
                String NgoName = ngoname.getText().toString();
                String mn = member.getText().toString();
                Intent i = new Intent(RaiseRequest.this,NgoRequestActivity.class);
                i.putExtra("food_item_key",fi);
                i.putExtra("food_count_key",fc);
                i.putExtra("date_key",date);
                i.putExtra("ngo_name_key",NgoName);
                i.putExtra("member_name_key",mn);
                startActivity(i);

            }
        });
        datetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(RaiseRequest.this,listener,y,m,d).show();

                Calendar ca= Calendar.getInstance();
                y = ca.get(Calendar.YEAR);
                m = ca.get(Calendar.MONTH);
                d = ca.get(Calendar.DATE);

            }
        });
    }
    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            datetext.setText(i2+"-"+(i1+1)+"-"+i);
            y= i;
            m= i1;
            d = i2;
        }
    };

}
