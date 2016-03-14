package awk.kundenverwaltung.usecase.impl;

import awk.AnwendungskernException;
import awk.kundenverwaltung.entity.KundeTO;
import awk.kundenverwaltung.entity.internal.Geschaeftskunde;
import awk.kundenverwaltung.entity.internal.Kunde;
import awk.kundenverwaltung.entity.internal.Privatkunde;
import awk.kundenverwaltung.usecase.IKundeninformationFuerNr;

public class KundeninformationFuerNr implements IKundeninformationFuerNr {

	public KundeTO kundeSuchenByNr(int nummer) throws AnwendungskernException {
		KundenManager einKundenManager = new KundenManager();
		Kunde einKunde = einKundenManager.kundeSuchenByNr(nummer); 
		if (einKunde == null) {
			return null;
		}
		else {
			if (einKunde instanceof Geschaeftskunde)
				return ((Geschaeftskunde) einKunde).toGeschaeftskundeTO();
			else
				return ((Privatkunde)einKunde).toPrivatkundeTO();
			}
			
	}

	

}
