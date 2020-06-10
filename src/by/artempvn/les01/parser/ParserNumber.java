package by.artempvn.les01.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.artempvn.les01.exception.CustomException;
import by.artempvn.les01.validator.CheckType;

public class ParserNumber {
	private static final String PATTERN_INT = "(?<=\\b)\\d+(?=\\b)";
	private static final String PATTERN_LONG = "(?<=\\b)\\d+(?=[Ll]?\\b)";
	private static final String PATTERN_DOUBLE = 
			"(?<=\\b)\\d+[\\.,]?\\d*(?=[Dd]?\\b)";
	private static final String DELIMETER = ".";
	private static final String DELIMITER_INCORRECT = ",";
	private static final String EXCEPTION_MESSAGE = "Incorrect input";

	private CheckType check = new CheckType();

	public String findInt(String input) {
		String parsedString="";
		Pattern patternInt = Pattern.compile(PATTERN_INT);
		Matcher matcherInt = patternInt.matcher(input);
		if (matcherInt.find()) {
			parsedString = input.substring(matcherInt.start(),
					matcherInt.end());
		}
		return parsedString;
	}

	public String findLong(String input) {
		String parsedString="";
		Pattern patternLong = Pattern.compile(PATTERN_LONG);
		Matcher matcherLong = patternLong.matcher(input);
		if (matcherLong.find()) {
			parsedString = input.substring(matcherLong.start(),
					matcherLong.end());
		}
		return parsedString;
	}

	public String findDouble(String input) {
		String parsedString="";
		Pattern patternDouble = Pattern.compile(PATTERN_DOUBLE);
		Matcher matcherDouble = patternDouble.matcher(input);
		if (matcherDouble.find()) {
			parsedString = input.substring(matcherDouble.start(),
					matcherDouble.end());
			if (parsedString.contains(DELIMITER_INCORRECT)) {
				parsedString = parsedString.replace(DELIMITER_INCORRECT,
						DELIMETER);
			}
		}
		return parsedString;
	}

	public int stringToInt(String input) throws CustomException {
		int stringToInt = 0;
		if (check.isInt(input)) {
			stringToInt = Integer.parseInt(input);
		} else {
			throw new CustomException(EXCEPTION_MESSAGE);
		}
		return stringToInt;
	}

	public long stringToLong(String input) throws CustomException {
		long stringToLong = 0;
		if (check.isLong(input)) {
			stringToLong = Long.parseLong(input);
		} else {
			throw new CustomException(EXCEPTION_MESSAGE);
		}
		return stringToLong;
	}

	public double stringToDouble(String input) throws CustomException {
		double stringToDouble = 0;
		if (check.isDouble(input)) {
			stringToDouble = Double.parseDouble(input);
		} else {
			throw new CustomException(EXCEPTION_MESSAGE);
		}
		return stringToDouble;
	}

}
