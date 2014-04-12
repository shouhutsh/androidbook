package com.example.AndroidTest;

import android.app.Activity;
import android.os.Bundle;

public class MyActivity extends Activity {
	protected PetDatabaseHelper petDB = null;
	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		petDB = new PetDatabaseHelper(this);
	}

	@Override
	public void onDestroy(){
		super.onDestroy();
		if(petDB != null){
			petDB.close();
		}
	}
}
