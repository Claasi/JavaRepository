package awk.autostamm.entity;

import java.io.Serializable;

import awk.autostamm.entity.impl.Dog;
import awk.autostamm.entity.impl.SnuggleDog;

public class SnuggleDogTO extends DogTO implements Serializable {

	private static final long serialVersionUID = 4802519001579291664L;
	
	private int cuteness;
	
//	Abstrakte  Methode der Klasse DogTO, welche genutzt wird, um ein Transport-Objekt
//	des SnuggleDogs zu erzeugen und diesem die Attribute der Klasse 'SnuggleDog' (bzw. SnuggleDogTO) hinzufügen
	public Dog toDog() {
		Dog einDog = new SnuggleDog(
				
				// Attribute des übergeordneten Transportobjekts (DogTO) beziehen
				this.getChipNr(),
				this.getName(),
				this.getAlter(),
				this.getFarbe(),
				
				// spezifisches Attribut beziehen der Klasse SnuggleDogTO beziehen
				this.getCuteness()
				);
		
		return einDog;
	}

	public int getCuteness() {
		return cuteness;
	}

	public void setCuteness(int cuteness) {
		this.cuteness = cuteness;
	}

	
	
}
