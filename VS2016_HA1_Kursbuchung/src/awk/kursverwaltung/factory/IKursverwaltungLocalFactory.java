package awk.kursverwaltung.factory;

import awk.kursverwaltung.usecase.IKursAnlegen;
import awk.kursverwaltung.usecase.IKurseLaden;
import awk.kursverwaltung.usecase.ITeilnehmerAnlegen;
import awk.kursverwaltung.usecase.ITeilnehmerListeAnzeigen;

public interface IKursverwaltungLocalFactory {
	
	// Implementierung der Use-Cases:
	IKursAnlegen useCaseKursAnlegen();
	IKurseLaden useCaseKurseLaden();
	ITeilnehmerAnlegen useCaseTeilnehmerAnlegen();
	ITeilnehmerListeAnzeigen useCaseTeilnehmerListeAnzeigen();

}
