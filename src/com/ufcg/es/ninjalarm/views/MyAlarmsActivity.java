package com.ufcg.es.ninjalarm.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ufcg.es.ninjalarm.R;
import com.ufcg.es.ninjalarm.R.id;
import com.ufcg.es.ninjalarm.R.layout;
import com.ufcg.es.ninjalarm.R.menu;
import com.ufcg.es.ninjalarm.controllers.Controller;
import com.ufcg.es.ninjalarm.models.Alarm;
import com.ufcg.es.ninjalarm.util.AlarmArrayAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class MyAlarmsActivity extends Activity {

	Controller controller = Controller.getController();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_alarms);
		// Show the Up button in the action bar.
		setupActionBar();

		final ListView listview = (ListView) findViewById(R.id.listAlarms);

		final List<Alarm> list = new ArrayList<Alarm>();
		for (int i = 0; i < controller.getAlarms().size(); i++) {
			list.add(controller.getAlarms().get(i));
		}
		final AlarmArrayAdapter adapter = new AlarmArrayAdapter(this,
				android.R.layout.simple_list_item_1, list);
		listview.setAdapter(adapter);
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_alarms, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.newAlarmIcon:
			Intent intentNewAlarm = new Intent(this, NewAlarmActivity.class);
			startActivity(intentNewAlarm);
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

}
