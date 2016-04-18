package awk.kursverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.kursverwaltung.entity.KursTO;
import awk.kursverwaltung.entity.internal.Kurs;
import awk.kursverwaltung.persistence.IAccessDataBase;
import awk.kursverwaltung.persistence.impl.AccessDataBase;

public class KursManager {
	
	public IAccessDataBase daoDB = new AccessDataBase();
	public Collection<Kurs> kurse = new ArrayList<Kurs>();
	
	private static KursManager kursManagement;
	
	public static KursManager getKursManager(){
		if(kursManagement == null){
			kursManagement = new KursManager();
		}
		return kursManagement;
	}
		
	public KursTO getKursInfo() throws DatenhaltungsException{
		return daoDB.getKursInfo();
	}
	
	public void updateKursInfo(int kursNr, String kursName, int anzahlTeilnehmer) throws DatenhaltungsException{
		daoDB.updateKursInfo(kursNr, kursName, anzahlTeilnehmer);
	}
	
	public void speichereKurs(int kursNr, String kursName, int anzahlTeilnehmer) throws DatenhaltungsException{
		daoDB.speichereKurs(kursNr, kursName, anzahlTeilnehmer);
	}
	

}
