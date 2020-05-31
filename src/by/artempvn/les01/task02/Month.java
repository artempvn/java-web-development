package by.artempvn.les01.task02;

public enum Month {
	JANUARY(31,"январь"),
	FEBRUARY_28(28,"февраль"),
	FEBRUARY_29(29,"февраль"),
	MARCH(31,"март"),
	APRIL(30,"апрель"),
	MAY(31,"май"),
	JUNE(30,"июнь"),
	JULY(31,"июль"),
	AUGUST(31,"август"), 
	SEPTEMBER(30,"сентябрь"),
	OCTOBER(31,"октябрь"),
	NOVEMBER(30,"ноябрь"),
	DECEMBER(31,"декабрь");

	private int numberOfDays;
	private String month;
	
	Month(int numberOfDays, String month) {
		this.numberOfDays = numberOfDays;
		this.month = month;
	}
	public void print() {
		System.out.println("месяц: "+month+", количество дней: "+numberOfDays);
	}
}
