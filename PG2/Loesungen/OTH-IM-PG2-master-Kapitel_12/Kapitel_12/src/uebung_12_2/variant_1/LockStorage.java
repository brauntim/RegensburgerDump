package uebung_12_2.variant_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import uebung_12_2.base.ControlConstants;
import uebung_12_2.base.MyItem;
import uebung_12_2.base.StorageBase;

//This class is the implementation of the storage by using locks
public class LockStorage extends StorageBase implements ControlConstants {

	// The lock and two conditions that are needed for the storage
	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();

	// Singleton constructor
	private LockStorage() {

	}

	// Implementation for the Singleton. Returns the Storage object. If not created
	// yet, a new Storage is created and returned.
	public static LockStorage getInstance() {
		if (storageObject == null) {
			storageObject = new LockStorage();
		}
		return (LockStorage) storageObject;
	}

	/*
	 * The method to store an item in the storage. First the lock gets locked, so no
	 * other object can use the method. As long as the storage is full, we wait for
	 * the signal to the condition notFull. After that, the item is put in the
	 * storage and all other threads are told, that now at least one item is in the
	 * storage.
	 * 
	 * @see uebung_12_1.base.StorageBase#deliver(uebung_12_1.base.MyItem,
	 * java.lang.String)
	 */
	public void deliver(MyItem item, String name) {
		lock.lock();
		try {
			while (storage.size() >= MAX_STORAGE_SIZE) {
				System.out.println("Lager ist voll, bitte warten");
				notFull.await();
			}
			storage.add(item);
			System.out.println(item.toString() + " wurde von " + name + " eingelagert");
			notEmpty.signalAll();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}

	}

	/*
	 * The method to get an item from the storage. First the lock gets locked, so no
	 * other object can use the method. As long as the storage is empty, we wait for
	 * the signal to the condition notEmpty. After that, the item is removed from
	 * the storage and all other threads are told, that now at least one item can be
	 * stored in the storage.
	 * 
	 * @see uebung_12_1.base.StorageBase#fetch(int, java.lang.String)
	 */
	public void fetch(int position, String name) {
		lock.lock();
		try {
			while (storage.size() == 0) {
				System.out.println("Lager ist leer, bitte warten");
				notEmpty.await();
			}

			MyItem fetchedItem = storage.remove(position);
			System.out.println(fetchedItem.toString() + " wurde von " + name + " abgeholt");
			notFull.signalAll();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}

	// returns the current size of the storage
	public int getStorageCount() {
		return storage.size();
	}

}
