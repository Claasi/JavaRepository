package awk.teilnehmerverwaltung.usecase;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;

public interface ITeilnehmerAnlegen {
	
	public boolean teilnehmerAnlegen(String vorName, String nachName) throws AnwendungskernException, DatenhaltungsException;

}
