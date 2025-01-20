package uebung_9_4;

public class VirtualPub {
	int storage;

	public VirtualPub(int storage) {
		this.storage = storage;
	}

	public void serveCustomer(Person customer, Drink drink)
			throws TooColdException, TooHotException, StorageEmptyException {

		if (storage >= 1) {
			// drink has been served
			storage--;
			System.out.println("Neuer Vorrat: " + storage);

			customer.drink(drink);

		}
		else {
			// The storage is empty
			throw new StorageEmptyException("Lager leer!");
		}
	}
}
