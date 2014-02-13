package com.canerce.userprofil;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class About extends Activity {

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

		Button btnBack = (Button) findViewById(R.id.btnBack);
        EditText etAddress = (EditText) findViewById(R.id.etAddress); 
		WebView wvTwitter = (WebView) findViewById(R.id.wvTwitter);
		wvTwitter.getSettings().setJavaScriptEnabled(true);
		wvTwitter.setWebViewClient(new WebViewClient() {
		    @Override
		    public boolean shouldOverrideUrlLoading(WebView view, String url) {
		    return true;
		    }
		});
		wvTwitter.loadUrl(etAddress.getText().toString());
		btnBack.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				finish();
			}
		});
	}
	
}
