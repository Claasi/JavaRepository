package awk.kundenverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.kundenverwaltung.entity.KundeTO;
import awk.kundenverwaltung.entity.internal.Geschaeftskunde;
import awk.kundenverwaltung.entity.internal.Kunde;
import awk.kundenverwaltung.entity.internal.Privatkunde;
import awk.kundenverwaltung.usecase.IKundenlisteErstellen;

public class KundenlisteErstellen implements IKundenlisteErstellen {
		
	public Collection<KundeTO> kundenListeAusgeben() throws AnwendungskernException {
		KundenManager einKundenManager = new KundenManager();
		Collection<KundeTO> kundenTOliste = new ArrayList<KundeTO>();
		Collection<Kunde> kundenliste = einKundenManager.kundenLiefern(); 
		
		for (Kunde einKunde:kundenliste)
			if (einKunde instanceof Geschaeftskunde)
				kundenTOliste.add( ((Geschaeftskunde)einKunde).toGeschaeftskundeTO());
			else
				kundenTOliste.add( ((Privatkunde)einKunde).toPrivatkundeTO());
		
		return kundenTOliste;
	}

}
