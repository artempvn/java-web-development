/*
 * 4. Составить программу, печатающую значение true, если указанное
 *  высказывание является истинным, и false — в противном случае: среди 
 *  заданных целых чисел А, В, С, D есть хотя бы два четных.
 */
package by.artempvn.les01.task04;

import java.util.Scanner;

public class Task04 {

	public static boolean isEvenNumber(int number) {
		boolean isEven = false;
		isEven = (number % 2 == 0 && number != 0) ? true : false;
		return isEven;
	}

	public static int[] enterNumbers() {
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[4];
		boolean check = false;
		for (int i = 0, j = 65; i < 4; i++, j++) {
			do {
				System.out.println("Введите целое число " + (char) j + " ");
				if (sc.hasNextInt()) {
					numbers[i] = sc.nextInt();
					check = true;
				} else {
					sc.nextLine();
				}
			} while (!check);
		}
		return numbers;
	}

	public static void checkEven(int... numbers) {
		boolean checkEven = false;
		int count = 0;
		for (int number : numbers) {
			if (isEvenNumber(number)) {
				count++;
			}
		}
		if (count >= 2) {
			checkEven = true;
		}
		System.out.println(checkEven);
	}
	
	public static void run() {
		checkEven(enterNumbers());
	}
}
