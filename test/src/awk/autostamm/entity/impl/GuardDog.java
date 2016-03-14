package awk.autostamm.entity.impl;

import java.io.Serializable;

import awk.autostamm.entity.GuardDogTO;

public class GuardDog extends Dog implements Serializable{

	private static final long serialVersionUID = -2836609355278796095L;
	
	private String userName;
	private String password;
	
	// normaler Konstruktor
	public GuardDog (int chipNr, String name, int alter, String farbe, String username, String password){
		super(chipNr, name, alter, farbe);
		this.userName = username;
		this.password = password;
	}
	
	// "Laufdog" (errand boy) erstellen, damit der Dog nicht selbst laufen muss 
	public GuardDog(GuardDogTO erstelleGuardDogTO) {
		super(erstelleGuardDogTO);
		this.userName = erstelleGuardDogTO.getUserName();
		this.password = erstelleGuardDogTO.getPassword();
	}
	
	// Hier wird die abstrakte Methode von der Klasse "Dog" verwendet,
	// um ein TO der Klasse "GuardDog" zu erzeugen
	public GuardDogTO toDogTO() {
		GuardDogTO einGuardDogTO = new GuardDogTO();
		
		einGuardDogTO.setChipNr(this.getChipNr());
		einGuardDogTO.setName(this.getName());
		einGuardDogTO.setAlter(this.getDogInfos().getAlter());
		einGuardDogTO.setFarbe(this.getDogInfos().getFarbe());
		einGuardDogTO.setUserName(this.userName);
		einGuardDogTO.setPassword(this.password);
		
		return einGuardDogTO;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
