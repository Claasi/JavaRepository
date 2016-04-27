package awk.kursverwaltung.factory.impl;

import awk.kursverwaltung.factory.IKursverwaltungLocalFactory;
import awk.kursverwaltung.usecase.IKursAnlegen;
import awk.kursverwaltung.usecase.IKurseLaden;
import awk.kursverwaltung.usecase.ITeilnehmerAnlegen;
import awk.kursverwaltung.usecase.ITeilnehmerListeAnzeigen;
import awk.kursverwaltung.usecase.ITeilnehmerZumKursAnmelden;
import awk.kursverwaltung.usecase.impl.KursAnlegen;
import awk.kursverwaltung.usecase.impl.KurseLaden;
import awk.kursverwaltung.usecase.impl.TeilnehmerAnlegen;
import awk.kursverwaltung.usecase.impl.TeilnehmerListeAnzeigen;
import awk.kursverwaltung.usecase.impl.TeilnehmerZumKursAnmelden;

public class KursverwaltungLocalFactory implements IKursverwaltungLocalFactory{
	
	// Factory zur Erzeugung der benötigten Use Cases
	public IKursAnlegen useCaseKursAnlegen(){
		return new KursAnlegen();
	}
	public IKurseLaden useCaseKurseLaden() {
		return new KurseLaden();
	}
	public ITeilnehmerAnlegen useCaseTeilnehmerAnlegen(){
		return new TeilnehmerAnlegen();
	}
	public ITeilnehmerListeAnzeigen useCaseTeilnehmerListeAnzeigen(){
		return new TeilnehmerListeAnzeigen();
	}
	public ITeilnehmerZumKursAnmelden useCaseTeilnehmerZumKursAnmelden() {
		return new TeilnehmerZumKursAnmelden();
	}

	
}
