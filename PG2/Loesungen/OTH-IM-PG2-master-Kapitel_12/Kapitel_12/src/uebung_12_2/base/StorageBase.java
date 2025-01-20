package uebung_12_2.base;

import java.util.ArrayList;
import java.util.List;

//Base class for both of the storage variants. Contains an attribute for the storage object because of the singleton implementation
public abstract class StorageBase {

	protected static StorageBase storageObject = null;
	protected List<MyItem> storage = new ArrayList<>();

	public abstract void deliver(MyItem item, String name);

	public abstract void fetch(int randomInteger, String name);

	public abstract int getStorageCount();
}
