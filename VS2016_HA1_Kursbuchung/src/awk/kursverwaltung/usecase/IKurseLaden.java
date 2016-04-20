package awk.kursverwaltung.usecase;

import java.util.Collection;

import awk.AnwendungskernException;
import awk.kursverwaltung.entity.KursTO;

public interface IKurseLaden {
	
	public Collection<KursTO> kursListeAusgeben() throws AnwendungskernException;

}
