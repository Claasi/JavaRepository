package awk.kursverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.kursverwaltung.entity.KursTO;
import awk.kursverwaltung.entity.internal.Kurs;
import awk.kursverwaltung.usecase.IKursSuchen;

public class KursSuchen implements IKursSuchen{
	
	public Collection<KursTO> sucheKursByNummer(int kursNr) throws AnwendungskernException {
		
		KursManager km = KursManager.getKursManager();
		Collection<Kurs> kursListe = km.sucheKursByNr(kursNr);
		
		if(kursListe.isEmpty()){
			return new ArrayList<KursTO>();
		} else {
			Collection<KursTO> kursTOListe = new ArrayList<KursTO>();
			for(Kurs einKurs : kursListe)
				kursTOListe.add(einKurs.toKursTO());
		
		return kursTOListe;
		}
	}

}
