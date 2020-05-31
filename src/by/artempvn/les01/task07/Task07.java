/*
 * 7. Даны две точки А(х1, у1) и В(х2, у2). Составить алгоритм, 
 * определяющий, которая из точек находится ближе к началу координат. x y.
 */
package by.artempvn.les01.task07;

import java.util.Scanner;

public class Task07 {
	static final double EPSILON = 1E-14;

	public static double calculateLength(double x, double y) {
		double length = 0;
		length = Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5);
		return length;
	}

	public static double enterDouble(String s) {
		Scanner sc = new Scanner(System.in);
		double coordinate = 0;
		boolean check = false;
		do {
			System.out.println("Введите координату " + s);
			if (sc.hasNextDouble()) {
				coordinate = sc.nextDouble();
				check = true;
			} else {
				sc.nextLine();
			}
		} while (!check);
		return coordinate;
	}

	public static void run() {
		double x1;
		double y1;
		double x2;
		double y2;
		double lengthA;
		double lengthB;
		
		System.out.println("Введите координаты точки А");
		x1 = enterDouble("x1");
		y1 = enterDouble("y1");
		lengthA = calculateLength(x1, y1);
		System.out.println("Введите координаты точки B");
		x2 = enterDouble("x2");
		y2 = enterDouble("y2");
		lengthB = calculateLength(x2, y2);
		
		if (Math.abs(lengthA - lengthB) < EPSILON) {
			System.out.println("Точки находятся на одинаковом удалении от начала координат");
		} else {
			String closiestPoint;
			closiestPoint = (lengthA > lengthB) ? "A" : "B";
			System.out.println("Точка " + closiestPoint + " находится ближе к началу координат");
		}

	}

}
