package awk.kundenverwaltung.entity;

import java.io.Serializable;

public class GeschaeftskundeTO extends KundeTO implements Serializable {
	

	private static final long serialVersionUID = 2099725816139938730L;
	private String ustId;
	
	
	public String getUstId() {
		return ustId;
	}
	public void setUstId(String ustId) {
		this.ustId = ustId;
	}
}
