package uebung_9_4;

public class Person {
	public void drink(Drink drink) throws TooColdException, TooHotException {

		if ((drink.getCurrentTemperature() - drink.getPerfektTemperature()) < (-2)) {
			throw new TooColdException("Das Getraenk ist zu kalt!");
		}
		if ((drink.getCurrentTemperature() - drink.getPerfektTemperature()) > (2)) {
			throw new TooHotException("Das Getraenk ist zu heiss!");
		}
	}
}
