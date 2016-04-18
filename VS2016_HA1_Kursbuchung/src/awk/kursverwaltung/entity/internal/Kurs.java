package awk.kursverwaltung.entity.internal;

import java.io.Serializable;
import awk.kursverwaltung.entity.KursTO;

public class Kurs implements Serializable {

	private static final long serialVersionUID = 2789703077072992886L;
	
	private int kursNr;
	private String kursName;
	private int anzahlTeilnehmer;
	
	public Kurs(int kursNr, String kursName, int anzahlTeilnehmer){
		this.kursNr = kursNr;
		this.kursName = kursName;
		this.anzahlTeilnehmer = anzahlTeilnehmer;
	}
	
	// KursTO erstellen
	public Kurs(KursTO erstelleKursTO){
		this.kursNr = erstelleKursTO.getKursNr();
		this.kursName = erstelleKursTO.getKursName();
		this.anzahlTeilnehmer = erstelleKursTO.getAnzahlTeilnehmer();
	}
	
	// Transport-Objekt der Klasse KursTO erzeugen und diesem, die Eigenschaften von Kurs zuordnen
	public KursTO toKursTO() {
		KursTO einKursTO = new KursTO();
		
		einKursTO.setKursNr(this.getKursNr());
		einKursTO.setKursName(this.getKursName());
		einKursTO.setAnzahlTeilnehmer(this.getAnzahlTeilnehmer());
		
		return einKursTO;
	}

	public int getKursNr() {
		return kursNr;
	}

	public String getKursName() {
		return kursName;
	}

	public int getAnzahlTeilnehmer() {
		return anzahlTeilnehmer;
	}

}
