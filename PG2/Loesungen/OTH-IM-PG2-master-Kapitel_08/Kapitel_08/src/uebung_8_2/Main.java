package uebung_8_2;

public class Main {

	public static void main(String[] args) {

		VendingMachine vendingMachine = new VendingMachine();

		while (true) {
			System.out.println("--------------------------------------------------------------------");
			vendingMachine.chooseAndPayBeverage();
			System.out.println("--------------------------------------------------------------------");
			vendingMachine.printStatusReport();
		}
	}
}
