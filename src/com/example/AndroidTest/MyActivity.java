package com.example.AndroidTest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {
	private MyResponseReceiver receiver;
	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		IntentFilter filter = new IntentFilter(MyResponseReceiver.ACTION_RESP);
		filter.addCategory(Intent.CATEGORY_DEFAULT);
		receiver = new MyResponseReceiver();
		registerReceiver(receiver, filter);
	}

	@Override
	public void onDestroy(){
		this.unregisterReceiver(receiver);
		super.onDestroy();
	}

	public void onMainUIThread(View v){
		EditText et = (EditText) findViewById(R.id.edit);
		TextView tv = (TextView) findViewById(R.id.show);

		SystemClock.sleep(1500);

		tv.setText(et.getText());
	}

	public void onIntentService(View v){
		EditText et = (EditText) findViewById(R.id.edit);

		Intent intent = new Intent(this, SimpleIntentService.class);
		intent.putExtra(SimpleIntentService.IN, et.getText().toString());
		startService(intent);
	}

	public class MyResponseReceiver extends BroadcastReceiver{
		public final static String ACTION_RESP = "com.mamlambo.intent.action.MESSAGE_PROCESSED";
		@Override
		public void onReceive(Context context, Intent intent) {
			TextView show = (TextView) findViewById(R.id.show);
			show.setText(intent.getStringExtra(SimpleIntentService.OUT));
		}
	}
}
