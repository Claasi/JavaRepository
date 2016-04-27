package awk.kursverwaltung.entity.internal;

import java.io.Serializable;
import awk.kursverwaltung.entity.TeilnehmerTO;

public class Teilnehmer implements Serializable {

	private static final long serialVersionUID = -2863685132893838454L;
	
	private int teilnehmerNr;
	private String vorName;
	private String nachName;
	
	// Konstruktor
	public Teilnehmer(int teilnehmerNr, String vorName, String nachName){
		this.teilnehmerNr = teilnehmerNr;
		this.vorName = vorName;
		this.nachName = nachName;
	}
	
	// Ordne einem übergebenen TeilnehmerTO die Werte von Teilnehmer zu
	public Teilnehmer(TeilnehmerTO erstelleTeilnehmerTO){
		this.teilnehmerNr = erstelleTeilnehmerTO.getTeilnehmerNr();
		this.vorName = erstelleTeilnehmerTO.getVorName();
		this.nachName = erstelleTeilnehmerTO.getNachName();
	}
	
	// Transport-Objekt der Klasse TeilnehmerTO erzeugen und diesem die Werte von Teilnehmer zuordnen
	public TeilnehmerTO toTeilnehmerTO(){
		TeilnehmerTO einTeilnehmerTO = new TeilnehmerTO();
		
		einTeilnehmerTO.setTeilnehmerNr(this.getTeilnehmerNr());
		einTeilnehmerTO.setVorName(this.getVorName());
		einTeilnehmerTO.setNachName(this.getNachName());
		
		return einTeilnehmerTO;
	}
	
	public int getTeilnehmerNr() {
		return teilnehmerNr;
	}

	public String getVorName() {
		return vorName;
	}

	public String getNachName() {
		return nachName;
	}

	@Override
	public String toString() {
		return "Teilnehmer [teilnehmerNr=" + teilnehmerNr + ", vorName=" + vorName + ", nachName=" + nachName + "]";
	}
	
	

}