package com.vineet.foodwrap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

public class verifyotpActivity extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6;

    String getotpbackend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifyotp);

        final Button verifybuttonclick = findViewById(R.id.verifybutton);


        //HIDE STATUS BAR
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);



        //HIDE TOOLBAR
        getSupportActionBar().hide();

        e1 = findViewById(R.id.otp1);
        e2 = findViewById(R.id.otp2);
        e3 = findViewById(R.id.otp3);
        e4 = findViewById(R.id.otp4);
        e5 = findViewById(R.id.otp5);
        e6 = findViewById(R.id.otp6);


        TextView t1 = findViewById(R.id.textnumber);
        t1.setText(String.format("on +91-%s", getIntent().getStringExtra("mobile")
        ));


        getotpbackend = getIntent().getStringExtra("backendotp");

       final ProgressBar progressBarverifyotp = findViewById(R.id.progressbarotp);


        verifybuttonclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                if(!e1.getText().toString().trim().isEmpty() && !e2.getText().toString().trim().isEmpty() && !e3.getText().toString().trim().isEmpty() && !e4.getText().toString().trim().isEmpty() && !e5.getText().toString().trim().isEmpty() && !e6.getText().toString().trim().isEmpty()){
                   String entercodeotp = e1.getText().toString() +
                           e2.getText().toString() + e3.getText().toString() +
                           e4.getText().toString() + e5.getText().toString() +
                           e6.getText().toString();

                   if(getotpbackend!=null){

                       progressBarverifyotp.setVisibility(View.VISIBLE);
                       verifybuttonclick.setVisibility(View.INVISIBLE);

                       PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                               getotpbackend, entercodeotp);

                       FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                               .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                   @Override
                                   public void onComplete(@NonNull Task<AuthResult> task) {
                                       progressBarverifyotp.setVisibility(View.GONE);
                                       verifybuttonclick.setVisibility(View.VISIBLE);


                                       if(task.isSuccessful()){
                                           Intent intent = new Intent(getApplicationContext(), dashboard.class);
                                           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                           startActivity(intent);

                                       }else{
                                           Toast.makeText(verifyotpActivity.this, "Enter the correct OTP", Toast.LENGTH_SHORT).show();
                                       }


                                   }
                               });

                   }else{
                       Toast.makeText(verifyotpActivity.this, "Please check internet connection", Toast.LENGTH_SHORT).show();
                   }

                    // Toast.makeText(verifyotpActivity.this, "OTP verify", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(verifyotpActivity.this, "Please enter all number", Toast.LENGTH_SHORT).show();
                }

            }
        });

numberotpmove();



TextView resendlabel = findViewById(R.id.textresendotp);

resendlabel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + getIntent().getStringExtra("mobile"),
                60,
                TimeUnit.SECONDS,
                verifyotpActivity.this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {

                        Toast.makeText(verifyotpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(@NonNull String newotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                        super.onCodeSent(newotp, forceResendingToken);

                        getotpbackend = newotp;
                        Toast.makeText(verifyotpActivity.this, "OTP sended successfully", Toast.LENGTH_SHORT).show();


                    }
                }
        );
    }
});

    }

    private void numberotpmove() {


        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    e2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        e2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    e3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        e3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    e4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        e4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    e5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        e5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    e6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}