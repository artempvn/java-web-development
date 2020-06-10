package by.artempvn.les01.service;

import by.artempvn.les01.exception.CustomException;
import by.artempvn.les01.validator.CheckValue;
import static java.lang.Math.*;

public class ServiceFunction {
	private static final String EXCEPTION_MESSAGE = "Incorrect input";

	public double calculateFunctionTask8_1(double x) {
		return (-(pow(x, 2)) + 3 * x + 9);
	}

	public double calculateFunctionTask8_2(double x) {
		return (1 / (pow(x, 3) - 6));
	}

	public double calculateFunctionTask8(double x) {
		double fX;
		fX = (x >= 3) ? calculateFunctionTask8_1(x)
				: calculateFunctionTask8_2(x);
		return fX;
	}

	public double calculateFunctionTask10(double x) {
		return (tan(x));
	}

	public double[][] calculateFunctionTask10Interval(double start, double end,
			double step) throws CustomException {
		CheckValue checkInterval = new CheckValue();
		if (!checkInterval.checkInterval(start, end, step)) {
			throw new CustomException(EXCEPTION_MESSAGE);
		}
		int numberOfSteps = ((int) ((end - start) / step) + 1);
		if ((end - start) % step != 0) {
			numberOfSteps++;
		}
		double[][] functionArgResult = new double[numberOfSteps][2];
		int numberOfStep = 0;
		for (double x = start; x < end; x += step) {
			functionArgResult[numberOfStep][0] = x;
			functionArgResult[numberOfStep][1] = calculateFunctionTask10(x);
			numberOfStep++;
		}
		functionArgResult[numberOfStep][0] = end;
		functionArgResult[numberOfStep][1] = calculateFunctionTask10(end);
		return (functionArgResult);
	}

}
