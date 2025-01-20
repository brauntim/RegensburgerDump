package uebung_12_2.variant_2;

import uebung_12_2.base.ControlConstants;
import uebung_12_2.base.MyItem;
import uebung_12_2.base.StorageBase;
import uebung_12_2.variant_2.SynchronizedStorage;

//This class is the implementation of the storage by using synchronized
public class SynchronizedStorage extends StorageBase implements ControlConstants {

	// Singleton constructor
	private SynchronizedStorage() {

	}

	// Implementation for the Singleton. Returns the Storage object. If not created
	// yet, a new Storage is created and returned.
	public static SynchronizedStorage getInstance() {
		if (storageObject == null) {
			storageObject = new SynchronizedStorage();
		}
		return (SynchronizedStorage) storageObject;
	}

	/*
	 * The method to store an item in the storage. Synchronized in the method
	 * signature shows, that only one object can use it at the same time. As long as
	 * the storage is full, we wait until an other thread calls notify(). After
	 * that, the item is put in the storage and all other threads are told, that
	 * something has changed by calling notifyAll().
	 * 
	 * @see uebung_12_1.base.StorageBase#deliver(uebung_12_1.base.MyItem,
	 * java.lang.String)
	 */
	public synchronized void deliver(MyItem item, String name) {
		try {
			while (storage.size() >= MAX_STORAGE_SIZE) {
				System.out.println("Lager ist voll, bitte warten");
				wait();
			}
			storage.add(item);
			System.out.println(item.toString() + " wurde von " + name + " eingelagert");
			notifyAll();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * The method to get an item from the storage. Synchronized in the method
	 * signature shows, that only one object can use it at the same time. As long as
	 * the storage is empty, we wait until an other thread calls notify(). After
	 * that, the item removed from the storage and all other threads are told, that
	 * something has changed by calling notifyAll().
	 * 
	 * @see uebung_12_1.base.StorageBase#fetch(int, java.lang.String)
	 */
	public synchronized void fetch(int position, String name) {
		try {
			while (storage.size() == 0) {
				System.out.println("Lager ist leer, bitte warten");
				wait();
			}

			MyItem fetchedItem = storage.remove(position);
			System.out.println(fetchedItem.toString() + " wurde von " + name + " abgeholt");
			notifyAll();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// returns the current size of the storage
	public int getStorageCount() {
		return storage.size();
	}

}
