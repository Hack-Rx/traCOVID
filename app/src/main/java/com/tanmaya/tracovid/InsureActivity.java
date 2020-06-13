package com.tanmaya.tracovid;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InsureActivity extends AppCompatActivity {
    Button NavHome,NavCB,NavDiag,OC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insure);
        NavHome=findViewById(R.id.button7);
        NavCB=findViewById(R.id.button8);
        NavDiag=findViewById(R.id.button10);
        OC=findViewById(R.id.button3);
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
        OC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUrlInChrome();
            }
        });

    }
    void openUrlInChrome() {
        try {
            Intent i = new Intent("android.intent.action.MAIN");
            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
            i.addCategory("android.intent.category.LAUNCHER");
            i.setData(Uri.parse("https://www.bajajfinserv.in/health-insurance"));
            startActivity(i);
        }
        catch(ActivityNotFoundException e) {
// Chrome is probably not installed
// OR not selected as default browser OR if no Browser is selected as default browser
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bajajfinserv.in/health-insurance"));
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
    }
}
