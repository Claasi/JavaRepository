package awk.kursverwaltung.factory.impl;

import awk.kursverwaltung.factory.IKursverwaltungRemoteFactory;
import awk.kursverwaltung.usecase.IKurseLadenRemote;
import awk.kursverwaltung.usecase.impl.KurseLadenRemote;

public class KursverwaltungRemoteFactory implements IKursverwaltungRemoteFactory{
	
	// Factory zur Erzeugung der benötigten Use Cases
	public IKurseLadenRemote useCaseKurseLadenRemote(){
		return new KurseLadenRemote();
	}

}
