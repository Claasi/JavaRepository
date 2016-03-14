package awk.kundenverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.kundenverwaltung.entity.KundeTO;
import awk.kundenverwaltung.entity.internal.Geschaeftskunde;
import awk.kundenverwaltung.entity.internal.Kunde;
import awk.kundenverwaltung.entity.internal.Privatkunde;
import awk.kundenverwaltung.usecase.IKundenSuchen;

public class KundenSuchen implements IKundenSuchen{
	
	public Collection<KundeTO> kundenSuchenByName(String vorname, String nachname) throws AnwendungskernException {
		KundenManager einKundenManager = new KundenManager();
		Collection<Kunde> kundenliste = einKundenManager.kundeSuchenByName(nachname, vorname); 
		if (kundenliste.isEmpty()) {
			return new ArrayList<KundeTO>();
		}
		else {
			Collection<KundeTO> kundenTOliste = new ArrayList<KundeTO>();
			for (Kunde einKunde:kundenliste)
				if (einKunde instanceof Geschaeftskunde)
					kundenTOliste.add( ((Geschaeftskunde)einKunde).toGeschaeftskundeTO());
				else
					kundenTOliste.add( ((Privatkunde)einKunde).toPrivatkundeTO());
			return kundenTOliste;
		}
	}

}
