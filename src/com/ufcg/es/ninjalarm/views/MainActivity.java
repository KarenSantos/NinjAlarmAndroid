package com.ufcg.es.ninjalarm.views;

import com.ufcg.es.ninjalarm.R;
import com.ufcg.es.ninjalarm.R.id;
import com.ufcg.es.ninjalarm.R.layout;
import com.ufcg.es.ninjalarm.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnMyAlarms = (Button) findViewById(R.id.btnMyAlarms);
		btnMyAlarms.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myAlarmsIntent = new Intent(MainActivity.this, MyAlarmsActivity.class);
				startActivity(myAlarmsIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return false;
	}

}
