package com.example.AndroidTest;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.TextView;

/**
 * Created by Qi_2 on 14-4-12.
 */
public class AsyncActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.count);

		CountAsyncTask count = new CountAsyncTask();
		count.execute(new Integer(50));
	}

	private class CountAsyncTask extends AsyncTask<Integer, Integer, Integer>{

		@Override
		protected Integer doInBackground(Integer... integers) {
			int i = 0;
			while(i < integers[0]){
				SystemClock.sleep(500);
				i += 5;

				publishProgress(i);
			}
			return i;
		}

		protected void onProgressUpdate(Integer... integer){
			TextView tv = (TextView) findViewById(R.id.text);
			tv.setText(integer[0] + "% download");
		}

		protected void onPostExecute(Integer result) {
			TextView tv = (TextView) findViewById(R.id.text);
			tv.setText("Complete!");
		}
	}
}