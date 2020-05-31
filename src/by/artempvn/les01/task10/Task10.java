/*
 * 10.	Составить программу для вычисления значений функции F(x) на отрезке
 * [а, b] с шагом h. Результат представить в виде таблицы, первый столбец 
 * которой – значения аргумента, второй - соответствующие значения функции.
 * F(x)=tg(x);
 */
package by.artempvn.les01.task10;

import java.util.Scanner;

public class Task10 {

	public static int[] enterInt() {
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		int[] values = new int[3];
		String[] s = { "a", "b", "h" };
		
		for (int i = 0; i < 3; i++) {
			check = false;
			do {
				System.out.println("Введите значение " + s[i]);
				if (sc.hasNextInt()) {
					values[i] = sc.nextInt();
					switch (i) {
					case 0:
						check = true;
						break;
					case 1:
						if (values[1] > values[0]) {
							check = true;
						}
						break;
					case 2:
						if (values[2] <= values[1] - values[0] && values[2] > 0) {
							check = true;
							break;
						}
					}
				} else {
					sc.nextLine();
				}
			} while (!check);
		}
		return values;
	}

	public static double calculateFunction(int x) {
		double f;
		f = Math.tan(x);
		return f;
	}

	public static void run() {
		int a;
		int b;
		int h;
		int[] values;

		values = enterInt();
		a = values[0];
		b = values[1];
		h = values[2];
		
		System.out.printf("%-5s %-5s\n", "x", "F(x)");
		for (int x = a; x < b; x += h) {
			System.out.printf("%-5d %+-5.3f\n", x, calculateFunction(x));
		}
		System.out.printf("%-5d %+-5.3f\n", b, calculateFunction(b));
	}

}
