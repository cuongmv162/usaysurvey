package fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.application.usaysurvey.NavigatorMainActivity;
import com.application.usaysurvey.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends PlaceholderFragment {
    public static final String TAG = AboutFragment.class.getSimpleName();

    private WebView mWebView;

    public AboutFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_this, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        mWebView = (WebView)getView().findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(getResources().getString(R.string.usay_home_page));

    }
}
