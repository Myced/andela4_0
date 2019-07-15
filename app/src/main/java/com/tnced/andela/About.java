package com.tnced.andela;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        setTitle(R.string.About_ALC);

        String urll = "https://andela.com/alc/";

        final WebView mWebView = findViewById(R.id.webview);

        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient() {


            /**
             * Notify the host application that an SSL error occurred while loading a
             * resource. The host application must call either handler.cancel() or
             * handler.proceed(). Note that the decision may be retained for use in
             * response to future SSL errors. The default behavior is to cancel the
             * load.
             *
             * @param view    The WebView that is initiating the callback.
             * @param handler An SslErrorHandler object that will handle the user's
             *                response.
             * @param error   The SSL error object.
             */
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                Toast.makeText(About.this, "SSL certificate Issue", Toast.LENGTH_SHORT).show();
                handler.proceed();
            }
        });

        mWebView.loadUrl(urll);
    }
}
