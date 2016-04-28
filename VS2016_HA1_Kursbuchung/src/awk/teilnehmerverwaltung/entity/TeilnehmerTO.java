package awk.teilnehmerverwaltung.entity;

import java.io.Serializable;

import awk.teilnehmerverwaltung.entity.internal.Teilnehmer;

public class TeilnehmerTO implements Serializable{

	private static final long serialVersionUID = -3993297426110510874L;

	int teilnehmerNr;
	String vorName;
	String nachName;
	
	// Erstelle ein Objekt vom Typ Teilnehmer und weise dem Objekt die Attribute des Transferobjekts "TeilnehmerTO" zu
	public Teilnehmer toTeilnehmer(){
		Teilnehmer einTeilnehmer = new Teilnehmer(
				
				this.getTeilnehmerNr(),
				this.getVorName(),
				this.getNachName());
		
		return einTeilnehmer;
	}

	public int getTeilnehmerNr() {
		return teilnehmerNr;
	}
	public void setTeilnehmerNr(int teilnehmerNr) {
		this.teilnehmerNr = teilnehmerNr;
	}
	public String getVorName() {
		return vorName;
	}
	public void setVorName(String vorName) {
		this.vorName = vorName;
	}
	public String getNachName() {
		return nachName;
	}
	public void setNachName(String nachName) {
		this.nachName = nachName;
	}
}

