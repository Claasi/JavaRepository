package awk.kursverwaltung.usecase;

import java.rmi.RemoteException;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.kursverwaltung.entity.KursTO;

public interface IKurseLadenRemote {
	
	public Collection<KursTO> kursListeAusgeben() throws AnwendungskernException, RemoteException;

}
