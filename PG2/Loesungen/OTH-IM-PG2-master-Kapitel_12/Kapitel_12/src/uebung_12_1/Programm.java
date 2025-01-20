package uebung_12_1;

import java.util.concurrent.atomic.AtomicInteger;

public class Programm {
	public static void variante1() {
		Counter counter = new Counter();
		for (int i = 0; i < 100; i++) {
			new uebung_12_1.variant_1.CounterThread_sync(counter).start();
		}
	}

	public static void variante2() {
		AtomicInteger counter = new AtomicInteger();
		for (int i = 0; i < 100; i++) {
			new uebung_12_1.variant_2.CounterThread_sync(counter).start();
		}
	}

	public static void main(String[] args) {
		variante1();
		// variante2();
	}
}
