package awk.teilnehmerverwaltung.usecase.impl;

import awk.AnwendungskernException;
import awk.kursverwaltung.entity.KursTO;
import awk.kursverwaltung.entity.internal.Kurs;
import awk.kursverwaltung.factory.IKursverwaltungLocalFactory;
import awk.kursverwaltung.factory.impl.KursverwaltungLocalFactory;
import awk.kursverwaltung.usecase.IKursSuchen;
import awk.kursverwaltung.usecase.impl.KursManager;
import awk.teilnehmerverwaltung.entity.internal.Teilnehmer;
import awk.teilnehmerverwaltung.usecase.ITeilnehmerZumKursAnmelden;

public class TeilnehmerZumKursAnmelden implements ITeilnehmerZumKursAnmelden{

	public void addTeilnehmerToKurs(int kursNr, Teilnehmer einTeilnehmer) throws AnwendungskernException {
		
		KursManager kursManagement = KursManager.getKursManager();
		
		Kurs einKurs = kursManagement.getKursByNumber(kursNr);
		
		einKurs.addTeilnehmer(einTeilnehmer);
		kursManagement.saveKursListe();
	}
	
	public int addTeilnehmer(int kursNr, String vorName, String nachName) throws AnwendungskernException{
		
		TeilnehmerManager teilnehmerManager = TeilnehmerManager.getTeilnehmerManager();
		
		IKursverwaltungLocalFactory kursVerwaltungLocal = new KursverwaltungLocalFactory();
		IKursSuchen kursInformation = kursVerwaltungLocal.useCaseKursSuchen();
		
		KursTO einKursTO = kursInformation.kursTOsuchenByNr(kursNr);
		
		if(einKursTO == null)
			return 0;
		else{
			int max = teilnehmerManager.naechsteNummerErmitteln();
			
			Teilnehmer einTeilnehmer = new Teilnehmer(max+1, vorName, nachName);
			teilnehmerManager.addTeilnehmerToCollectionAndDB(einTeilnehmer);
			addTeilnehmerToKurs(kursNr, einTeilnehmer);
			
			return einTeilnehmer.getTeilnehmerNr();
		} 
	}
}
