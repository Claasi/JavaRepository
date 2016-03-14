package awk.autostamm.entity;

import java.io.Serializable;

import awk.autostamm.entity.impl.Dog;
import awk.autostamm.entity.impl.GuardDog;

public class GuardDogTO extends DogTO implements Serializable{

	private static final long serialVersionUID = -7503480801222507177L;
	
	private String userName;
	private String password;
	
//	Abstrakte  Methode der Superklasse DogTO, um ein Objekt
//	des GuardDogTOs zu erzeugen und diesem neue Attribute zuzuordnen
	public Dog toDog(){
		Dog einDog = new GuardDog(
				this.getChipNr(),
				this.getName(),
				this.getAlter(),
				this.getFarbe(),
				this.getUserName(),
				this.getPassword());
		
		return einDog;
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
