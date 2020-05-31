/*
 * 9.Вычислить длину окружности и площадь круга одного и того же заданного радиуса R.
 */
package by.artempvn.les01.task09;

import java.util.Scanner;

public class Task09 {

	public static int enterRadius() {
		Scanner sc = new Scanner(System.in);
		int radius = 0;
		boolean check = false;

		do {
			System.out.println("Введите радиус");
			if (sc.hasNextInt()) {
				radius = sc.nextInt();
				if (radius > 0) {
					check = true;
				}
			} else {
				sc.nextLine();
			}
		} while (!check);
		return radius;
	}

	public static void calculateLength(int radius) {
		double length;

		length = 2 * Math.PI * radius;
		System.out.printf("Длина окружности равна %.3f\n", length);
	}

	public static void calculateSquare(int radius) {
		double square;

		square = Math.PI * Math.pow(radius, 2);
		System.out.printf("Площадь круга равна %.3f\n", square);
	}

	public static void run() {
		int radius;

		radius = enterRadius();
		calculateLength(radius);
		calculateSquare(radius);
	}

}
