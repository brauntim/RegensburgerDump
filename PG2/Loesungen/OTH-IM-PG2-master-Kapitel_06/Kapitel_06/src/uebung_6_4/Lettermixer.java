package uebung_6_4;

import java.util.Scanner;

public class Lettermixer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte geben Sie ein Wort ein:");
		String myString = sc.nextLine();
		System.out.println("Neues Wort:" + mix(myString));
		sc.close();
	}

	public static String mix(String myString) {
		int last = myString.length();
		int middle = last / 2;

		String s_first = myString.substring(middle, last);
		String s_last = myString.substring(0, middle);

		return s_first + s_last;
	}
}
