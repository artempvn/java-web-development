package by.artempvn.les01.validator;

import java.util.Scanner;

public class CheckType {
	private Scanner scanner;
	private static final String DELIMITER = "\\.";

	public boolean isInt(String input) {
		boolean isInt = false;
		if (input != null) {
			scanner = new Scanner(input);
			isInt = scanner.hasNextInt();
		}
		return (isInt);
	}

	public boolean isLong(String input) {
		boolean isLong = false;
		if (input != null) {
			scanner = new Scanner(input);
			isLong = scanner.hasNextLong();
		}
		return (isLong);
	}

	public boolean isDouble(String input) {
		boolean isDouble = false;
		if (input != null) {
			scanner = new Scanner(input);
			scanner.useDelimiter(DELIMITER);
			isDouble = scanner.hasNextDouble();
		}
		return (isDouble);
	}

}
