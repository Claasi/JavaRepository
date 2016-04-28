package awk.teilnehmerverwaltung.persistence;

import java.util.Collection;

import awk.DatenhaltungsException;
import awk.teilnehmerverwaltung.entity.TeilnehmerTO;

public interface IAccessDataBase {
	
	public Collection<TeilnehmerTO> getTeilnehmerListe() throws DatenhaltungsException;
	public void saveTeilnehmerListe(Collection<TeilnehmerTO> teilnehmerTOListe) throws DatenhaltungsException;

}
