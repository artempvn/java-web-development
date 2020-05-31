/*
 * 8. Вычислить значение функции:
 *       {-(x^2)+3x+9, если x>=3;
 * F(x)= 
 *       {1/((x^3)-6), если x<3;
 */
package by.artempvn.les01.task08;

import java.util.Scanner;

public class Task08 {

	public static int enterX() {
		Scanner sc = new Scanner(System.in);
		int x = 0;
		boolean check = false;

		do {
			System.out.println("Введите x");
			if (sc.hasNextInt()) {
				x = sc.nextInt();
				check = true;
			} else {
				sc.nextLine();
			}
		} while (!check);
		return x;
	}

	public static void calculateFunction(int x) {
		double f = 0;

		if (x >= 3) {
			f = -(Math.pow(x, 2)) + 3 * x + 9;
		} else {
			f = 1 / (Math.pow(x, 3) - 6);
		}
		System.out.printf("F(%d)=%.3f\n", x, f);
	}

	public static void run() {
		calculateFunction(enterX());
	}

}
