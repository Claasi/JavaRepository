package awk.autostamm.factory.impl;

import awk.autostamm.factory.IDogFactory;
import awk.autostamm.usecases.IDogAnlegen;
import awk.autostamm.usecases.impl.DogAnlegen;

public class DogFactory implements IDogFactory{

	public IDogAnlegen exeUCdogsAnlegen() {
//		das hier ist der ganze "Zauber", Use Cases wurden �ber Interfaces entkoppelt,
//		die DogFactory gibt den Use Case als Ergebnis-Aufruf zur�ck,
//		folglich wird der Use Case "DogAnlegen" ausgef�hrt
		return new DogAnlegen();
	}

}
