package com.example.taeyoung.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText edtUrl;
    Button btnGo, btnBack;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUrl = (EditText) findViewById(R.id.edtUrl);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        web = (WebView) findViewById(R.id.webView1);

        web.setWebViewClient(new CookWebViewClient());
        WebSettings webSet = web.getSettings();
        webSet.setBuiltInZoomControls(true);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = edtUrl.getText().toString();
                if ( !temp.substring(0, 7).equals("http://") || !temp.substring(0, 7).equals("HTTP://") ) {
                    temp = "http://" + temp;
                    edtUrl.setText(temp);
                }
                web.loadUrl(edtUrl.getText().toString());
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.goBack();
            }
        });
    }

    class CookWebViewClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            edtUrl.setText(url);
        }
    }

}
