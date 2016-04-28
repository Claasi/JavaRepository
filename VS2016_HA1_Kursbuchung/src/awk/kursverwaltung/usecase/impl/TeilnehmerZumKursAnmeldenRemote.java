package awk.kursverwaltung.usecase.impl;

import java.rmi.RemoteException;

import awk.AnwendungskernException;
import awk.kursverwaltung.entity.internal.Teilnehmer;
import awk.kursverwaltung.usecase.ITeilnehmerZumKursAnmeldenRemote;

public class TeilnehmerZumKursAnmeldenRemote implements ITeilnehmerZumKursAnmeldenRemote{
	
	public void addTeilnehmerToKurs(int kursnummer, Teilnehmer einTeilnehmer) throws AnwendungskernException, RemoteException{
		
		TeilnehmerZumKursAnmelden teilnehmerZumKursAnmelden = new TeilnehmerZumKursAnmelden();
		
		teilnehmerZumKursAnmelden.addTeilnehmerToKurs(kursnummer, einTeilnehmer);
	}

}
