package awk.teilnehmerverwaltung.usecase.impl;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.teilnehmerverwaltung.entity.internal.Teilnehmer;
import awk.teilnehmerverwaltung.usecase.ITeilnehmerAnlegen;

public class TeilnehmerAnlegen implements ITeilnehmerAnlegen{
	
	public boolean teilnehmerAnlegen(String vorName, String nachName) throws AnwendungskernException, DatenhaltungsException{
		
		TeilnehmerManager tm = TeilnehmerManager.getTeilnehmerManager();
		int i = tm.naechsteNummerErmitteln();
		tm.addTeilnehmerToCollectionAndDB(new Teilnehmer(i+1, vorName, nachName));
		
		return true;
	}
}
