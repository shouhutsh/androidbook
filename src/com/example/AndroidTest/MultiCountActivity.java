package com.example.AndroidTest;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.TextView;

/**
 * Created by Qi_2 on 14-4-12.
 */
public class MultiCountActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.multi_count);

		CountingAsyncTask tsk = new CountingAsyncTask();
		tsk.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, R.id.tv1);

		startCountTask(R.id.tv2);
		startCountTask(R.id.tv3);
		startCountTask(R.id.tv4);
		startCountTask(R.id.tv5);
		startCountTask(R.id.tv6);
	}

	private void startCountTask(int id){
		CountingAsyncTask tsk = new CountingAsyncTask();
		tsk.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, id);
	}

	private class CountingAsyncTask extends AsyncTask<Integer, Integer, Integer>{
		Integer id;
		@Override
		protected Integer doInBackground(Integer... integers) {
			id = integers[0];

			int i = 0;
			while(i < 100){
				SystemClock.sleep(200);
				i += 5;

				publishProgress(i);
			}

			return i;
		}

		protected void onProgressUpdate(Integer... integers){
			TextView tv = (TextView) findViewById(id);
			tv.setText(integers[0] + "% download");
		}

		protected void onPostExecute(Integer... integers){
			TextView tv = (TextView) findViewById(id);
			tv.setText("Complate!");
		}
	}
}