package com.example.AndroidTest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends Activity {
	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void onClickThreadButton(View v){
		Intent intent = new Intent(this, ThreadActivity.class);
		startActivity(intent);
	}

	public void onClickAsyncButton(View v){
		Intent intent = new Intent(this, AsyncActivity.class);
		startActivity(intent);
	}

	public void onClickMultiButton(View v){
		Intent intent = new Intent(this, MultiCountActivity.class);
		startActivity(intent);
	}
}
