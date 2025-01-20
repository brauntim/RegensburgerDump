package uebung_12_2.base;

import java.util.concurrent.TimeUnit;
//This class represents a Collector.

public class Collector implements Runnable, ControlConstants {
	StorageBase storage;
	String name;

	public Collector(StorageBase storage, String name) {
		this.storage = storage;
		this.name = name;
	}

	/*
	 * In each iteration a random number is calculated. This is the position from
	 * where the item from the storage is taken. When the action was successful, a
	 * random time + the constant is waited for the next run.
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			while (true) {
				int min = 0;
				int max = this.storage.getStorageCount() - 1;
				int randomInteger = min + (int) (Math.random() * ((max - min) + 1));

				this.storage.fetch(randomInteger, this.name);
				max = 2000;
				randomInteger = min + (int) (Math.random() * ((max - min) + 1));
				TimeUnit.MILLISECONDS.sleep(randomInteger + MIN_FETCH_TIME);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
