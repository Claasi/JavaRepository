package awk.teilnehmerverwaltung.factory;

import java.rmi.RemoteException;

import awk.teilnehmerverwaltung.usecase.ITeilnehmerZumKursAnmeldenRemote;

public interface ITeilnehmerverwaltungRemoteFactory {

	ITeilnehmerZumKursAnmeldenRemote useCaseTeilnehmerZumKursAnmeldenRemote() throws RemoteException;
	
}
