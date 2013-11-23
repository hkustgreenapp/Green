package com.ust.green;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GreenTip extends Fragment  {
	
	/*public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.loadUrl("file:///android_asset/www/index.html");	
	}	*/
	
	WebView myWebView;
	final static String myBlogAddr = "file:///android_asset/www/tip.html";
	String myUrl;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.layout_webfragment, container, false);
		myWebView = (WebView)view.findViewById(R.id.mywebview);
		
		myWebView.getSettings().setJavaScriptEnabled(true);                
		myWebView.setWebViewClient(new MyWebViewClient());
		
		if(myUrl == null){
			myUrl = myBlogAddr;
		}
		myWebView.loadUrl(myUrl);
	     
        return view;

	}
	
	private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
        	myUrl = url;
            view.loadUrl(url);
            return true;
        }
    }
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setRetainInstance(true);
	}

}


