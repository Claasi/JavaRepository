package awk.kursverwaltung.usecase.impl;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.kursverwaltung.usecase.IKursAnlegen;

public class KursAnlegen implements IKursAnlegen{
	
	public void kursAnlegen(int kursNr, String kursName, int anzahlTeilnehmer) throws AnwendungskernException, DatenhaltungsException{
		
		KursManager km = KursManager.getKursManager();
		
//		System.out.println("'" + name + "'" + " wurde zur Liste hinzugef�gt!\n");
				
		km.speichereKurs(kursNr, kursName, anzahlTeilnehmer);
	}

}
