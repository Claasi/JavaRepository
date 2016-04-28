package awk.teilnehmerverwaltung.factory.impl;

import awk.teilnehmerverwaltung.factory.ITeilnehmerverwaltungLocalFactory;
import awk.teilnehmerverwaltung.usecase.ITeilnehmerAnlegen;
import awk.teilnehmerverwaltung.usecase.ITeilnehmerListeAnzeigen;
import awk.teilnehmerverwaltung.usecase.ITeilnehmerZumKursAnmelden;
import awk.teilnehmerverwaltung.usecase.impl.TeilnehmerAnlegen;
import awk.teilnehmerverwaltung.usecase.impl.TeilnehmerListeAnzeigen;
import awk.teilnehmerverwaltung.usecase.impl.TeilnehmerZumKursAnmelden;

public class TeilnehmerverwaltungLocalFactory implements ITeilnehmerverwaltungLocalFactory{
	
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
