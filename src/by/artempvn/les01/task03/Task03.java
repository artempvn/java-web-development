/*
 * 3.	Окружность вписана в квадрат заданной площади. Найти площадь квадрата,
 * вписанного в эту окружность. Во сколько раз площадь вписанного квадрата 
 * меньше площади заданного?
 */
package by.artempvn.les01.task03;

import java.util.Scanner;

public class Task03 {

	public static double enterOuterSquare() {
		Scanner sc = new Scanner(System.in);
		double square = 0;
		double number = 0;
		boolean check = false;

		do {
			System.out.println("Введите площадь квадрата");
			if (sc.hasNextDouble()) {
				number = sc.nextDouble();
				if (number > 0) {
					square = number;
					check = true;
				}
			} else {
				sc.nextLine();
			}
		} while (!check);
		return square;
	}

	public static void calculateInnerSquare(double outerSquare) {
		double innerSquare = 0;
		double outerSide = Math.pow(outerSquare, 0.5);
		double diameter = outerSide;
		double innerSide = diameter / Math.pow(2, 0.5);
		innerSquare = Math.pow(innerSide, 2);
		System.out.printf("Площадь квадрата, вписанного в окружность, вписанную"
				+ " в квадрат с площадью %.2f составляет %.2f, что в %.2f раза"
				+ " меньше площади исходного квадрата",
				outerSquare, innerSquare, (outerSquare/innerSquare));
	}

	public static void run() {
		calculateInnerSquare(enterOuterSquare());
	}
}
