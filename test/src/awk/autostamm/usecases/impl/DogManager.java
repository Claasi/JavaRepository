package awk.autostamm.usecases.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.autostamm.entity.DogTO;
import awk.autostamm.entity.impl.Dog;
import awk.autostamm.persistence.datenzugriff.DogDatenzugriff_Datei;

public class DogManager {
	
	public DogDatenzugriff_Datei daoDatei = new DogDatenzugriff_Datei();
	public Collection<Dog> dogs = new ArrayList<Dog>();
	
	private static DogManager dogManagement;
	
	public static DogManager getDogManagement(){
		if(dogManagement == null){
			dogManagement = new DogManager();
		}
		return dogManagement;
	}
	
	public void dogZurCollectionAdden(Dog einDog) throws AnwendungskernException{
		// einen Dog (Snuggle/Guard) zur Collection hinzufügen
		this.dogs.add(einDog);
		// lokale Methode, um Collection in DB oder Datei zu speichern; TO's verwenden!
		this.dogsInDateiSpeichern();
	}
	
	public void dogsInDateiSpeichern() throws AnwendungskernException{
		Collection<DogTO> dogTOListe = new ArrayList<DogTO>();
		
		for(Dog einDog : this.dogs)
			dogTOListe.add(einDog.toDogTO());
		
		try{
			daoDatei.saveDogData(dogTOListe);
		} catch (DatenhaltungsException e) {
			throw new AnwendungskernException();
		}
	}
	
	public void dogsAusDateiLaden() throws AnwendungskernException{
		Collection<DogTO> dogTOListe;
		
		try {
			dogTOListe = daoDatei.readDogData();
		} catch (DatenhaltungsException e) {
			throw new AnwendungskernException();
		}
		this.dogs.clear();
		for (DogTO einDogTO : dogTOListe)
			this.dogs.add(einDogTO.toDog());
	}
	
//	public void dogsAusgeben(){
//		for (Dog einDog : this.dogs)
//			System.out.println("Chip-Nr.:\t" + einDog.getChipNr() +
//								"\nName:\t\t" + einDog.getName() +
//								"\nAlter:\t\t" + einDog.getDogInfos().getAlter() +
//								"\nFarbe:\t\t" + einDog.getDogInfos().getFarbe() + "\n");
//	}

	
	
	
	
}
