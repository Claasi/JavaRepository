package awk.teilnehmerverwaltung.usecase;

import java.util.Collection;

import awk.AnwendungskernException;
import awk.teilnehmerverwaltung.entity.TeilnehmerTO;

public interface ITeilnehmerListeAnzeigen {
	
	public Collection<TeilnehmerTO> teilnehmerListeAusgeben() throws AnwendungskernException;

}