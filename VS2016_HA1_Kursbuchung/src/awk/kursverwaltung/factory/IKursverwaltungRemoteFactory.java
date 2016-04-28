package awk.kursverwaltung.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import awk.kursverwaltung.usecase.IKurseLadenRemote;
import awk.kursverwaltung.usecase.ITeilnehmerZumKursAnmeldenRemote;

public interface IKursverwaltungRemoteFactory extends Remote{
	
	// Implementierung der Use-Cases:
	IKurseLadenRemote useCaseKurseLadenRemote() throws RemoteException;
	ITeilnehmerZumKursAnmeldenRemote useCaseTeilnehmerZumKursAnmeldenRemote() throws RemoteException;

}
