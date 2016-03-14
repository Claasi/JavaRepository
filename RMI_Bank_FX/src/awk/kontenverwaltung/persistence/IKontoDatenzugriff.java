package awk.kontenverwaltung.persistence;

import java.util.Collection;

import awk.DatenhaltungsException;
import awk.kontenverwaltung.entity.internal.Konto;

public interface IKontoDatenzugriff {
	
	public void kontendatenSpeichern(Collection<Konto> kontendaten) throws DatenhaltungsException;
	
	public Collection<Konto> kontendatenLesen() throws DatenhaltungsException;

}
