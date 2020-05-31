/*
 * 2. Составить программу, которая по заданным году и номеру месяца 
 * определяет количество дней в этом месяце и корректно определялись 
 * все високосные года.
 */

package by.artempvn.les01.task02;

import java.util.Scanner;

public class Task02 {
	public static final int LEAP_YEAR_4 = 4;
	public static final int LEAP_YEAR_100 = 100;
	public static final int LEAP_YEAR_400 = 400;

	public static int enterMonth() {
		Scanner sc = new Scanner(System.in);
		int month = 0;
		boolean check = false;
		do {
			int number = 0;
			System.out.println("Введите номер месяца");
			if (sc.hasNextInt()) {
				number = sc.nextInt();
				if (number > 0 && number < 13) {
					month = number;
					check = true;
				}
			} else {
				sc.nextLine();
			}
		} while (!check);
		return month;
	}

	public static int enterYear() {
		Scanner sc = new Scanner(System.in);
		int year = 0;
		boolean check = false;
		do {
			System.out.println("Введите год");
			if (sc.hasNextInt()) {
				year = sc.nextInt();
				check = true;
			} else {
				sc.nextLine();
			}
		} while (!check);
		return year;
	}

	public static boolean isLeapYear(int year) {
		boolean isLeapYear = false;

		if ((year % LEAP_YEAR_4 == 0 && year % LEAP_YEAR_100 != 0) || year % LEAP_YEAR_400 == 0) {
			isLeapYear = true;
		}
		return isLeapYear;
	}

	public static void checkMonth(int month, int year) {
		Month currentMonth = null;
		Month[] months = Month.values();
		switch (month) {
		case 1:
			currentMonth = months[0];
			break;
		case 2:
			if (isLeapYear(year)) {
				currentMonth = months[2];
			} else {
				currentMonth = months[1];
			}
			break;
		default:
			currentMonth = months[month];
			break;
		}
		currentMonth.print();
	}

	public static void run() {
		int month = enterMonth();
		int year = enterYear();
		checkMonth(month, year);

	}

}
