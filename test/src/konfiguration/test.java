package konfiguration;

import awk.AnwendungskernException;
import awk.autostamm.factory.IDogFactory;
import awk.autostamm.factory.impl.DogFactory;
import awk.autostamm.usecases.IDogAnlegen;

public class test {

	public static void main(String[] args) throws AnwendungskernException {
		
		// Relevante Komponenten des AWK's aus der Factory erzeugen
		IDogFactory dogFactoryLocal = new DogFactory();

		// Benötigte Use Cases mittels erzeugter Factory beziehen
		IDogAnlegen dogAnlegenLocal = dogFactoryLocal.exeUCdogsAnlegen();

		
		int chipNr = 1;
		String name = "Jake";
		int alter = 5;
		String farbe = "goldig";
		int cuteness = 10;
		dogAnlegenLocal.snuggleDogAnlegen(chipNr, name, alter, farbe, cuteness);
		
		
		chipNr = 2;
		name = "Lou";
		alter = 4;
		farbe = "schwarz";
		String username = "userDog";
		String password = "userDog123";
		dogAnlegenLocal.guardDogAnlegen(chipNr, name, alter, farbe, username, password);
		
		
		
	}

}
