package awk.autostamm.entity.impl;

import java.io.Serializable;

import awk.autostamm.entity.DogTO;
import awk.autostamm.type.DogInfos;

public abstract class Dog implements Serializable {

	private static final long serialVersionUID = -8958499504140913322L;
	
	private int chipNr;
	private String name;
	private DogInfos dogInfos;
	
	public Dog(int chipNr, String name, int alter, String farbe){
		this.chipNr = chipNr;
		this.name = name;
		this.dogInfos = new DogInfos(alter, farbe);
	}

	// "Laufdog" (errand boy) erstellen, damit der Dog nicht selbst laufen muss
	public Dog(DogTO erstelleDogTO){
		this.chipNr = erstelleDogTO.getChipNr();
		this.name = erstelleDogTO.getName();
		this.dogInfos = new DogInfos(erstelleDogTO.getAlter(),erstelleDogTO.getFarbe());
	}
	
	// Wichtig!! Diese Methode wird zum Erzeugen der
	// anderen TO's benutzt!
	public abstract DogTO toDogTO();
	
	public int getChipNr() {
		return chipNr;
	}

	public String getName() {
		return name;
	}

	public DogInfos getDogInfos() {
		return dogInfos;
	}

}
