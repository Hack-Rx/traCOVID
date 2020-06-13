package com.tanmaya.tracovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cdflynn.android.library.checkview.CheckView;

public class SucessActivity extends AppCompatActivity {
   CheckView mCheckView;
   Button NavHome,NavDiag,NavIns,NavCB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucess);
        NavCB=findViewById(R.id.button8);
        NavIns=findViewById(R.id.button11);
        NavDiag=findViewById(R.id.button10);
        NavHome=findViewById(R.id.button7);
        mCheckView=findViewById(R.id.check);
        mCheckView.check();
        NavDiag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SucessActivity.this,SymptomLogger.class);
                startActivity(intent);
                finish();
            }
        });
        NavCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SucessActivity.this,ChatBotActivity.class);
                startActivity(intent);
                finish();
            }
        });
        NavIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SucessActivity.this,InsureActivity.class);
                startActivity(intent);
                finish();
            }
        });
        NavHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SucessActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}