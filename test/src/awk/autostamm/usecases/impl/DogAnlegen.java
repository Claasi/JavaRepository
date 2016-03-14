package awk.autostamm.usecases.impl;

import awk.AnwendungskernException;
import awk.autostamm.entity.impl.GuardDog;
import awk.autostamm.entity.impl.SnuggleDog;
import awk.autostamm.usecases.IDogAnlegen;

public class DogAnlegen implements IDogAnlegen{
	
	public DogAnlegen(){}
//	public boolean datenPruefen(){}
//	Test auf syntaktische Korrektheit
	
	public boolean guardDogAnlegen(int chipNr, String name, int alter, String farbe, String username, String password) throws AnwendungskernException{
		
		DogManager dogManagement = DogManager.getDogManagement();
		
		dogManagement.dogZurCollectionAdden(new GuardDog(chipNr, name, alter, farbe, username, password));
//		System.out.println("Chip-Nr.:\t" + chipNr +	"\nName:\t\t" + name + "\nAlter:\t\t" + alter +	"\nFarbe:\t\t" + farbe);
//		dogManagement.dogsAusgeben();
		System.out.println("'" + name + "'" + " wurde zur Liste hinzugefügt!\n");
		
//		dogManagement.dogsAusDateiLaden();
		
		return true;
	}
	
	public boolean snuggleDogAnlegen(int chipNr, String name, int alter, String farbe, int cuteness) throws AnwendungskernException{
		
		DogManager dogManagement = DogManager.getDogManagement();
		
		dogManagement.dogZurCollectionAdden(new SnuggleDog(chipNr, name, alter, farbe, cuteness));
		System.out.println("Chip-Nr.:\t" + chipNr +	"\nName:\t\t" + name + "\nAlter:\t\t" + alter +	"\nFarbe:\t\t" + farbe + "\nNiedlich-Skala:\t" + cuteness);

		System.out.println("'" + name + "'" + " wurde zur Liste hinzugefügt!\n");
//		dogManagement.dogsAusDateiLaden();
		
		return true;
	}
	
	
	
//	public boolean dogLoeschen (int chipNr) throws AnwendungskernException {
//		DogManager dogManagement = DogManager.getDogManagement();
//		Dog einDog = DogManager.dogSuchenByChipNr(chipNr);
//		if (einDog == null)
//			return false;
//		else {
//			dogManagement.dogEntfernen(einDog);
//			return true;
//		}
//	}

}
