package awk.kontenverwaltung.usecase.impl;

import awk.AnwendungskernException;
import awk.kontenverwaltung.entity.KontoTO;
import awk.kontenverwaltung.entity.internal.Konto;
import awk.kontenverwaltung.entity.internal.Kontobewegung;
import awk.kontenverwaltung.usecase.IKontobewegungBuchen;
import awk.kundenverwaltung.entity.KundeTO;
import awk.kundenverwaltung.factory.IKundenverwaltungFactory;
import awk.kundenverwaltung.factory.impl.KundenverwaltungFactory;
import awk.kundenverwaltung.usecase.IKundeninformationFuerNr;

public class KontobewegungBuchen implements IKontobewegungBuchen {


	public KontobewegungBuchen( ) {
	}
	
	public KontoTO kontoSuchen (int kontoNr) throws AnwendungskernException {
		KontenManager einKontoManager = new KontenManager();
		Konto einKonto = einKontoManager.kontoSuchenByNr(kontoNr);
		KontoTO einKontoTO;
		if ( einKonto != null) {
			einKontoTO = einKonto.toKontoTO();
			IKundenverwaltungFactory kvf = new KundenverwaltungFactory();
			IKundeninformationFuerNr kundeninfo = kvf.getKundeninformationFuerNr();
			KundeTO einKundeTO = kundeninfo.kundeSuchenByNr(einKonto.getInhaberNr());
			einKontoTO.setInhaberNachname(einKundeTO.getNachname());
			einKontoTO.setInhaberVorname(einKundeTO.getVorname());
		}
		else
			einKontoTO = null;
		
		return einKontoTO;
	}
	
	public boolean abheben(int kontoNr, double betrag) throws AnwendungskernException {
		KontenManager einKontoManager = new KontenManager();
		Konto einKonto = einKontoManager.kontoSuchenByNr(kontoNr);
		if (einKonto == null)
			return false;
		else {
			einKonto.addKontobewegung(new Kontobewegung(einKonto,'A',betrag));
			einKonto.setSaldo(einKonto.getSaldo()-betrag);
			einKontoManager.kontenSpeichern();
			return true;
		}
	}

	
	public boolean einzahlen(int kontoNr, double betrag) throws AnwendungskernException {
		KontenManager einKontoManager = new KontenManager();
		Konto einKonto = einKontoManager.kontoSuchenByNr(kontoNr);
		
		if (einKonto == null)
			return false;
		else {
			einKonto.addKontobewegung(new Kontobewegung(einKonto,'E',betrag));
			einKonto.setSaldo(einKonto.getSaldo()+betrag);
			einKontoManager.kontenSpeichern();
			return true;
		}
	}

}
