package com.example.lab5;

import android.content.Intent;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    WebView webView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        webView = findViewById(R.id.webview);
        intent = getIntent();
        String link = intent.getStringExtra("openlink");
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
    }
}
