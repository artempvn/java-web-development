package by.artempvn.les01.service;

import by.artempvn.les01.exception.CustomException;

public class ServiceDigit {
	private static final int NUMBER_OF_INT = 4;
	private static final int NUMBER_OF_EVEN = 2;
	private static final int FIRST_PERFECT_NUMBER = 6;
	private static final int PERFECT_NUMBER_COUNTER = 2;
	private static final String EXCEPTION_MESSAGE = "Incorrect input";

	public int findLastDigit(int inputNumber) {
		return (inputNumber % 10);
	}

	public int squareNumber(int inputNumber) {
		return ((int) Math.pow(inputNumber, 2));
	}

	public int findLastDigitOfSquaredLastDigit(int inputNumber) {
		int resultLastDigit;
		int lastDigit = findLastDigit(inputNumber);
		int squaredDigit = squareNumber(lastDigit);
		resultLastDigit = findLastDigit(squaredDigit);
		return resultLastDigit;
	}

	public boolean isEvenNumber(int number) {
		return (number % 2 == 0 && number != 0);
	}

	public boolean isEnoughEvenNumbers(int... someInt) throws CustomException {
		if (someInt.length != NUMBER_OF_INT) {
			throw new CustomException(EXCEPTION_MESSAGE);
		}
		int countEven = 0;
		for (int number : someInt) {
			if (isEvenNumber(number)) {
				countEven++;
			}
		}
		return (countEven >= NUMBER_OF_EVEN);
	}

	public boolean isPerfect(long number) {
		long perfectNumber = FIRST_PERFECT_NUMBER;
		int perfectNumberCounter = PERFECT_NUMBER_COUNTER;
		while (number > perfectNumber) {
			perfectNumber = (long) (Math.pow(perfectNumberCounter, 2)
					* (2 * Math.pow(perfectNumberCounter, 2) - 1));
			perfectNumberCounter++;
		}
		return (number == perfectNumber);
	}

}
