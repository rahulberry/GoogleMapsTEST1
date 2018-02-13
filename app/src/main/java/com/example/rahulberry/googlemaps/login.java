package com.example.rahulberry.googlemaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    Button register;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = (Button)findViewById(R.id.register);
        login = (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this, MapsActivity.class);
                startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            Intent i = new Intent(login.this,register.class);
                startActivity(i);
            }
        });
        }
    }








