package com.ufcg.es.ninjalarm.util;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.ufcg.es.ninjalarm.R;
import com.ufcg.es.ninjalarm.models.Alarm;
import com.ufcg.es.ninjalarm.models.AlarmByDate;

public class AlarmArrayAdapter extends ArrayAdapter<Alarm> {

	List<Alarm> alarms = new ArrayList<Alarm>();

	public AlarmArrayAdapter(Context context, int textViewResourceId, List<Alarm> objects) {
		super(context, textViewResourceId, objects);
		this.alarms = objects;
	}

	@Override
	public long getItemId(int position) {
		return alarms.get(position).getId();
	}
	
	@Override
	public Alarm getItem(int position) {
		return alarms.get(position);
	}
	
	@Override
	public int getCount() {
		return alarms.size();
	}
	
	@Override
	public int getPosition(Alarm item) {
		for (int i = 0; i < alarms.size(); i++) {
			if (alarms.get(i).equals(item))
				return i;
		}
		return super.getPosition(item);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Alarm currentAlarm = getItem(position);
		
		LayoutInflater inflater = LayoutInflater.from(getContext());
		convertView = inflater.inflate(R.layout.alarm_view_list_item, null);

		TextView txtName = (TextView) convertView.findViewById(R.id.txtAlarmName);
		txtName.setText(currentAlarm.getName());
		
		TextView txtHour = (TextView) convertView.findViewById(R.id.txtAlarmHour);
		txtHour.setText(currentAlarm.getTime().toString());
		
		TextView txtDays = (TextView) convertView.findViewById(R.id.txtAlarmDays);
		if (currentAlarm instanceof AlarmByDate){
			txtDays.setText("");
		}
		
		
		final ToggleButton button = (ToggleButton) convertView.findViewById(R.id.btnAlarmPower);
		button.setChecked(currentAlarm.getPower());
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				currentAlarm.setPower(!currentAlarm.getPower());
				button.setChecked(currentAlarm.getPower());
			}
		});
		
		
		return convertView;
	}
	
}
