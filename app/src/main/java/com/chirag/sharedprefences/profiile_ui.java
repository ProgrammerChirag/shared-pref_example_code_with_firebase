package com.chirag.sharedprefences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class profiile_ui extends AppCompatActivity {

    TextView id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiile_ui);

        id=findViewById(R.id.loginid);


        SharedPreferences sharedPreferences=profiile_ui.this.getPreferences(Context.MODE_PRIVATE);


        String def_Value=getResources().getString(R.string.account_id);


        id.setText(sharedPreferences.getString("loginid", def_Value));
    }
}
