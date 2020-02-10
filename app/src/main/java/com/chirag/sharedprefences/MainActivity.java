package com.chirag.sharedprefences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    private FirebaseAuth mAuth;
    FirebaseUser firebaseUser;


    EditText email,password;
    Button login;


    @Override
    protected void onStart() {
        super.onStart();
         String loginid=sharedPref.getString("loginid","chirag123@gmail.com");

         email.setText(loginid);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        editor = sharedPref.edit();



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth=FirebaseAuth.getInstance();//fire base authentication variable initializing.

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        email.requestFocus();

        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(email.getText().toString().isEmpty()||password.getText().toString().isEmpty())
                {
                    email.setError("please fill first");
                    password.setError("please fill first");
                }
                else
                {
                 mAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {

                            String loginid=email.getText().toString();

                            editor.putString("loginid",loginid);
                            editor.apply();

                            Toast.makeText(getApplicationContext(),"login success",Toast.LENGTH_SHORT).show();
                            change_layout_to_profile();
                        }
                        else
                            {
                                Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_SHORT).show();
                            }
                     }
                 });
                }









            }
        });



    }

    private void change_layout_to_profile() {

    }
}
