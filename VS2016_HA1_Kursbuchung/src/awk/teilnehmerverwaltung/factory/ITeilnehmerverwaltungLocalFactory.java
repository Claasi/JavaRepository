package awk.teilnehmerverwaltung.factory;

import awk.teilnehmerverwaltung.usecase.ITeilnehmerAnlegen;
import awk.teilnehmerverwaltung.usecase.ITeilnehmerListeAnzeigen;
import awk.teilnehmerverwaltung.usecase.ITeilnehmerZumKursAnmelden;

public interface ITeilnehmerverwaltungLocalFactory {
	
	ITeilnehmerAnlegen useCaseTeilnehmerAnlegen();
	ITeilnehmerListeAnzeigen useCaseTeilnehmerListeAnzeigen();
	ITeilnehmerZumKursAnmelden useCaseTeilnehmerZumKursAnmelden();

}
