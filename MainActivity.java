package miapp.com;
 
import android.net.Uri;
import android.os.Bundle;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.annotation.*;
import android.app.*;
import android.os.*;
import android.webkit.*;

import androidx.annotation.RequiresApi;

public class MainActivity extends Activity {

    public static final int REQUEST_CODE_LOLIPOP = 1;
    private final static int RESULT_CODE_ICE_CREAM = 2;
    private WebView webView;
    private ValueCallback<Uri[]> mFilePathCallback;
    private String mCameraPhotoPath;
    private ValueCallback<Uri> mUploadMessage;

    private String url ="https://www.aqui_mi_url.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView = (WebView) findViewById(R.id.webview);
        setUpWebViewDefaults(webView);
        webView.loadUrl(url);



    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setUpWebViewDefaults(WebView webView) {
        WebSettings settings = webView.getSettings();
        // Enable Javascript
        settings.setJavaScriptEnabled(true);
        // Use WideViewport and Zoom out if there is no viewport defined
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        // Enable pinch to zoom without the zoom buttons
        settings.setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            // Hide the zoom controls for HONEYCOMB+
            settings.setDisplayZoomControls(false);
        }
        // Enable remote debugging via chrome://inspect
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        // We set the WebViewClient to ensure links are consumed by the WebView rather
        // than passed to a browser if it can
        webView.setWebViewClient(new WebViewClient());
    }


    @Override
    public void onBackPressed() {

        if (webView.canGoBack())


        {
            webView.goBack();
        }else
        {
            super.onBackPressed();
        }




    }

}
