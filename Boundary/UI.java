package Boundary;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class UI {

	public int getInput() {
		Scanner sc = new Scanner(System.in);
		int userInput = -1;
		boolean handled = false;
		do {
			try {
				userInput = sc.nextInt();
				handled = true;
			} catch (InputMismatchException e) {
				System.out.println("Error! Option must be an Integer! Please try again.");
				sc.next();
			}
		} while (!handled);

		return userInput;
	}
}