package awk.teilnehmerverwaltung.factory.impl;

import awk.teilnehmerverwaltung.factory.ITeilnehmerverwaltungRemoteFactory;
import awk.teilnehmerverwaltung.usecase.ITeilnehmerZumKursAnmeldenRemote;
import awk.teilnehmerverwaltung.usecase.impl.TeilnehmerZumKursAnmeldenRemote;

public class TeilnehmerverwaltungRemoteFactory implements ITeilnehmerverwaltungRemoteFactory{
	
	public ITeilnehmerZumKursAnmeldenRemote useCaseTeilnehmerZumKursAnmeldenRemote(){
		return new TeilnehmerZumKursAnmeldenRemote();
	}

}
