package com.chirag.sharedprefences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;


    EditText email;
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

        email=findViewById(R.id.email);
        email.requestFocus();

        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginid=email.getText().toString();

                editor.putString("loginid",loginid);
                editor.apply();


                String def_Value=getResources().getString(R.string.account_id);
                loginid=sharedPref.getString("loginid",def_Value);

                email.setText(loginid);

            }
        });



    }
}
