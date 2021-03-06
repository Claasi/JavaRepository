package config;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.kursverwaltung.entity.KursTO;
import awk.kursverwaltung.entity.internal.Kurs;
import awk.kursverwaltung.factory.IKursverwaltungLocalFactory;
import awk.kursverwaltung.factory.impl.KursverwaltungLocalFactory;
import awk.kursverwaltung.usecase.IKursAnlegen;
import awk.kursverwaltung.usecase.IKursSuchen;
import awk.kursverwaltung.usecase.IKurseLaden;
import awk.teilnehmerverwaltung.entity.internal.Teilnehmer;
import awk.teilnehmerverwaltung.factory.ITeilnehmerverwaltungLocalFactory;
import awk.teilnehmerverwaltung.factory.impl.TeilnehmerverwaltungLocalFactory;
import awk.teilnehmerverwaltung.usecase.ITeilnehmerAnlegen;
import awk.teilnehmerverwaltung.usecase.ITeilnehmerListeAnzeigen;
import awk.teilnehmerverwaltung.usecase.ITeilnehmerZumKursAnmelden;

public class testKlasse {

	public static void main(String[] args) throws DatenhaltungsException, AnwendungskernException {


		// Relevante Komponenten des AWK's aus der Factory erzeugen
		IKursverwaltungLocalFactory kursFactorylocal = new KursverwaltungLocalFactory();
		ITeilnehmerverwaltungLocalFactory teilnehmerFactoryLocal = new TeilnehmerverwaltungLocalFactory();

		// Benoetigte Use Cases mittels erzeugter Factory beziehen
		IKursAnlegen kursAnlegenLocal = kursFactorylocal.useCaseKursAnlegen();
		IKurseLaden kurseLadenLocal = kursFactorylocal.useCaseKurseLaden();
		IKursSuchen kursSuchenLocal = kursFactorylocal.useCaseKursSuchen();
		ITeilnehmerListeAnzeigen teilnehmerListeAnzeigen = teilnehmerFactoryLocal.useCaseTeilnehmerListeAnzeigen();
		ITeilnehmerAnlegen teilnehmerAnlegenLocal = teilnehmerFactoryLocal.useCaseTeilnehmerAnlegen();	
		ITeilnehmerZumKursAnmelden teilnehmerZumKursAnmelden = teilnehmerFactoryLocal.useCaseTeilnehmerZumKursAnmelden();


//		String kursName = "Programmieren";
//		int anzahlTeilnehmer = 20;
//		kursAnlegenLocal.kursAnlegen(kursName, anzahlTeilnehmer);
		
//		String vorName = "Tony";
//		String nachName = "Chopper";
//		teilnehmerAnlegenLocal.teilnehmerAnlegen(vorName, nachName);
//		
//		teilnehmerListeAnzeigen.teilnehmerListeAusgeben();
//		kurseLadenLocal.kursListeAusgeben();
		
		
		Collection<Kurs> kursListe = new ArrayList<Kurs>();
		
		int kursNr = 1;
		String kursName = "Proggen";
		int anzahlTeilnehmer = 3;
		Kurs einKursA = new Kurs( kursNr,  kursName,  anzahlTeilnehmer);
		kursListe.add(einKursA);
		
		kursNr = 2;
		kursName = "Laufen";
		anzahlTeilnehmer = 4;
		Kurs einKursB = new Kurs( kursNr,  kursName,  anzahlTeilnehmer);
		
		int teilnehmerNr = 1;
		String vorName = "Tony";
		String nachName = "Chopper";
		Teilnehmer einTeilnehmerA = new Teilnehmer(teilnehmerNr, vorName, nachName);
		
		einKursB.addTeilnehmer(einTeilnehmerA);
		
		teilnehmerNr = 4;
		vorName = "Harald";
		nachName = "Schmidt";
		Teilnehmer einTeilnehmerB = new Teilnehmer(teilnehmerNr, vorName, nachName);
		
		einKursB.addTeilnehmer(einTeilnehmerB);
		
		kursListe.add(einKursB);
		
//		System.out.println(kursListe + "\n");
//		System.out.println(kursListe);
		
		for(Kurs aK : kursListe){
			System.out.println(aK);
			System.out.println(aK.getKursNr()+" "+aK.getKursName()+" "+aK.getAnzahlTeilnehmer());
			System.out.println("Anzahl Teilnehmer:"+aK.getTeilnehmerListe().size());
			for (Teilnehmer einTeilnehmer : aK.getTeilnehmerListe()){
				System.out.println(einTeilnehmer.getTeilnehmerNr()+" "+einTeilnehmer.getVorName()+" "+einTeilnehmer.getNachName());
			}
		}
		

		teilnehmerZumKursAnmelden.addTeilnehmerToKurs(kursNr, einTeilnehmerA);
		
		
	}

}
