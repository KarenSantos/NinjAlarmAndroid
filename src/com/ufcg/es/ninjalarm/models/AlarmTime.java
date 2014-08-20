package com.ufcg.es.ninjalarm.models;

import java.util.Calendar;

/**
 * Alarm time class.
 * 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 * 
 */
public class AlarmTime {

	private final int MAX_HOUR = 23;
	private final int MAX_MINUTE = 59;
	private final int MINIMUM = 0;
	private final int HOUR = 60;
	private int hour;
	private int minute;

	/**
	 * Creates a new alarm time with the current hour and the current minute.
	 */
	public AlarmTime() {
		this.hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		this.minute = Calendar.getInstance().get(Calendar.MINUTE);
	}

	/**
	 * Creates a new alarm time with an hour and a minute.
	 * 
	 * @param hour
	 *            The hour for the time.
	 * @param minute
	 *            The minute for the time.
	 * @throws InvalidNumberException
	 *             If the hour is less than 0 or more than 23, if the minute is
	 *             less than 0 or more than 59.
	 */
	public AlarmTime(int hour, int minute) throws InvalidNumberException {
		setHour(hour);
		setMinute(minute);
	}

	/**
	 * Returns the hour of the alarm time.
	 * 
	 * @return The hour of the alarm time.
	 */
	public int getHour() {
		return this.hour;
	}

	/**
	 * Sets the hour of the alarm time.
	 * 
	 * @param hour
	 *            The new hour of the alarm time.
	 * @throws InvalidNumberException
	 *             If the hour is less than 0 or more than 23.
	 */
	public void setHour(int hour) throws InvalidNumberException {
		if (hour < MINIMUM || hour > MAX_HOUR) {
			throw new InvalidNumberException("The hour must be from 0 to 23");
		}
		this.hour = hour;
	}

	/**
	 * Returns the alarm time minute.
	 * 
	 * @return The alarm time minute.
	 */
	public int getMinute() {
		return this.minute;
	}

	/**
	 * Sets the alarm time minute.
	 * 
	 * @param minute
	 *            The new minute for the alarm time.
	 * @throws InvalidNumberException
	 *             If the minute is less than 0 or more than 59.
	 */
	public void setMinute(int minute) throws InvalidNumberException {
		if (minute < MINIMUM || minute > MAX_MINUTE) {
			throw new InvalidNumberException("The minute must be from 0 to 59");
		}
		this.minute = minute;
	}

	/**
	 * Returns if the time is a past time
	 * 
	 * @return true if the time is a
	 */
	public boolean isPastTime() {
		boolean isPastTime = false;
		if (hour < Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
			isPastTime = true;
		} else if (hour == Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
			if (minute <= Calendar.getInstance().get(Calendar.MINUTE)) {
				isPastTime = true;
			}
		}
		return isPastTime;
	}

	/**
	 * Returns the total amount minutes of the alarm time
	 * 
	 * @return the total amount of minutes of the alarm time
	 */
	public int changeToMinutes() {
		return hour * HOUR + minute;
	}

	/**
	 * Adds an extra time in minutes to the alarm time.
	 * 
	 * @param extra
	 *            The extra time in minutes.
	 */
	public void addTime(int extra) {
		int totalMin = this.minute + extra;
		if (totalMin > MAX_MINUTE) {
			this.hour = getHour() + 1;
			this.minute = getMinute() + (totalMin - MAX_MINUTE);
		}
	}
	
	@Override
	public String toString() {
		return getHour() + ":" + getMinute();
	}
}
