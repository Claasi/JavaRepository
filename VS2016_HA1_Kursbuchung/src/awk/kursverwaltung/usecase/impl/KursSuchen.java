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
	
	// 1. Funktionsaufruf - wird von TeilnehmerZumKursAnmelden aufgerufen. Gibt am Ende dieser Methode das Transferobjekt mit der übergebenen kursNR zurück
	public KursTO kursTOsuchenByNr(int kursNr) throws AnwendungskernException{
		
		KursManager km = KursManager.getKursManager();
		
		// geht hier in den KursManager rein und durchsucht die Datenbank nach Kursen mit der hier übgergebenen kursNR
		Kurs einKurs = km.getKursByNumber(kursNr);
		
		if(einKurs == null){
			return null;
		} else{
			// 
			return einKurs.toKursTO();
		}
		
		
	}
	

}
