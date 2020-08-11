package chapter01;

import java.util.Scanner;

public class Case07LoopStrcuture {

	public static void main(String[] args) {
		// while:
		int age = 1;
		while (age < 100) {
			System.out.println("Money!Money!Money!");
			age++;
		}
		
		int x = 0;
		while (x < 10) {
			if (x == 5) {
				break;
			}
			System.out.println(x);
			x++;
		}
		
		// do...while...
		Scanner scanner = new Scanner(System.in);
		int pwd;
		do {
			System.out.print("passwrod:");
			pwd = scanner.nextInt();
		} while (123456 != pwd);
		scanner.close();
		
		// for:
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}
	}

}
