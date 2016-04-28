package awk.kursverwaltung.entity.internal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import awk.kursverwaltung.entity.KursTO;
import awk.teilnehmerverwaltung.entity.internal.Teilnehmer;

public class Kurs implements Serializable {

	private static final long serialVersionUID = 2789703077072992886L;
	
	private int kursNr;
	private String kursName;
	private int anzahlTeilnehmer;
	private Collection<Teilnehmer> teilnehmerListe;
	
	// Konstruktor
	public Kurs(int kursNr, String kursName, int anzahlTeilnehmer){
		this.kursNr = kursNr;
		this.kursName = kursName;
		this.anzahlTeilnehmer = anzahlTeilnehmer;
		this.teilnehmerListe = new ArrayList<Teilnehmer>();
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
		
//		einKursTO.setTeilnehmerListe(new ArrayList<TeilnehmerTO>());
//		for(Teilnehmer einTeilnehmer : this.getTeilnehmerListe())
//			einKursTO.getTeilnehmerListe().add(new TeilnehmerTO());
		
		return einKursTO;
	}
	
	public void addTeilnehmer(Teilnehmer einTeilnehmer){
		this.teilnehmerListe.add(new Teilnehmer(einTeilnehmer.getTeilnehmerNr(), einTeilnehmer.getVorName(), einTeilnehmer.getNachName()));
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

	public Collection<Teilnehmer> getTeilnehmerListe() {
		return this.teilnehmerListe;
	}
	
	public void printCollection(Collection<Teilnehmer> teilnehmerListe){
		for(Teilnehmer einTeilnehmer : teilnehmerListe)
			System.out.println(einTeilnehmer);
	}

	@Override
	public String toString() {
		return "Kurs [kursNr=" + kursNr + ", kursName=" + kursName + ", anzahlTeilnehmer=" + anzahlTeilnehmer
				+ ", teilnehmerListe=" + teilnehmerListe + "]\n";
	}
	
	
	
	
}
