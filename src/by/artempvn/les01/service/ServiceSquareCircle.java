package by.artempvn.les01.service;

import by.artempvn.les01.exception.CustomException;
import by.artempvn.les01.validator.CheckValue;

public class ServiceSquareCircle {
	private static final String EXCEPTION_MESSAGE = "Incorrect input";
	private CheckValue checkValue = new CheckValue();

	public double calculateSideBySquare(double square) throws CustomException {
		if (square <= 0) {
			throw new CustomException(EXCEPTION_MESSAGE);
		}
		return (Math.sqrt(square));
	}

	public double calculateSquareByDiagonalCircumcircle(double diagonal)
			throws CustomException {
		if (diagonal <= 0) {
			throw new CustomException(EXCEPTION_MESSAGE);
		}
		return (Math.pow((diagonal / Math.sqrt(2)), 2));
	}

	public double calculateInnerSquareByOuter(double outerSquare)
			throws CustomException {
		double sideOuterSquare = calculateSideBySquare(outerSquare);
		double innerSquare = calculateSquareByDiagonalCircumcircle(
				sideOuterSquare);
		return (innerSquare);
	}

	public double calculateRatioSquare(double outerSquare, double innerSquare)
			throws CustomException {
		CheckValue checkSquare = new CheckValue();
		if (!checkSquare.checkSquare(outerSquare, innerSquare)) {
			throw new CustomException(EXCEPTION_MESSAGE);
		}
		return (outerSquare / innerSquare);
	}

	public double calculateSquareOfCircleByRadius(double radius)
			throws CustomException {
		if (radius <= 0) {
			throw new CustomException(EXCEPTION_MESSAGE);
		}
		return (Math.PI * Math.pow(radius, 2));
	}

	public double calculateLengthOfCircumferenceByRadius(double radius)
			throws CustomException {
		if (radius <= 0) {
			throw new CustomException(EXCEPTION_MESSAGE);
		}
		return (2 * Math.PI * radius);
	}

	public double[] calculateSquareLengthByRadius(double radius)
			throws CustomException {
		double square = calculateSquareOfCircleByRadius(radius);
		double length = calculateLengthOfCircumferenceByRadius(radius);
		double[] squareLength = { square, length };
		return squareLength;
	}

}
