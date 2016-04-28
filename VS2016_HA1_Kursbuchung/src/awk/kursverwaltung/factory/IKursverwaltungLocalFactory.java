package awk.kursverwaltung.factory;

import awk.kursverwaltung.usecase.IKursAnlegen;
import awk.kursverwaltung.usecase.IKursSuchen;
import awk.kursverwaltung.usecase.IKurseLaden;

public interface IKursverwaltungLocalFactory {
	
	// Implementierung der Use-Cases:
	IKursAnlegen useCaseKursAnlegen();
	IKurseLaden useCaseKurseLaden();
	IKursSuchen useCaseKursSuchen();

}
