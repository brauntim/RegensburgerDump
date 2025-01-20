package uebung_12_3;

public class Main {

	public static void main(String[] args) {
		int maxExponent = 4253;

		int currentExponent = 3;

		// Creating an array with the size of the available processors
		PrimeTest primeTests[] = new PrimeTest[Runtime.getRuntime().availableProcessors()];

		// If one of our threads has done its job, it dies. So if the thread is not
		// alive anymore, we can create a new one with a new number to test.
		// We do this as long we have reached the max exponent.
		while (true) {
			for (int i = 0; i < primeTests.length; i++) {
				if ((primeTests[i] == null || !primeTests[i].isAlive()) && currentExponent <= maxExponent) {
					primeTests[i] = new PrimeTest(currentExponent);
					primeTests[i].start();
					currentExponent++;
				}
			}

			// If the maximum exponent is reached, we want to break the while-loop.
			if (currentExponent > maxExponent) {
				System.out.println("reached");
				break;
			}
		}

		// wait for all running threads before we end the program. Otherwise the
		// main-thread would end before the calculation threads. Not necessary but nice.
		try {
			for (int i = 0; i < primeTests.length; i++) {
				if (primeTests[i] != null) {
					primeTests[i].join();
				}
			}
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
