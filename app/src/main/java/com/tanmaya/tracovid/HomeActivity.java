package com.tanmaya.tracovid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    Button CB,NavCB,LS,FAQ,Zones,NavIns,Ins,NavDiag,NavConsult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FAQ=findViewById(R.id.button16);
        Zones=findViewById(R.id.button15);
        CB=findViewById(R.id.button6);
        NavCB=findViewById(R.id.button8);
        LS=findViewById(R.id.button3);
        NavIns=findViewById(R.id.button11);
        NavDiag=findViewById(R.id.button10);
        NavConsult=findViewById(R.id.button9);
        Ins=findViewById(R.id.button5);
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
        Zones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,ZonesActivity.class);
                startActivity(intent);
                finish();
            }
        });
        FAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,FAQActivity.class);
                startActivity(intent);
                finish();
            }
        });
        NavIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,InsureActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,InsureActivity.class);
                startActivity(intent);
                finish();
            }
        });
        NavDiag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,SymptomLogger.class);
                startActivity(intent);
                finish();
            }
        });
        NavConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,ConsultActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
