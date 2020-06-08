package by.artempvn.les01.entity;

public enum Month {
	JANUARY(31),
	FEBRUARY(28),
	MARCH(31),
	APRIL(30),
	MAY(31),
	JUNE(30),
	JULY(31),
	AUGUST(31), 
	SEPTEMBER(30),
	OCTOBER(31),
	NOVEMBER(30),
	DECEMBER(31);

	private int numberOfDays;
	
	Month(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}
	
}
