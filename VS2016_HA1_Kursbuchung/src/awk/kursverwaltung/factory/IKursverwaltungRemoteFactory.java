package awk.kursverwaltung.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import awk.kursverwaltung.usecase.IKurseLadenRemote;

public interface IKursverwaltungRemoteFactory extends Remote{
	
	// Implementierung der Use-Cases:
	IKurseLadenRemote useCaseKurseLadenRemote() throws RemoteException;

}
