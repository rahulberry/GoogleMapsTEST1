package com.example.rahulberry.googlemaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    Button create_account;
    Button login;
    Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        test= (Button)findViewById(R.id.testbutton);
        create_account= (Button)findViewById(R.id.create_new);
        login = (Button)findViewById(R.id.login2);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            MapsActivity send = MapsActivity.instance();
            send.sendMsg("+447541241808", "Test");
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this, MapsActivity.class);
                startActivity(i);
            }
        });
        create_account.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            Intent i = new Intent(login.this,register.class);
                startActivity(i);
            }
        });
        }
    }
//MAKE THIS FUNCTION USING THE PREMADE LOGIN MENU ANDROID STUDIO OFFERS!!!







