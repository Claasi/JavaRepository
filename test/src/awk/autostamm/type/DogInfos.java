package awk.autostamm.type;

public class DogInfos {
	
	private int alter;
	private String farbe;
	
	public DogInfos(int alter, String farbe){
		this.alter = alter;
		this.farbe = farbe;
	}
	
	public static boolean pruefeDogInfos(int alter, String farbe){
		/* Das Alter beginnt mit einer Zahl */
		if(alter < 0)return false;

		/* Farbe besteht nur aus Buchstaben, Leerzeichen und -*/
		if(!farbe.matches("[a-zA-Z -]*"))return false;
		
		return true;
	}
	
	public int getAlter() {
		return alter;
	}
	
	public String getFarbe() {
		return farbe;
	}
	
	

}
