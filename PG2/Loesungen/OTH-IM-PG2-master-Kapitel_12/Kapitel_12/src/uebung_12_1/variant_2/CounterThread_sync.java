package uebung_12_1.variant_2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterThread_sync extends Thread {
	private AtomicInteger counter;

	public CounterThread_sync(AtomicInteger counter) {
		this.counter = counter;
	}

	public void run() {
		while (counter.intValue() < 1000) {
			if (counter.intValue() == 1000) {
				return;
			}

			System.out.println(Thread.currentThread().getName() + " - " + counter.addAndGet(1));
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
