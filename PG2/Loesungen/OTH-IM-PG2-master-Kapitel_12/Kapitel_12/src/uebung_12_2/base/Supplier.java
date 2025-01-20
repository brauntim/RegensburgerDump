package uebung_12_2.base;

import java.util.Random;
import java.util.concurrent.TimeUnit;

//This class represents a Supplier
public class Supplier implements Runnable, ControlConstants {
	StorageBase storage;
	String name;

	public Supplier(StorageBase storage, String name) {
		this.storage = storage;
		this.name = name;
	}

	/*
	 * In each iteration a random number is calculated. This is the id for the new
	 * Item. When the action was successful, a random time + the constant is waited
	 * for the next run.
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			while (true) {
				Random random = new Random();
				MyItem item = new MyItem(random.nextInt(4000000), "An Item");
				this.storage.deliver(item, this.name);
				TimeUnit.MILLISECONDS.sleep(random.nextInt(2000) + 1 + MIN_DELIVER_TIME);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
