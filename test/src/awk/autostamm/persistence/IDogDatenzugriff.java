package awk.autostamm.persistence;

import java.util.Collection;

import awk.DatenhaltungsException;
import awk.autostamm.entity.DogTO;

public interface IDogDatenzugriff {
	
	public void saveDogData(Collection<DogTO> dogDaten) throws DatenhaltungsException;
	
	public Collection<DogTO> readDogData() throws DatenhaltungsException;

}
