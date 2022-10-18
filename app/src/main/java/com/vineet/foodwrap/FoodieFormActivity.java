package com.vineet.foodwrap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class FoodieFormActivity extends AppCompatActivity {

    EditText editname, editnum;
    Button btncont;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodie_form);

        editname = findViewById(R.id.editText);

        editnum = findViewById(R.id.editTextPhone);

        btncont = findViewById(R.id.button3);

        ProgressBar progressBar = findViewById(R.id.progressBar);

        //HIDE STATUS BAR
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);



        //HIDE TOOLBAR
        getSupportActionBar().hide();


        btncont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editnum.getText().toString().trim().isEmpty()) {
                    if ((editnum.getText().toString().trim()).length() == 10) {


                        progressBar.setVisibility(View.VISIBLE);
                        btncont.setVisibility(View.INVISIBLE);

                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+91" + editnum.getText().toString(),
                                60,
                                TimeUnit.SECONDS,
                                FoodieFormActivity.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        progressBar.setVisibility(View.GONE);
                                        btncont.setVisibility(View.VISIBLE);
                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressBar.setVisibility(View.GONE);
                                        btncont.setVisibility(View.VISIBLE);
                                        Toast.makeText(FoodieFormActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String otp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        progressBar.setVisibility(View.GONE);
                                        btncont.setVisibility(View.VISIBLE);
                                        Intent intent = new Intent(getApplicationContext(), verifyotpActivity.class);
                                        intent.putExtra("mobile", editnum.getText().toString());
                                        intent.putExtra("backendotp", otp);
                                        startActivity(intent);
                                    }
                                }
                        );


                /*     Intent intent = new Intent(getApplicationContext(), verifyotpActivity.class);
                        intent.putExtra("mobile", editnum.getText().toString());
                        startActivity(intent);

                 */


                    } else {
                        Toast.makeText(FoodieFormActivity.this, "Please Enter correct Number", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(FoodieFormActivity.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}



