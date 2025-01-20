package uebung_6_1;

import java.util.Scanner;

public class MainProgram {

	private FieldObject[][] field;
	private Hamster peter;
	private static final int WIDTH = 10;
	private static final int HEIGHT = 10;

	public static void main(String[] args) {
		MainProgram mainProgram = new MainProgram();
	}

	public MainProgram() {
		Scanner sc = new Scanner(System.in);

		initField();

		int choice = 0;
		do {
			printField();
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				// turn left
				peter.left();
				break;

			case 2:
				// turn right
				peter.right();
				break;

			case 3:
				// move forward
				peter.goForward(field);
				break;

			case 4:
				// print eaten corns
				System.out.println(peter.getName() + " hat bereits " + peter.getCornAmount() + " Koerner gefressen");
				break;

			case 5:
				// exit
				break;

			default:
				System.out.println("Falsche Eingabe");
			}
		}
		while (choice != 5);

		sc.close();
	}

	public void initField() {
		field = new FieldObject[WIDTH][HEIGHT];
		peter = new Hamster('>', "Peter", 3, 2);

		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				field[i][j] = new EmptyField(' ');
			}
		}

		for (int i = 0; i < WIDTH; i++) {
			field[0][i] = new Wall('#');
			field[field.length - 1][i] = new Wall('#');
		}

		for (int i = 0; i < field.length; i++) {
			field[i][0] = new Wall('#');
			field[i][field[i].length - 1] = new Wall('#');
		}

		field[4][4] = new Wall('#');
		field[4][5] = new Wall('#');
		field[8][5] = new Wall('#');
		field[7][5] = new Wall('#');
		field[5][7] = new Corn('*');
		field[5][3] = new Corn('*');
		field[peter.getY()][peter.getX()] = peter;
	}

	public void printField() {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				System.out.print(field[i][j].getSymbol());
			}
			System.out.println();
		}

		System.out.println("Waelen Sie eine Funktion aus:");
		System.out.println("1) Links drehen:");
		System.out.println("2) Rechts drehen:");
		System.out.println("3) Vorwaerts gehen:");
		System.out.println("4) Anzahl gefressener Koerner ausgeben:");
		System.out.println("5) Programm beenden:");
	}
}
