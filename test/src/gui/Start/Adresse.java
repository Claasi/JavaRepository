package gui.Start;

public class Adresse {
	
	private String vorname;
	private String nachname;
	private String telefon;
	private String eMail;
	
	public Adresse(String vorname, String nachname, String telefon, String eMail){
		this.vorname = vorname;
		this.nachname = nachname;
		this.telefon = telefon;
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "Adressbuch [vorname=" + vorname + ", nachname=" + nachname + ", telefon=" + telefon + ", eMail=" + eMail
				+ "]";
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

}
