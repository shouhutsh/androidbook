package com.example.AndroidTest;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.TextView;

/**
 * Created by Qi_2 on 14-4-12.
 */
public class ThreadActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.count);

		final TextView tv = (TextView) findViewById(R.id.text);

		new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while(i < 100){
					SystemClock.sleep(100);
					i += 5;

					final int j = i;
					tv.post(new Runnable() {
						@Override
						public void run() {
							tv.setText(j+"% download");
						}
					});
				}

				tv.post(new Runnable() {
					@Override
					public void run() {
						tv.setText("Complete!");
					}
				});
			}
		}).start();
	}
}