package com.ufcg.es.ninjalarm.util;

import java.util.HashMap;
import java.util.List;

import com.ufcg.es.ninjalarm.models.Alarm;

import android.content.Context;
import android.widget.ArrayAdapter;

public class AlarmArrayAdapter extends ArrayAdapter<Alarm> {

	HashMap<Alarm, Integer> alarmsMap = new HashMap<Alarm, Integer>();

	public AlarmArrayAdapter(Context context, int textViewResourceId, List<Alarm> objects) {
		super(context, textViewResourceId, objects);
		for (int i = 0; i < objects.size(); ++i) {
			alarmsMap.put(objects.get(i), i);
		}
	}

	@Override
	public long getItemId(int position) {
		Alarm item = getItem(position);
		return alarmsMap.get(item);
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}
}
