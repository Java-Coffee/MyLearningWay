package com.example.learning5;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
private String url = "http://2014.qq.com";
    private WebView webView;
    private Intent intent;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);*/
        webView_init();
    }

    private void webView_init() {
        webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("http://www.baidu.com");
        webView.requestFocus();
        //启用支持javaScript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //加载进度条
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
               // super.onProgressChanged(view, newProgress);
                if(newProgress == 100){
                    closeDialog();
                }
                else {
                    openDialog(newProgress);//网页正在加载，打开progressDialog
                }
            }
        });
        //优先使用缓存
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);   //不使用缓存

     //   webView.setWebViewClient(new WebViewClient());
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
               // return super.shouldOverrideUrlLoading(view, request);
                webView.loadUrl(url);
                return true;
            }
        });
    }

    private void openDialog(int newProgress) {
        if(dialog == null){
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("正在加载。。");
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setProgress(newProgress);
            dialog.show();
        }
        else{
            dialog.setProgress(newProgress);
        }
    }

    private void closeDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }
    //改写物理按键----返回的逻辑

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if (webView.canGoBack()) {
                webView.goBack();//返回上一界面
                return true;
            }
            else {
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
