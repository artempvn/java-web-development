package by.artempvn.les01.validator;

public class CheckValue {
	private static final int YEAR_CALENDAR_REFORM = 1582;
	private static final int YEAR_SOME_FUTURE = 3500;
	private static final int SECONDS_IN_DAY = 86400;

	public boolean checkMonth(int month) {
		return (month >= 1 && month <= 12);
	}

	public boolean checkYear(int year) {
		return (year >= YEAR_CALENDAR_REFORM && year <= YEAR_SOME_FUTURE);
	}

	public boolean checkSquare(double outerSquare, double innerSquare) {
		return (outerSquare > innerSquare && outerSquare != 0
				&& innerSquare != 0);
	}

	public boolean checkTimeSeconds(int seconds) {
		return (seconds >= 0 && seconds <= SECONDS_IN_DAY);
	}

	public boolean checkInterval(double start, double end, double step) {
		return (end > start && step < end - start);
	}

}
