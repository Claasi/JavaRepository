package awk.kursverwaltung.usecase;

import java.util.Collection;

import awk.AnwendungskernException;
import awk.kursverwaltung.entity.KursTO;

public interface IKursSuchen {
	
	public Collection<KursTO> sucheKursByNummer(int kursNr) throws AnwendungskernException;

}
