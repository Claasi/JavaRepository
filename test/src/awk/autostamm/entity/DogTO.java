package awk.autostamm.entity;

import java.io.Serializable;

import awk.autostamm.entity.impl.Dog;

public abstract class DogTO implements Serializable {

	private static final long serialVersionUID = 6586438773091377043L;
	
	int chipNr;
	String name;
	int alter;
	String farbe;
	
	// Abstrakte Methode für die Subklassen GuardDogTO und SnuggleDogTO
	public abstract Dog toDog();

	// Setters
	public void setChipNr(int chipNr) {
		this.chipNr = chipNr;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	// Getters
	public int getChipNr() {
		return chipNr;
	}

	public String getName() {
		return name;
	}

	public int getAlter() {
		return alter;
	}

	public String getFarbe() {
		return farbe;
	}
}
