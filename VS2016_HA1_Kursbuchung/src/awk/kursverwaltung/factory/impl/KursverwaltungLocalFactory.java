package awk.kursverwaltung.factory.impl;

import awk.kursverwaltung.factory.IKursverwaltungLocalFactory;
import awk.kursverwaltung.usecase.IKursAnlegen;
import awk.kursverwaltung.usecase.IKursSuchen;
import awk.kursverwaltung.usecase.IKurseLaden;
import awk.kursverwaltung.usecase.impl.KursAnlegen;
import awk.kursverwaltung.usecase.impl.KursSuchen;
import awk.kursverwaltung.usecase.impl.KurseLaden;

public class KursverwaltungLocalFactory implements IKursverwaltungLocalFactory{
	
	// Factory zur Erzeugung der benötigten Use Cases
	public IKursAnlegen useCaseKursAnlegen(){
		return new KursAnlegen();
	}
	public IKurseLaden useCaseKurseLaden() {
		return new KurseLaden();
	}
	public IKursSuchen useCaseKursSuchen(){
		return new KursSuchen();
	}
	
}
