package awk.kursverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.kursverwaltung.entity.KursTO;
import awk.kursverwaltung.entity.internal.Kurs;
import awk.kursverwaltung.usecase.IKurseLaden;

public class KurseLaden implements IKurseLaden{

	@Override
	public Collection<KursTO> kursListeAusgeben() throws AnwendungskernException {
		KursManager km = KursManager.getKursManager();
		Collection<KursTO> kursTOListe = new ArrayList<KursTO>();
		Collection<Kurs> kursListe = km.getKursListe(); 
		
		for (Kurs einKurs : kursListe)
				kursTOListe.add(einKurs.toKursTO());
		
		return kursTOListe;
	}
	
	

}
