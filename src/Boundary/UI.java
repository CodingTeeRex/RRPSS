package src.Boundary;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class UI {
	Scanner sc = new Scanner(System.in);

	public int getInput() {
		int userInput = -1;
		boolean handled = false;
		do {
			try {
				userInput = sc.nextInt();
				handled = true;
			} catch (InputMismatchException e) {
				System.out.println("Error! Value must be an Integer! Please try again.");
				sc.next();
			}
		} while (!handled);

		return userInput;
	}

	public String getString() {
		String userInput = "";
		boolean handled = false;
		do {
			try {
				userInput = sc.nextLine();
				handled = true;
			} catch (InputMismatchException e) {
				System.out.println("Error! Input must be a string! Please try again.");
			}
		} while (!handled);

		return userInput;
	}
}