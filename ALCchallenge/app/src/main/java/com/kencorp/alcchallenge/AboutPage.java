package com.kencorp.alcchallenge;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.webkit.WebView;
/**
 * Created by kenneth Ze Ondoua Kona
 */

public class AboutPage extends AppCompatActivity {

    private String url = "https://andela.com/alc/";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings();
        webView.getSettings().setUseWideViewPort(true);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR2) {
            webView.getSettings().setJavaScriptEnabled(true);
        }

        webView.setWebViewClient(new MyAppWebViewClient(){
        });

        if ((ContextCompat.checkSelfPermission(this, android.Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) ) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.INTERNET)) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.INTERNET}, 1);

            }else {

                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.INTERNET}, 1);
            }
            webView.loadUrl(url);
        }else{
            webView.loadUrl(url);
        }
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}
