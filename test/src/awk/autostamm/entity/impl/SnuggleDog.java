package awk.autostamm.entity.impl;

import java.io.Serializable;

import awk.autostamm.entity.DogTO;
import awk.autostamm.entity.SnuggleDogTO;

public class SnuggleDog extends Dog implements Serializable {

	private static final long serialVersionUID = 423900376128730134L;
	
	private int cuteness;
	
	// Normaler Konstruktor zur Erstellung eines Objekts der Klasse SnuggleDog
	public SnuggleDog(int chipNr, String name, int alter, String farbe, int cuteness) {
		super(chipNr, name, alter, farbe);
		// TODO Auto-generated constructor stub
		this.cuteness = cuteness;
	}

	// "Laufdog" (errand boy) erstellen, damit der Dog nicht selbst laufen muss 
	public SnuggleDog(SnuggleDogTO erstelleSnuggleDogTO){
		super(erstelleSnuggleDogTO);
		this.cuteness = erstelleSnuggleDogTO.getCuteness();	
	}
	
	// Hier wird die abstrakte Methode von der Klasse "Dog" verwendet,
	// um ein Transport-Objekt der Klasse "SnuggleDog" (SnuggleDogTO) zu erzeugen
	public DogTO toDogTO() {
		// Erstelle SnuggleDog-Transportobjekt
		SnuggleDogTO einSnuggleDogTO = new SnuggleDogTO();
		
		// Weise die Attribute von SnuggleDog dem SnuggleDogTO zu
		einSnuggleDogTO.setChipNr(this.getChipNr());
		einSnuggleDogTO.setName(this.getName());
		einSnuggleDogTO.setAlter(this.getDogInfos().getAlter());
		einSnuggleDogTO.setFarbe(this.getDogInfos().getFarbe());
		einSnuggleDogTO.setCuteness(this.getCuteness());
		
		// gebe als Ergebnis ein Transport-Objekt zurück
		return einSnuggleDogTO;
	}

	public int getCuteness() {
		return cuteness;
	}

	public void setCuteness(int cuteness) {
		this.cuteness = cuteness;
	}
	
}
