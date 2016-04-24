package awk.kursverwaltung.usecase.impl;

import awk.DatenhaltungsException;
import awk.AnwendungskernException;
import awk.kursverwaltung.entity.internal.Teilnehmer;
import awk.kursverwaltung.usecase.ITeilnehmerAnlegen;

public class TeilnehmerAnlegen implements ITeilnehmerAnlegen{
	
	public boolean teilnehmerAnlegen(String vorName, String nachName) throws AnwendungskernException, DatenhaltungsException{
		
		TeilnehmerManager tm = TeilnehmerManager.getTeilnehmerManager();
		int i = tm.naechsteNummerErmitteln();
		tm.addTeilnehmerToCollectionAndDB(new Teilnehmer(i+1, vorName, nachName));
		
		return true;
	}

}
