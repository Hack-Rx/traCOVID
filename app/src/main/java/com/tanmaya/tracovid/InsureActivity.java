package com.tanmaya.tracovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InsureActivity extends AppCompatActivity {
    Button NavHome,NavCB,NavDiag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insure);
        NavHome=findViewById(R.id.button7);
        NavCB=findViewById(R.id.button8);
        NavDiag=findViewById(R.id.button10);
        NavCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsureActivity.this,ChatBotActivity.class);
                startActivity(intent);
                finish();
            }
        });
        NavHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsureActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        NavDiag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsureActivity.this,SymptomLogger.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
