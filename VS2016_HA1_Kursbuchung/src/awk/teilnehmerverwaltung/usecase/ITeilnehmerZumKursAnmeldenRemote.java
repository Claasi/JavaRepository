package awk.teilnehmerverwaltung.usecase;

import java.rmi.RemoteException;

import awk.AnwendungskernException;
import awk.teilnehmerverwaltung.entity.internal.Teilnehmer;

public interface ITeilnehmerZumKursAnmeldenRemote {
	
	public void addTeilnehmerToKurs(int kursnummer, Teilnehmer einTeilnehmer) throws AnwendungskernException, RemoteException;

}
