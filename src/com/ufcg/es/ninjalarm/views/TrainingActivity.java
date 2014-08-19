package com.ufcg.es.ninjalarm.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ufcg.es.ninjalarm.R;
import com.ufcg.es.ninjalarm.util.MovingBallExample;

public class TrainingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_training);
		
		Log.d("NewAlarm", "iniciou training");
		
		Button btnNormal = (Button) findViewById(R.id.btnNormal);
		Log.d("NewAlarm", "criou o botao");
		btnNormal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent trainingIntent = new Intent(TrainingActivity.this,
						MovingBallExample.class);
				Log.d("NewAlarm", "criou intent normal");
				startActivity(trainingIntent);
			}
		});
		
		Button btnHard = (Button) findViewById(R.id.btnHard);
		btnHard.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent trainingIntent = new Intent(TrainingActivity.this,
						MovingBallExample.class);
				startActivity(trainingIntent);
				
			}
		});
		
		Button btnNinja = (Button) findViewById(R.id.btnNinja);
		btnNinja.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent trainingIntent = new Intent(TrainingActivity.this,
						MovingBallExample.class);
				startActivity(trainingIntent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.training, menu);

		/*Button btnTraining = (Button) findViewById(R.id.btnNormal);
		btnTraining.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent trainingIntent = new Intent(TrainingActivity.this,
						MovingBallExample.class);
				startActivity(trainingIntent);
				
			}
		});*/

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
