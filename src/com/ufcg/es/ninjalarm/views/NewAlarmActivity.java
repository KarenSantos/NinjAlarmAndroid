package com.ufcg.es.ninjalarm.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import com.ufcg.es.ninjalarm.R;
import com.ufcg.es.ninjalarm.controllers.Controller;
import com.ufcg.es.ninjalarm.models.Alarm;
import com.ufcg.es.ninjalarm.models.AlarmByDate;
import com.ufcg.es.ninjalarm.models.AlarmDate;
import com.ufcg.es.ninjalarm.models.AlarmTime;
import com.ufcg.es.ninjalarm.models.AlarmType;
import com.ufcg.es.ninjalarm.models.Difficulty;
import com.ufcg.es.ninjalarm.models.InvalidNumberException;
import com.ufcg.es.ninjalarm.models.MyAlarms;
import com.ufcg.es.ninjalarm.models.StopButton;

public class NewAlarmActivity extends Activity {

	private TimePicker alarmTimePicker;
	private DatePicker alarmDatePicker;
	private SeekBar volumeBar;
	private EditText alarmNameText;
	private boolean datePickerVisible;
	private boolean isAlarmByDate;

	private Alarm alarm;
	private AlarmTime alarmTime;
	private AlarmType alarmType;
	private AlarmDate alarmDate;
	private StopButton stopButton;
	private String alarmName;

	private Controller controller = Controller.getController();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_alarm);
		// Show the Up button in the action bar.
		setupActionBar();
		Log.d("NewAlarm", "iniciou");

		datePickerVisible = false;
		isAlarmByDate = true;

		alarmDate = new AlarmDate();
		alarmTime = new AlarmTime();
		try {
			alarmTime.setHour(alarmTime.getHour() + 1);
		} catch (InvalidNumberException e) {
			try {
				alarmTime.setHour(0);
				// TODO colocar data pra amanha
			} catch (InvalidNumberException e1) {
			}
		}

		alarmTimePicker = (TimePicker) findViewById(R.id.timePickerNewAlarm);
		alarmTimePicker.setCurrentHour(alarmTime.getHour());
		alarmTimePicker.setCurrentMinute(alarmTime.getMinute());

		alarmType = AlarmType.MELODY_VIBRATION;

		// TODO setar melodia default

		stopButton = new StopButton();
		alarmName = "Alarm" + controller.getTagForName();

		final LinearLayout dateOrWeekday = (LinearLayout) findViewById(R.id.dateOrWeekday);

		TextView txtByDate = (TextView) findViewById(R.id.txtByDate);
		txtByDate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dateOrWeekday.setVisibility(View.GONE);

				datePickerVisible = true;
				alarmDatePicker = (DatePicker) findViewById(R.id.datePickerNewAlarm);
				alarmDatePicker.setVisibility(View.VISIBLE);

			}
		});

		// TODO datePicker onPressed

		TextView txtByWeekdays = (TextView) findViewById(R.id.txtAlarmByWeekday);
		txtByWeekdays.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dateOrWeekday.setVisibility(View.GONE);

				alarmDatePicker = (DatePicker) findViewById(R.id.datePickerNewAlarm);
				alarmDatePicker.setVisibility(View.VISIBLE);
				isAlarmByDate = false;
			}
		});

		LinearLayout alarmTypeArea = (LinearLayout) findViewById(R.id.alarmTypeArea);
		alarmTypeArea.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				final CharSequence types[] = new CharSequence[] { "Melody",
						"Melody & Vibration", "Vibration" };

				AlertDialog.Builder alertAlarmType = new AlertDialog.Builder(
						NewAlarmActivity.this);
				alertAlarmType.setTitle("Alarm Type");
				alertAlarmType.setItems(types,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int type) {
								if (type == 0) {
									alarmType = AlarmType.MELODY;
								} else if (type == 1) {
									alarmType = AlarmType.MELODY_VIBRATION;
								} else {
									alarmType = AlarmType.VIBRATION;
								}
								Log.d("NewAlarm", "alarmType = " + alarmType);
							}
						});

				alertAlarmType.show();
			}
		});

		volumeBar = (SeekBar) findViewById(R.id.volumeSeekBar);
		volumeBar.setMax(Alarm.MAX_VOLUME);

		LinearLayout alarmMelodyArea = (LinearLayout) findViewById(R.id.alarmMelodyArea);
		alarmMelodyArea.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		LinearLayout stopButtonArea = (LinearLayout) findViewById(R.id.alarmStopButtonArea);
		stopButtonArea.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				final CharSequence types[] = new CharSequence[] { "Normal",
						"Hard", "Ninja" };

				AlertDialog.Builder alertStopButton = new AlertDialog.Builder(
						NewAlarmActivity.this);
				alertStopButton.setTitle("Stop Button Level");
				alertStopButton.setItems(types,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int level) {
								if (level == 0) {
									stopButton.setLevel(Difficulty.Normal);
								} else if (level == 1) {
									stopButton.setLevel(Difficulty.Hard);
								} else {
									stopButton.setLevel(Difficulty.Ninja);
								}
								Log.d("NewAlarm",
										"stopButton = " + stopButton.getLevel());
							}
						});

				alertStopButton.show();
			}
		});

		TextView alarmSnoozeConfig = (TextView) findViewById(R.id.txtSnooze);
		alarmSnoozeConfig.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		//TODO limitar area de nome
		alarmNameText = (EditText) findViewById(R.id.txtFieldAlarmName);
		alarmNameText.setText(alarmName);

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
		getMenuInflater().inflate(R.menu.new_alarm, menu);
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

		case R.id.saveNewAlarmIcon:
			if (isAlarmByDate) {
				configAlarmByDate();
			}
			controller.addAlarm(alarm);
			Log.d("NewAlarm", "numAlarms = " + controller.getAlarms().size());

			/*
			 * Intent goAlarm = new Intent(this, MyAlarmsActivity.class);
			 * goAlarm.putExtra(alarm.getName(), alarm.toString());
			 * startActivityForResult(goAlarm, MyAlarmsActivity.getPick());
			 */
			// ///////////////////////////////////

		case R.id.cancelNewAlarmIcon:
			Intent intentMyAlarms = new Intent(this, MyAlarmsActivity.class);
			startActivity(intentMyAlarms);
		}
		return super.onOptionsItemSelected(item);
	}

	private void configAlarmByDate() {
		alarm = new AlarmByDate();

		try {
			alarmTime.setHour(alarmTimePicker.getCurrentHour());
			alarmTime.setMinute(alarmTimePicker.getCurrentMinute());
		} catch (InvalidNumberException e) {
			showAlertMessage(e.getMessage());
		}
		alarm.setTime(alarmTime);

		if (datePickerVisible) {
			try {
				alarmDate.setDay(alarmDatePicker.getDayOfMonth());
				alarmDate.setMonth(alarmDatePicker.getMonth());
				alarmDate.setYear(alarmDatePicker.getYear());
			} catch (Exception e) {
				showAlertMessage(e.getMessage());
			}
		}
		((AlarmByDate) alarm).setDate(alarmDate);

		alarm.setType(alarmType);

		try {
			alarm.setVolume(volumeBar.getProgress());
		} catch (InvalidNumberException e) {
			showAlertMessage(e.getMessage());
		}

		// TODO set alarm melody

		alarm.setStopButton(stopButton);

		// TODO set snooze time and power

		if (!alarmNameText.getText().equals(alarmName)) {
			controller.incrementTagForName();
		}
		alarm.setName(alarmName);
	}

	private void showAlertMessage(String message) {

		AlertDialog.Builder alertMessage = new AlertDialog.Builder(
				NewAlarmActivity.this);
		alertMessage.setMessage(message);
		alertMessage.show();

	}

}
