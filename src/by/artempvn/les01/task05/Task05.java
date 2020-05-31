/*
 * 5. Составить программу, печатающую значение true, если указанное 
 * высказывание является истинным, и false — в противном случае: 
 * является ли целое число совершенным (сумма делителей равна самому числу).
 */
package by.artempvn.les01.task05;

import java.util.Scanner;

public class Task05 {

	public static int enterNumber() {
		Scanner sc = new Scanner(System.in);
		int number = 0;
		boolean check = false;
		do {
			System.out.println("Введите целое число ");
			if (sc.hasNextInt()) {
				number = sc.nextInt();
				check = true;
			} else {
				sc.nextLine();
			}
		} while (!check);
		return number;
	}

	public static void isPerfect(int number) {
		int sum = 0;
		boolean isPerfect = false;
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				sum += i;
			}
		}
		if (number == sum && number > 0) {
			isPerfect = true;
		}
		System.out.println(isPerfect);
	}

	public static void run() {
		isPerfect(enterNumber());
	}

}
