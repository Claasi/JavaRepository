package awk.teilnehmerverwaltung.usecase.impl;

import java.rmi.RemoteException;

import awk.AnwendungskernException;
import awk.teilnehmerverwaltung.usecase.impl.TeilnehmerZumKursAnmelden;
import awk.teilnehmerverwaltung.entity.internal.Teilnehmer;
import awk.teilnehmerverwaltung.usecase.ITeilnehmerZumKursAnmeldenRemote;

public class TeilnehmerZumKursAnmeldenRemote implements ITeilnehmerZumKursAnmeldenRemote{
	
	public void addTeilnehmerToKurs(int kursnummer, Teilnehmer einTeilnehmer) throws AnwendungskernException, RemoteException{
		
		TeilnehmerZumKursAnmelden teilnehmerZumKursAnmelden = new TeilnehmerZumKursAnmelden();
		
		teilnehmerZumKursAnmelden.addTeilnehmerToKurs(kursnummer, einTeilnehmer);
	}
}
