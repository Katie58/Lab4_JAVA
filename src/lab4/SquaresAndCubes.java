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
		exit();
		scnr.close();
	}
	
	public static void header() {
		System.out.println("Learn your squares and cubes!");
	}
	
	public static void userInput() {
		boolean valid = false;
		
		while (!valid) {
			System.out.print("Enter an integer: ");
			String userInputString = scnr.nextLine();
			if (validate(userInputString)) {
				valid = true;		
			}
		}
		System.out.println();
	}
	
	public static boolean validate(String input) {
		String maxInt = Integer.toString(Integer.MAX_VALUE);
		
		if (input.isEmpty()) {
			System.out.println("Maybe check your numlock and try again...");
			return false;
		}
		
		if (input.charAt(0) == '-') {
			System.out.println("Try to stay POSITIVE and try again...");
			return false;
		}
		
		for (int i = 0; i < input.length(); i++) {
			int x = input.charAt(i);
			if (!(x >= 48 && x <= 57)) {
				System.out.println("An integer is a number, try again...");
				return false;
			}
		}
		
		if (input.length() > String.valueOf(Integer.MAX_VALUE).length()) {
			System.out.println("The max value of an integer = " + Integer.MAX_VALUE + ", try again...");
			return false;
		} else {
			if (input.length() == String.valueOf(Integer.MAX_VALUE).length()) {
				for (int i = 0; i < input.length(); i++) {
					if (input.charAt(i) < maxInt.charAt(i)) {
						break;
					} else if (input.charAt(i) > maxInt.charAt(i)) {
						System.out.println("Close! However, the max value of an integer = " + Integer.MAX_VALUE + ", try again...");
						return false;
					}
				}
			}	
		}
		
		userInputInt = Integer.parseInt(input);
		
		if (userInputInt == 0) {
			System.out.println("Everything is equal to 0 which is too boring to display, try again...");
			return false;
		}
		
		if (userInputInt == (cubed(userInputInt) / userInputInt / userInputInt)) {
			return true;
		} else {
			System.out.println("Yikes! That number is far too large to calculate, try again...");
			return false;
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
		for (int i = 0; i <= userInputInt; i++) {
			System.out.printf("%-15s %-15s %-15s %n", i, squared(i), cubed(i));
		}
	}
	
	public static void multiplicationTable() {
		int padding = 0;
		System.out.println("\nMultiplication Table:");
		for (int i = 1; i <= userInputInt; i++) {
			//System.out.printf("%-11s", i);
			System.out.print(i + repeat(' ', ((String.valueOf(i * userInputInt).length() + 1) - String.valueOf(i).length())));
			padding += (String.valueOf(i * userInputInt).length() + 1);
		}
		System.out.println();
		//System.out.println(repeat('=', 11 * userInputInt));
		System.out.println(repeat('=', padding - 1));
		for (int i = 1; i <= userInputInt; i++) {
			for (int j = 1; j <= userInputInt; j++) {
				//System.out.printf("%-11s", i * j);
				System.out.print((i * j) + repeat(' ', ((String.valueOf(j * userInputInt).length() + 1) - String.valueOf(i * j).length())));
			}
			System.out.println();
			System.out.println(repeat('-', padding - 1));
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
	
	public static void exit() {
		System.out.println("GOODBYE!");
	}
}
