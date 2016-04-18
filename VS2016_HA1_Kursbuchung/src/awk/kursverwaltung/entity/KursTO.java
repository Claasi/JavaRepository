package awk.kursverwaltung.entity;

import java.io.Serializable;

import awk.kursverwaltung.entity.internal.Kurs;

public class KursTO implements Serializable {

	private static final long serialVersionUID = 6094449088744534712L;
	
	
	int kursNr;
	String kursName;
	int anzahlTeilnehmer;
	
//	Methode, um ein Objekt vom Typ Kurs zu erzeugen und dem erzeugten Objekt die Attribute von KursTO zuzuordnen
	public Kurs toKurs(){
		Kurs einKurs = new Kurs(
				this.getKursNr(),
				this.getKursName(),
				this.getAnzahlTeilnehmer());
		
		return einKurs;
	}
	
	public int getKursNr() {
		return kursNr;
	}
	public void setKursNr(int kursNr) {
		this.kursNr = kursNr;
	}
	public String getKursName() {
		return kursName;
	}
	public void setKursName(String kursName) {
		this.kursName = kursName;
	}
	public int getAnzahlTeilnehmer() {
		return anzahlTeilnehmer;
	}
	public void setAnzahlTeilnehmer(int anzahlTeilnehmer) {
		this.anzahlTeilnehmer = anzahlTeilnehmer;
	}
}
