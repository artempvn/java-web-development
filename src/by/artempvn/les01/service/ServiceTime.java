package by.artempvn.les01.service;

import by.artempvn.les01.exception.CustomException;
import by.artempvn.les01.validator.CheckValue;

public class ServiceTime {
	private static final String EXCEPTION_MESSAGE = "Incorrect input";
	private static final int SECONDS_IN_MINUTE = 60;
	private static final int SECONDS_IN_HOUR = 3600;

	private CheckValue checkValue = new CheckValue();

	public int[] convertSecondsToHms(int timeInSeconds) 
			throws CustomException {
		if (!checkValue.checkTimeSeconds(timeInSeconds)) {
			throw new CustomException(EXCEPTION_MESSAGE);
		}
		int hours;
		int minutes;
		int seconds;
		hours = timeInSeconds / SECONDS_IN_HOUR;
		minutes = (timeInSeconds - (hours * SECONDS_IN_HOUR))
				/ SECONDS_IN_MINUTE;
		seconds = timeInSeconds - (hours * SECONDS_IN_HOUR)
				- (minutes * SECONDS_IN_MINUTE);
		int[] time = { hours, minutes, seconds };
		return (time);
	}

}
