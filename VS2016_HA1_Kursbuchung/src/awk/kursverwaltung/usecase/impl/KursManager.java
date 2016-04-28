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
	public Collection<Kurs> kursListe = new ArrayList<Kurs>();
	
	private static KursManager kursManagement;
	
	public static KursManager getKursManager() throws AnwendungskernException{
		if(kursManagement == null){
			kursManagement = new KursManager();
		}
		return kursManagement;
	}
	
	private KursManager() throws AnwendungskernException{
		kursListe = new ArrayList<Kurs>();
		this.kurseLaden();
	}
		
//	public KursTO getKursInfo() throws DatenhaltungsException{
//		return daoDB.getKursInfo();
//	}
//	
//	public void updateKursInfo(int kursNr, String kursName, int anzahlTeilnehmer) throws DatenhaltungsException{
//		daoDB.updateKursInfo(kursNr, kursName, anzahlTeilnehmer);
//	}
//	
//	public void speichereKurs(int kursNr, String kursName, int anzahlTeilnehmer) throws DatenhaltungsException{
//		daoDB.speichereKurs(kursNr, kursName, anzahlTeilnehmer);
//	}
	
	public void addKursCollectionAndDB(Kurs einKurs) throws AnwendungskernException{
		this.kursListe.add(einKurs);
		this.saveKursListe();
	}
	
	public void kurseLaden() throws AnwendungskernException{
		Collection<KursTO> kursListe;
		try {
			kursListe = daoDB.getKursListe();
		} catch (DatenhaltungsException e){
			throw new AnwendungskernException();
		}
		this.kursListe.clear();
		for(KursTO einKursTO : kursListe)
			this.kursListe.add(einKursTO.toKurs());
	}
	
	public Collection<Kurs> getKursListe(){
		return this.kursListe;
	}
	
	public void saveKursListe () throws AnwendungskernException{
		Collection<KursTO> kursTOListe = new ArrayList<KursTO>();
		for(Kurs einKurs : this.kursListe)
			kursTOListe.add(einKurs.toKursTO());
		try {
			daoDB.kursDatenListeSpeichern(kursTOListe);
		}catch (DatenhaltungsException e) {
			throw new AnwendungskernException();
		}
	}
	
	public int naechsteKursNummerErmitteln(){
		int max = 1;
			for( Kurs einKurs:this.kursListe )
				if(einKurs.getKursNr() > max)
					max = einKurs.getKursNr();
		return max;
	}
	
	public Kurs getKursByNumber(int kursNr){
		for (Kurs einKurs : this.kursListe){
			if (einKurs.getKursNr() == kursNr){
				return einKurs;
			}
		}
		return null;
	}
	
	
	public Collection<Kurs> sucheKursByNr(int kursNummer) {
		Collection<Kurs> kursListe = new ArrayList<Kurs>();
		for (Kurs einKurs : this.kursListe){
			if(einKurs.getKursNr() == kursNummer)
				kursListe.add(einKurs);
		}
		return kursListe;
	}
	

}
