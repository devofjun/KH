package com.kh.webviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtUrl;
    Button btnGo, btnBack;
    WebView webView;
    WebClient client = new WebClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUrl = findViewById(R.id.edtUrl);
        btnGo = findViewById(R.id.btnGo);
        btnBack = findViewById(R.id.btnBack);
        webView = findViewById(R.id.webView);

        webView.setWebViewClient(client);

        btnGo.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnGo){
            String url = edtUrl.getText().toString();
            webView.loadUrl(url);
        } else if(v == btnBack){
            webView.goBack();
        }
    }
    class WebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}