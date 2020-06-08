package by.artempvn.les01.console;

public class ConsoleOutput {
	private static final String TASK_1 = 
			"Last digit of squared last digit is ";
	private static final String TASK_2 = "Number of days in month is ";
	private static final String TASK_3_1 = "Square of inner square is ";
	private static final String TASK_3_2 = 
			"Ratio of outer square to inner square is ";
	private static final String TASK_4 = 
			"There are two or more even numbers: ";
	private static final String TASK_5 = "Number is perfect: ";
	private static final String TASK_6 = "Time: ";
	private static final String TASK_7_1 = "First point is closer to origin";
	private static final String TASK_7_2 = "Second point is closer to origin";
	private static final String TASK_7_3 =
			"Points are located at the same distance to origin";
	private static final String TASK_8 = "F(x)= ";
	private static final String TASK_9_1 = "Square: ";
	private static final String TASK_9_2 = "Length: ";

	public void printLastDigitOfSquaredLastDigit(int lastDigit) {
		System.out.println(TASK_1 + lastDigit);
	}

	public void printNumberOfDays(int numberOfDays) {
		System.out.println(TASK_2 + numberOfDays);
	}

	public void printInnerSquareByOuter(double innerSquare) {
		System.out.printf("%s %.3f%n", TASK_3_1, innerSquare);
	}

	public void printRatioSquare(double ratioSquare) {
		System.out.printf("%s %.3f%n", TASK_3_2, ratioSquare);
	}

	public void printIsEnoughEvenNumbers(boolean isEnoughEvenNumbers) {
		System.out.println(TASK_4 + isEnoughEvenNumbers);
	}

	public void printIsPerfectNumbers(boolean isPerfectNumbers) {
		System.out.println(TASK_5 + isPerfectNumbers);
	}

	public void printTimeInHms(int[] time) {
		System.out.printf("%s %02dh:%02dm:%02ds%n", TASK_6, time[0], time[1],
				time[2]);
	}

	public void printDistanceToOrigin(int compareDistance) {
		switch (compareDistance) {
		case -1:
			System.out.println(TASK_7_1);
			break;
		case 1:
			System.out.println(TASK_7_2);
			break;
		case 0:
			System.out.println(TASK_7_3);
			break;
		default:
			System.out.println("Incorrect input");
			break;
		}
	}

	public void printFunctionTask8(double fX) {
		System.out.printf("%s%.3f%n", TASK_8, fX);
	}

	public void printSquareLengthByRadius(double[] squareLength) {
		System.out.printf("%s%.3f %s%.3f %n", TASK_9_1, squareLength[0],
				TASK_9_2, squareLength[1]);
	}

	public void printFunctionTask10Interval(double[][] functionArgResult) {
		for (int i = 0; i < functionArgResult.length; i++) {
			System.out.printf("%.3f\t%.3f%n", functionArgResult[i][0],
					functionArgResult[i][1]);

		}
	}

}
