package com.example.AndroidTest;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by Qi_2 on 14-4-12.
 */
public class SimpleIntentService extends IntentService {
	final static String IN = "inmsg";
	final static String OUT= "outmsg";

	public SimpleIntentService() {
		super("SimpleIntentService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		String msg = intent.getStringExtra(IN);

		Intent boardcast = new Intent();
		boardcast.setAction(MyActivity.MyResponseReceiver.ACTION_RESP);
		boardcast.addCategory(Intent.CATEGORY_DEFAULT);
		boardcast.putExtra(OUT, msg + "--from IntentService");
		sendBroadcast(boardcast);
	}
}
