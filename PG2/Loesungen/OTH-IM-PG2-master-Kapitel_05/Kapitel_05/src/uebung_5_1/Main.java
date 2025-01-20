package uebung_5_1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car("Audi", "blau", 1500.0, "R-AB-111");
		Trailer trailer = new Trailer("R-CD-123", 80);
		Motorcycle motorcycle = new Motorcycle("R-EF-456", 100);
		Truck truck = new Truck("R-GH-789", 3500);

		System.out.println("Anhaenger vorhanden: " + car.isTrailerAttached());
		car.attachTrailer(trailer);
		System.out.println("Anhaenger vorhanden: " + car.isTrailerAttached());
		System.out.println("Anhaenger beladen: " + car.isTrailerLoaded());
		trailer.attachLoad(motorcycle);
		System.out.println("Anhaenger vorhanden: " + car.isTrailerAttached());
		System.out.println("Anhaenger beladen: " + car.isTrailerLoaded());

		System.out.println("LKW beladen: " + truck.isLoaded());
		truck.loadCar(car);
		System.out.println("LKW beladen: " + truck.isLoaded());
		car.detachTrailer();
		truck.loadCar(car);
		System.out.println("LKW beladen: " + truck.isLoaded());

	}

}
