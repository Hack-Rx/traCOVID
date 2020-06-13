package com.tanmaya.tracovid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    Button CB,NavCB,LS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        CB=findViewById(R.id.button6);
        NavCB=findViewById(R.id.button8);
        LS=findViewById(R.id.button3);
        CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,ChatBotActivity.class);
                startActivity(intent);
                finish();
            }
        });
        NavCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,ChatBotActivity.class);
                startActivity(intent);
                finish();
            }
        });
        LS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,SymptomLogger.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
