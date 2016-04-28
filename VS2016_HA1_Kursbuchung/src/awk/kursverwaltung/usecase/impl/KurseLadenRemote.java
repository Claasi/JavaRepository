package awk.kursverwaltung.usecase.impl;

import java.rmi.RemoteException;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.kursverwaltung.entity.KursTO;
import awk.kursverwaltung.usecase.IKurseLadenRemote;

public class KurseLadenRemote implements IKurseLadenRemote{

	@Override
	public Collection<KursTO> kursListeAusgeben() throws AnwendungskernException, RemoteException {
		KurseLaden kurseLaden = new KurseLaden();
		
		return kurseLaden.kursListeAusgeben();
	}

}
