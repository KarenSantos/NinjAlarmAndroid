package com.ufcg.es.ninjalarm.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ufcg.es.ninjalarm.R;

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
		
		Button btnTraining = (Button) findViewById(R.id.btnTraining);
		btnTraining.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent trainingIntent = new Intent(MainActivity.this, TrainingActivity.class);
				startActivity(trainingIntent);				
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
