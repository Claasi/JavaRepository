package config;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.kursverwaltung.factory.IKursverwaltungLocalFactory;
import awk.kursverwaltung.factory.impl.KursverwaltungLocalFactory;
import awk.kursverwaltung.usecase.IKursAnlegen;

public class testKlasse {

	public static void main(String[] args) throws DatenhaltungsException, AnwendungskernException {


		// Relevante Komponenten des AWK's aus der Factory erzeugen
		IKursverwaltungLocalFactory kursFactorylocal = new KursverwaltungLocalFactory();

		// Benoetigte Use Cases mittels erzeugter Factory beziehen
		IKursAnlegen kursAnlegenLocal = kursFactorylocal.useCaseKursAnlegen();
		
		
		int kursNr = 6;
		String kursName = "Pilates";
		int anzahlTeilnehmer = 18;
		kursAnlegenLocal.kursAnlegen(kursNr, kursName, anzahlTeilnehmer);
		
		
	}

}
