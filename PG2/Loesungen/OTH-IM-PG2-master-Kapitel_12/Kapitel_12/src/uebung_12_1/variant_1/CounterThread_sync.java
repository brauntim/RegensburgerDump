package uebung_12_1.variant_1;

import java.util.concurrent.TimeUnit;

import uebung_12_1.Counter;

public class CounterThread_sync extends Thread {
	private Counter counter;

	public CounterThread_sync(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		while (counter.getCounter() < 1000) {
			synchronized (counter) {
				if (counter.getCounter() == 1000) {
					return;
				}

				counter.increment();
			}
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
