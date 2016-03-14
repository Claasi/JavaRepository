package awk.autostamm.usecases;

import awk.AnwendungskernException;

public interface IDogAnlegen {
	
	public boolean guardDogAnlegen(int chipNr, String name, int alter, String farbe, String username, String password) throws AnwendungskernException;
	public boolean snuggleDogAnlegen(int chipNr, String name, int alter, String farbe, int cuteness) throws AnwendungskernException;
	

}
