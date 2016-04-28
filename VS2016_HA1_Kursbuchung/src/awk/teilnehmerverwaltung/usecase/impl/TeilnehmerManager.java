package awk.teilnehmerverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.teilnehmerverwaltung.entity.TeilnehmerTO;
import awk.teilnehmerverwaltung.entity.internal.Teilnehmer;
import awk.teilnehmerverwaltung.persistence.IAccessDataBase;
import awk.teilnehmerverwaltung.persistence.impl.AccessDataBase;

public class TeilnehmerManager {
	
	public IAccessDataBase daoDB = new AccessDataBase();
	public Collection<Teilnehmer> teilnehmerListe = new ArrayList<Teilnehmer>();
	
	private static TeilnehmerManager teilnehmerManagement;
	
	public static TeilnehmerManager getTeilnehmerManager() throws AnwendungskernException{
		if(teilnehmerManagement == null){
			teilnehmerManagement = new TeilnehmerManager();
		}
		return teilnehmerManagement;
	}
	
	private TeilnehmerManager() throws AnwendungskernException{
		teilnehmerListe = new ArrayList<Teilnehmer>();
		this.teilnehmerLaden();
	}
	
	public void addTeilnehmerToCollectionAndDB(Teilnehmer einTeilnehmer) throws AnwendungskernException{
		this.teilnehmerListe.add(einTeilnehmer);
		this.saveTeilnehmerListe();
	}
	
	public void teilnehmerLaden() throws AnwendungskernException{
		Collection<TeilnehmerTO> teilnehmerTOListe;
		try {
			teilnehmerTOListe = daoDB.getTeilnehmerListe();
		} catch (DatenhaltungsException e){
			throw new AnwendungskernException();
		}
		this.teilnehmerListe.clear();
		for(TeilnehmerTO einTeilnehmerTO : teilnehmerTOListe)
			this.teilnehmerListe.add(einTeilnehmerTO.toTeilnehmer());
	}
	
	public Collection<Teilnehmer> getTeilnehmerListe(){
		return this.teilnehmerListe;
	}
	
	public void saveTeilnehmerListe () throws AnwendungskernException{
		Collection<TeilnehmerTO> teilnehmerTOListe = new ArrayList<TeilnehmerTO>();
		
		for(Teilnehmer einTeilnehmer : this.teilnehmerListe)
			teilnehmerTOListe.add(einTeilnehmer.toTeilnehmerTO());
		try {
			daoDB.saveTeilnehmerListe(teilnehmerTOListe);
		}catch (DatenhaltungsException e) {
			throw new AnwendungskernException();
		}
	}
	
	public int naechsteNummerErmitteln(){
		int max = 1;
			for( Teilnehmer einTeilnehmer : this.teilnehmerListe )
				if(einTeilnehmer.getTeilnehmerNr() > max)
					max = einTeilnehmer.getTeilnehmerNr();
		return max;
	}

}

