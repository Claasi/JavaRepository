package awk.autostamm.persistence.datenzugriff;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import awk.DatenhaltungsException;
import awk.autostamm.entity.DogTO;
import awk.autostamm.entity.GuardDogTO;
import awk.autostamm.entity.SnuggleDogTO;
import awk.autostamm.entity.impl.GuardDog;
import awk.autostamm.entity.impl.SnuggleDog;
import awk.autostamm.persistence.IDogDatenzugriff;

public class DogDatenzugriff_Datei implements IDogDatenzugriff{

	
	public void saveDogData(Collection<DogTO> dogDaten) throws DatenhaltungsException {
		ObjectOutputStream dogData = null;
		try {
			dogData = new ObjectOutputStream (new FileOutputStream ("C:\\Users\\Claas\\Desktop\\Java\\Dateien\\dogData.txt"));
		} catch (FileNotFoundException e) {
			throw new DatenhaltungsException();
		} catch (IOException e) {
			throw new DatenhaltungsException();
		}
		
		try {
			for (DogTO einDogTO : dogDaten)
				dogData.writeObject(einDogTO);
			} catch (IOException e1) {
					throw new DatenhaltungsException();	
				}
			
		try {
			dogData.close();
		} catch (IOException e) {
			throw new DatenhaltungsException();
		}
		
	}


	public Collection<DogTO> readDogData() throws DatenhaltungsException {
		Collection<DogTO> dogDaten = new ArrayList<DogTO>();
		ObjectInputStream dogData = null;
		
//		Scanner scan = null;
		DogTO einDogTO;
		
		try {
			dogData = new ObjectInputStream(new FileInputStream("C:\\Users\\Claas\\Desktop\\Java\\Dateien\\dogData.txt"));
//			scan = new Scanner(dogData);
		} catch (FileNotFoundException e1) {
			System.out.println("Datei nicht gefunden!");
//			throw new DatenhaltungsException();
			return dogDaten;
		} catch (IOException e1) {
			throw new DatenhaltungsException();
		}
		
		Object transportObjekt;
		try {
			while (true) {
				transportObjekt = dogData.readObject();
				
				if (transportObjekt instanceof GuardDog)
					einDogTO = (GuardDogTO) transportObjekt;
					
				else 
					einDogTO = (SnuggleDogTO) transportObjekt;					
				

				dogDaten.add(einDogTO);
//				dogDaten.add(einDogTO = new GuardDogTO(scan.nextInt(), scan.next(),scan.nextInt(), scan.next(), scan.next(), scan.next())	);
			}
		}
		catch (EOFException e) {
		}
		catch (IOException e) {
			throw new DatenhaltungsException();
		}
		catch (ClassNotFoundException e) {
			throw new DatenhaltungsException();
		}
		finally {
			try {
				dogData.close();
			} catch (IOException e) {
				throw new DatenhaltungsException();
			}
		}
		
		return dogDaten;
	}

}
