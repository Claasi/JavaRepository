package awk.autostamm.factory.impl;

import awk.autostamm.factory.IDogFactory;
import awk.autostamm.usecases.IDogAnlegen;
import awk.autostamm.usecases.impl.DogAnlegen;

public class DogFactory implements IDogFactory{

	public IDogAnlegen exeUCdogsAnlegen() {
//		das hier ist der ganze "Zauber", Use Cases wurden über Interfaces entkoppelt,
//		die DogFactory gibt den Use Case als Ergebnis-Aufruf zurück,
//		folglich wird der Use Case "DogAnlegen" ausgeführt
		return new DogAnlegen();
	}

}
