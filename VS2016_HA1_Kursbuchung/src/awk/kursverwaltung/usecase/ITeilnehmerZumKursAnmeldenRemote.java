package awk.kursverwaltung.usecase;

import java.rmi.RemoteException;

import awk.AnwendungskernException;
import awk.kursverwaltung.entity.internal.Teilnehmer;

public interface ITeilnehmerZumKursAnmeldenRemote {
	
	public void addTeilnehmerToKurs(int kursnummer, Teilnehmer einTeilnehmer) throws AnwendungskernException, RemoteException;

}
