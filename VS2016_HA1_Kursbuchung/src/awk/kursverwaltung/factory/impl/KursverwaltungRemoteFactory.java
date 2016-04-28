package awk.kursverwaltung.factory.impl;

import awk.kursverwaltung.factory.IKursverwaltungRemoteFactory;
import awk.kursverwaltung.usecase.IKurseLadenRemote;
import awk.kursverwaltung.usecase.ITeilnehmerZumKursAnmeldenRemote;
import awk.kursverwaltung.usecase.impl.KurseLadenRemote;
import awk.kursverwaltung.usecase.impl.TeilnehmerZumKursAnmeldenRemote;

public class KursverwaltungRemoteFactory implements IKursverwaltungRemoteFactory{
	
	// Factory zur Erzeugung der benötigten Use Cases
	public IKurseLadenRemote useCaseKurseLadenRemote(){
		return new KurseLadenRemote();
	}
	public ITeilnehmerZumKursAnmeldenRemote useCaseTeilnehmerZumKursAnmeldenRemote(){
		return new TeilnehmerZumKursAnmeldenRemote();
	}

}
