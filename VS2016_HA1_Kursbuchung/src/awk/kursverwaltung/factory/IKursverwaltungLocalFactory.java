package awk.kursverwaltung.factory;

import awk.kursverwaltung.usecase.IKursAnlegen;

public interface IKursverwaltungLocalFactory {
	
	// Implementierung der Use-Cases:
	IKursAnlegen useCaseKursAnlegen();

}
