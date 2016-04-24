package awk.kursverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.kursverwaltung.entity.TeilnehmerTO;
import awk.kursverwaltung.entity.internal.Teilnehmer;
import awk.kursverwaltung.usecase.ITeilnehmerListeAnzeigen;

public class TeilnehmerListeAnzeigen implements ITeilnehmerListeAnzeigen {

	public Collection<TeilnehmerTO> teilnehmerListeAusgeben() throws AnwendungskernException {
		
		TeilnehmerManager tm = TeilnehmerManager.getTeilnehmerManager();
		Collection<TeilnehmerTO> teilnehmerTOListe = new ArrayList<TeilnehmerTO>();
		Collection<Teilnehmer> teilnehmerListe = tm.getTeilnehmerListe(); 
		
		for (Teilnehmer einTeilnehmer : teilnehmerListe)
			teilnehmerTOListe.add(einTeilnehmer.toTeilnehmerTO());
		
		return teilnehmerTOListe;
	}

}
