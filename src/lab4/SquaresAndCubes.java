package lab4;
import java.util.Scanner;

public class SquaresAndCubes {
	static Scanner scnr = new Scanner(System.in);
	static int userInputInt;

	public static void main(String[] args) {
		boolean retry = true;
		
		header();
		while (retry) {
			userInput();
			print();
			multiplicationTable();
			
			retry = retry();
		}

		scnr.close();
	}
	
	public static void header() {
		System.out.println("Learn your squares and cubes!");
	}
	
	public static void userInput() {
		boolean valid = false;
		
		while (!valid) {
			System.out.print("Enter an integer: ");
			if (scnr.hasNextInt()) {
				userInputInt = scnr.nextInt();		
				valid = true;
			} else {
				System.out.println("ENTRY INVALID");
			}
			scnr.nextLine();
		}
	}
	
	public static int squared(int number) {
		return (number * number);
	}
	
	public static int cubed(int number) {
		return (number * number * number);
	}
	
	public static void print() {
		System.out.printf("%-15s %-15s %-15s %n", "Number", "Squared", "Cubed");
		System.out.printf("%-15s %-15s %-15s %n", repeat('=', 7), repeat('=', 7), repeat('=', 7));
		for (int i = 0; i < userInputInt; i++) {
			System.out.printf("%-15s %-15s %-15s %n", i, squared(i), cubed(i));
		}
	}
	
	public static void multiplicationTable() {
		System.out.println("\nMultiplication Table:");
		for (int i = 1; i <= userInputInt; i++) {
			System.out.printf("%-5s", i);
		}
		System.out.println();
		System.out.println(repeat('=', 5 * userInputInt));
		for (int i = 1; i <= userInputInt; i++) {
			for (int j = 1; j <= userInputInt; j++) {
				System.out.printf("%-5s", i * j);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static String repeat(char character, int multi) {
		String repeat = Character.toString(character);
		for (int i = 1; i < multi; i++) {
			repeat += character;
		}
		return repeat;
	}
	
	public static boolean retry() {
		char cont = ' ';
		System.out.print("Continue? (y/n) ");
		cont = scnr.next().charAt(0);
		scnr.nextLine();
		
		while(cont != 'y' && cont != 'Y' && cont != 'n' && cont != 'N') {
		System.out.println("What was that?... type 'y' to continue or 'n' to exit");
		cont = scnr.nextLine().charAt(0);
		}		
		if (cont == 'y' || cont == 'Y') {
			return true;
		}
		else {
			return false;
		}
	}
}
