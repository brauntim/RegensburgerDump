package uebung_8_1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

		// Adding vehicles
		vehicles.add(new Car("NM-TG 790", true, Color.RED, 150, 4, 5));
		vehicles.add(new Car("NM-AA 80", true, Color.RED, 150, 4, 5));
		vehicles.add(new Car("NM-FF 70", false, Color.BLACK, 95, 2, 5));
		vehicles.add(new Car("R-FF 90", false, Color.BLUE, 100, 4, 4));
		vehicles.add(new Truck("R-AA 99", false, Color.GREEN, 200, 6, 1500));
		vehicles.add(new Truck("R-BB 11", false, Color.YELLOW, 400, 6, 3000));

		// print all
		for (Vehicle vehicle : vehicles) {
			// automatic call of toString() of each vehicle
			System.out.println(vehicle);
		}

		// check if a similar car is in the list by calling equals() on every element
		Car testCar = new Car("NM-FF 70", false, Color.BLACK, 95, 2, 5);
		boolean testCarFound = false;
		for (Vehicle vehicle : vehicles) {
			if (testCar.equals(vehicle)) {
				System.out.println("Gleichen PKW gefunden");
				testCarFound = true;
				break;
			}
		}
		if (!testCarFound) {
			System.out.println("Gleichen PKW nicht gefunden");
		}

		// check if a similar truck is in the list by calling contains(), that calls
		// equals() internal
		Truck testTruck = new Truck("R-AA 99", false, Color.GREEN, 200, 6, 1500);
		if (vehicles.contains(testTruck)) {
			System.out.println("Gleichen LKW gefunden");
		}
		else {
			System.out.println("Gleichen LKW nicht gefunden");
		}
	}
}
