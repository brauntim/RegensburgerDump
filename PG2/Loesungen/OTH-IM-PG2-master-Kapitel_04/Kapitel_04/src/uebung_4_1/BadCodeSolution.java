package uebung_4_1;

//import java.util.Scanner		/*Fehlender Strichpunkt*/
//
//public class BadCode {
//	int start = 1;
//
//	public static void main(int[] args) {		/*String[] args statt int*/
//		if (args != null) {
//			start = args[0]		/*Fehlender Strichpunkt; int wuerde String zugewiesen werden*/
//		}
//		System.out.println("Die Ürsprungszahl ist: " + start);		/*start hier unbekannt; fehlendes static*/
//		Scanner sc = new Scanner(System.in);
//		double d1 = add(start, sc.nextInt());		/*start hier unbekannt; fehlendes static;*/
//		double d2 = sub(start, sc.nextFloat());		/*start hier unbekannt; fehlendes static*; Methode kann nicht aufgerufen werden, da Methode nicht static; float statt int uebergeben*/
//		test(20);
//	}
//
//	public static void add(int start, int add) {		/*falscher Rueckgabetyp*/
//		return (start + add);
//	}
//
//	public double sub(int start, int sub) {
//		return (start - sub);
//	}
//
//	public static void test(int start) {
//		if (start > 10) {
//			int value = 5;
//		}
//		else {
//			int value = -5;
//		}
//		System.out.println(value);  /*value hier unbekannt*/
//	}
//}
