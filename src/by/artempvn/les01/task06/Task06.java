/*
 * 6. Идет n-я секунда суток, определить, сколько полных часов,
 * полных минут и секунд прошло к этому моменту.
 */
package by.artempvn.les01.task06;

import java.util.Scanner;

public class Task06 {
	public static final int SECONDS_IN_DAY = 86400;
	public static final int SECONDS_IN_HOUR = 3600;
	public static final int SECONDS_IN_MINUTE = 60;

	public static int enterSeconds() {
		Scanner sc = new Scanner(System.in);
		int seconds = 0;
		int number = 0;
		boolean check = false;
		do {
			System.out.println("Введите прошедшее число секунд от начала суток");
			if (sc.hasNextInt()) {
				number = sc.nextInt();
				if (number >= 0 && number <= SECONDS_IN_DAY) {
					seconds = number;
					check = true;
				}
			} else {
				sc.nextLine();
			}
		} while (!check);
		return seconds;
	}

	public static void calculateTime(int timeInSeconds) {
		int hours = 0;
		int minutes = 0;
		int seconds = 0;

		hours = timeInSeconds / SECONDS_IN_HOUR;
		minutes = (timeInSeconds - (hours * SECONDS_IN_HOUR)) / SECONDS_IN_MINUTE;
		seconds = timeInSeconds - (hours * SECONDS_IN_HOUR) - (minutes * SECONDS_IN_MINUTE);

		System.out.printf("Прошло %02dч:%02dм:%02dc\n", hours, minutes, seconds);
	}

	public static void run() {
		calculateTime(enterSeconds());
	}
}
