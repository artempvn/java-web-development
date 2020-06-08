package by.artempvn.les01.service;

import by.artempvn.les01.entity.Month;
import by.artempvn.les01.exception.CustomException;
import by.artempvn.les01.validator.CheckValue;

public class ServiceCalendar {
	public static final int LEAP_YEAR_4 = 4;
	public static final int LEAP_YEAR_100 = 100;
	public static final int LEAP_YEAR_400 = 400;
	private static final String EXCEPTION_MESSAGE = "Incorrect input";
	private CheckValue checkMonthYear = new CheckValue();

	public boolean isLeapYear(int year) throws CustomException {
		if (!checkMonthYear.checkYear(year)) {
			throw new CustomException(EXCEPTION_MESSAGE);
		}
		return ((year % LEAP_YEAR_4 == 0 && year % LEAP_YEAR_100 != 0)
				|| year % LEAP_YEAR_400 == 0);
	}

	public int findOutNumberOfDays(int month, int year) 
			throws CustomException {
		if (!checkMonthYear.checkMonth(month)
				|| !checkMonthYear.checkYear(year)) {
			throw new CustomException(EXCEPTION_MESSAGE);
		}
		int numberOfDays;
		Month[] months = Month.values();
		numberOfDays = months[month - 1].getNumberOfDays();
		if (months[month - 1] == Month.FEBRUARY && isLeapYear(year)) {
			numberOfDays++;
		}
		return numberOfDays;
	}

}
