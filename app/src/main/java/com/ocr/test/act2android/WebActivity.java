package com.ocr.test.act2android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Web activity launching a web view
 * in order to display the content in HTML
 * @author : Boyman10
 */
public class WebActivity extends AppCompatActivity {

    // Define url to be opened in webview
    private String mUrl = "<html><body>Hello World !</body></html>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        // retrieve data from intent if any :
        mUrl = getIntent().getStringExtra("url");

        WebView webView = (WebView) findViewById(R.id.webView);

        webView.loadData(mUrl,"text/html","utf-8");

        /* Passing URL instead :
        webView.loadUrl(mUrl);

        // Allow clicking on links and opening these links right into the webview :
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });
        */

    }
}
