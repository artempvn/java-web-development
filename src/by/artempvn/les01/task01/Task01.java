/*
 * 1. Написать программу, позволяющую по последней цифре числа 
 * определить последнюю цифру его квадрата.
 */

package by.artempvn.les01.task01;

import java.util.Scanner;

public class Task01 {

	public static int findLastDigit(int number) {
		int lastDigit = 0;

		lastDigit = number % 10;
		return lastDigit;
	}

	public static int square(int number) {
		int squaredNumber = 0;

		squaredNumber = (int) (Math.pow(number, 2));
		return squaredNumber;
	}

	public static void run() {
		int number = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Введите число");
		while (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println("Введите число");
		}
		number = sc.nextInt();
		System.out.printf("Последней цифрой квадрата числа %d является %d. \n", number,
				findLastDigit(square(findLastDigit(number))));

	}
}
