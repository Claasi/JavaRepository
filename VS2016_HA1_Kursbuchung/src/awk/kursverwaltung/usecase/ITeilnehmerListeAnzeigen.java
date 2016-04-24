package awk.kursverwaltung.usecase;

import java.util.Collection;

import awk.AnwendungskernException;
import awk.kursverwaltung.entity.TeilnehmerTO;

public interface ITeilnehmerListeAnzeigen {
	
	public Collection<TeilnehmerTO> teilnehmerListeAusgeben() throws AnwendungskernException;

}
