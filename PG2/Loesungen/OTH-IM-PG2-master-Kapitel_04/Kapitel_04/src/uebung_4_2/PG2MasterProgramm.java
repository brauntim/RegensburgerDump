package uebung_4_2;

import java.util.Scanner;

public class PG2MasterProgramm {
	public static String applicationName = "PG2 Master Programm";

	public static void main(String[] args) {
		PasswordManager passwordManager = new PasswordManager();
		Scanner sc = new Scanner(System.in);

		// Endlossschleife
		while (true) {
			System.out.println("--------------------");
			System.out.println("Willkommen beim Passwordmanager. Waehlen Sie ein Funktion aus:");
			System.out.println("   1. Am System anmelden");
			System.out.println("   2. Passwort Aendern");

			int userChoice = sc.nextInt();
			sc.nextLine();

			if (userChoice == 1) { // System login
				System.out.print("Bitte geben Sie das Passwort ein: ");
				String passwordToVerify = sc.nextLine();

				int passwordVerifyStatus = passwordManager.verifyPassword(passwordToVerify);
				if (passwordVerifyStatus < 0) {
					System.out.println("Anmeldung nicht moeglich, zu viele Fehlversuche!");
					break;
				}
				else if (passwordVerifyStatus == 1) {
					System.out.println(
							"Sie haben sich erfolgreich bei der Applikation \"" + applicationName + "\" angemeldet.");
					break;
				}
				else {
					System.out.println(
							"Falsches Passwort. Bisherige Fehlversuche: " + passwordManager.getFailedAttemptsCounter());
				}
			}
			else if (userChoice == 2) { // change password
				System.out.println("Bitte geben Sie alte Passwort ein:");
				String oldPassword = sc.nextLine();
				System.out.println("Bitte geben Sie neue Passwort ein:");
				String newPassword = sc.nextLine();

				boolean successfulChange = passwordManager.changePassword(newPassword, oldPassword);

				if (successfulChange) {
					System.out.println("Passwort wurde erfolgreich geaendert.");
				}
				else {
					System.out.println("Das Passwort konnte nicht geaendert werden.");
				}
			}
			else {
				System.out.println("Invalide Eingabe. Wiederholen.");
			}
		}

		sc.close();
		System.out.println("Vielen Dank, dass sie den Passwordmanager fuer die Authentifizierung verwendet haben.");
	}
}
