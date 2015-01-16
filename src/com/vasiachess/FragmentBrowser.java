package com.vasiachess;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import java.util.Random;

/**
 * Created by Vasiliy on 11.01.2015.
 */
public class FragmentBrowser extends Fragment {

    private WebView webView;
    private RelativeLayout rlRoot;


    private static final String TAG = "fragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "MyFragment#onCreate");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "MyFragment#onCreateView");

        View view = inflater.inflate(R.layout.fragment2, container, false);
        rlRoot = (RelativeLayout) view.findViewById(R.id.rlRoot);
        webView = (WebView) rlRoot.findViewById(R.id.webView1);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://en.wikipedia.org/wiki/Android");

        return view;
    }

}
