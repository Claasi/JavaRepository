package config;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.kursverwaltung.factory.IKursverwaltungLocalFactory;
import awk.kursverwaltung.factory.impl.KursverwaltungLocalFactory;
import awk.kursverwaltung.usecase.IKursAnlegen;
import awk.kursverwaltung.usecase.IKurseLaden;
import awk.kursverwaltung.usecase.ITeilnehmerAnlegen;
import awk.kursverwaltung.usecase.ITeilnehmerListeAnzeigen;

public class testKlasse {

	public static void main(String[] args) throws DatenhaltungsException, AnwendungskernException {


		// Relevante Komponenten des AWK's aus der Factory erzeugen
		IKursverwaltungLocalFactory kursFactorylocal = new KursverwaltungLocalFactory();

		// Benoetigte Use Cases mittels erzeugter Factory beziehen
		IKursAnlegen kursAnlegenLocal = kursFactorylocal.useCaseKursAnlegen();
		IKurseLaden kurseLadenLocal = kursFactorylocal.useCaseKurseLaden();
		ITeilnehmerListeAnzeigen teilnehmerListeAnzeigen = kursFactorylocal.useCaseTeilnehmerListeAnzeigen();
		ITeilnehmerAnlegen teilnehmerAnlegenLocal = kursFactorylocal.useCaseTeilnehmerAnlegen();		

//		String kursName = "Programmieren";
//		int anzahlTeilnehmer = 20;
//		kursAnlegenLocal.kursAnlegen(kursName, anzahlTeilnehmer);
		
//		String vorName = "Tony";
//		String nachName = "Chopper";
//		teilnehmerAnlegenLocal.teilnehmerAnlegen(vorName, nachName);
		
		teilnehmerListeAnzeigen.teilnehmerListeAusgeben();
		kurseLadenLocal.kursListeAusgeben();
	}

}
