package uebung_12_2.variant_2;

import uebung_12_2.base.Collector;
import uebung_12_2.base.Supplier;
import uebung_12_2.variant_2.SynchronizedStorage;

//This class contains the main-method and starts all threads.
public class SynchronizedStorageCompany {

	public static void main(String[] args) {
		SynchronizedStorage storage = SynchronizedStorage.getInstance();
		Thread s1, s2, s3;
		Thread c1, c2, c3;

		s1 = new Thread(new Supplier(storage, "Donnerblitz Transformatoren"));
		s2 = new Thread(new Supplier(storage, "Haudi Pferdezubehör"));
		s3 = new Thread(new Supplier(storage, "Lufthaken Fertigung"));

		c1 = new Thread(new Collector(storage, "Spedition schnell wie nix"));
		c2 = new Thread(new Collector(storage, "Brennholzverleih"));
		c3 = new Thread(new Collector(storage, "Nimm 2 Zahl 3"));

		s1.start();
		s2.start();
		s3.start();

		c1.start();
		c2.start();
		c3.start();
	}

}
