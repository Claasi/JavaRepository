package awk.kundenverwaltung.persistence;

import java.util.Collection;

import awk.DatenhaltungsException;
import awk.kundenverwaltung.entity.internal.Kunde;

public interface IKundenDatenzugriff {
	
	public void kundendatenSpeichern(Collection<Kunde> kundendaten) throws DatenhaltungsException;
	
	public Collection<Kunde> kundendatenLesen() throws DatenhaltungsException;

}
