package uebung_12_1;

public class Counter {
	private int count;

	public Counter() {
		count = 0;
	}

	public void increment() {
		count++;
		System.out.println(Thread.currentThread().getName() + " - " + this.count);
	}

	public int getCounter() {
		return this.count;
	}
}
