package uebung_3_07;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeFactorization {
	public static void main(String[] args) {
		// user input
		Scanner sc = new Scanner(System.in);
		System.out.print("Geben Sie eine Zahl ein: ");
		long n = sc.nextLong();
		sc.nextLine();
		sc.close();

		// calculate primeFactors
		long[] prime = primeFactors(n);

		// print prime factors
		System.out.print("Die Primfaktorzerlegung von " + n + " ist:");
		// set first number to temp
		long temp = prime[0];
		long exponent = 1;
		for (int i = 1; i < prime.length; i++) {
			if (temp != prime[i]) {
				System.out.print(" " + temp + "^" + exponent + " *");
				temp = prime[i];
				exponent = 1;
			}
			else {
				exponent++;
			}
		}
		System.out.println(" " + temp + "^" + exponent);
	}

	/**
	 * Berechnet die Primfaktoren, aus denen sich die Zahl n zusammensetzt.
	 * Multipliziert man diese, ergibt sich die Zahl. Zurueckgegeben werden die
	 * Zahlen in einem Array, das soviele Elemente hat wie n Primfaktoren. Sie sind
	 * aufsteigend sortiert.
	 */
	public static long[] primeFactors(long n) {
		/*
		 * Die Vorgehensweise ist folgende: Aufgrund der Vorgabe, dass das
		 * zurückgegebene Array maximal soviele Elemente haben darf wie die Zahl n
		 * Primfaktoren hat, erzeugen wir zunaechst ein "temporaeres" Array tmp, dessen
		 * Laenge durch maxFactors angegeben wird. Dies geschieht aus einer Ueberlegung
		 * zum Speicherverbrauch: Man koennte tmp auch mit der Laenge n initialisieren,
		 * allerdings ist dies aus Effizienzgesichtspunkten eher suboptimal, da jede
		 * Zahl maximal eine gewisse Anzahl an Primfaktoren haben kann. Da 2 der
		 * kleinstmoegliche Primfaktor ist, ist die Anzahl der Primfaktoren immer
		 * kleiner gleich dem Exponenten der naechst- hoeheren Zweierpotenz. Daraus
		 * folgt: n <= 2^x log(n) <= log (2^x) x >= log (n) / log(2) Mit x als maximaler
		 * Anzahl der Primfaktoren der Zahl n.
		 */

		// calculate max factors
		int maxFactors = (int) Math.ceil(Math.log10(n) / Math.log10(2));

		// temporary result array
		long[] temp = new long[maxFactors];

		// divider and counter
		int factorCount = 0;
		long divider = 2;

		/*
		 * Jetzt kommt der Trick der Zerlegung: In einer Zaehlschleife wird wiederholt
		 * von 2 (kleinster Primfaktor) bis n (Zahl) gezaehlt, wobei bei jedem Durchlauf
		 * Ueberprueft wird, ob die Zaehlvariable ganzzahliger Teiler der Zahl ist. Ist
		 * dies der Fall, ist ein neuer Primfaktor gefunden. Dieser wird in tmp
		 * gesichert, und der zaehler um eins erniedrigt, da die Zahl nochmals durch
		 * diesen Faktor teilbar sein könnte, nicht aber durch einen frueheren.
		 * Anschliessend wird n durch n/Primfaktor ersetzt.
		 */

		while ((divider * divider) <= n) {
			if (n % divider == 0) {
				temp[factorCount] = divider;
				factorCount++;
				n /= divider;
			}
			else {
				divider++;
			}
		}
		temp[factorCount] = n;
		factorCount++;

		// create new array that fits the real length of prime factors
		long[] primeFactors = new long[factorCount];
		primeFactors = Arrays.copyOf(temp, factorCount);

		return primeFactors;
	}
}