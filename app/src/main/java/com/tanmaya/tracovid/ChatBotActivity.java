package com.tanmaya.tracovid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class ChatBotActivity extends AppCompatActivity {
    WebView webView;
   Button NavHome,NavIns,NavDiag;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);
        NavHome=findViewById(R.id.button7);
        NavIns=findViewById(R.id.button11);
        NavDiag=findViewById(R.id.button10);
        webView=findViewById(R.id.webview);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        NavDiag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatBotActivity.this,SymptomLogger.class);
                startActivity(intent);
                finish();
            }
        });
        NavIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatBotActivity.this,InsureActivity.class);
                startActivity(intent);
                finish();
            }
        });
        NavHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatBotActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        webView.loadUrl("https://bot.dialogflow.com/traCOVIDBot");
    }
}