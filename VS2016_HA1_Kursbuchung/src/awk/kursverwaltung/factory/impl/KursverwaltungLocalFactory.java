package awk.kursverwaltung.factory.impl;

import awk.kursverwaltung.factory.IKursverwaltungLocalFactory;
import awk.kursverwaltung.usecase.IKursAnlegen;
import awk.kursverwaltung.usecase.impl.KursAnlegen;

public class KursverwaltungLocalFactory implements IKursverwaltungLocalFactory{
	
	public IKursAnlegen useCaseKursAnlegen(){
		return new KursAnlegen();
	}

}
