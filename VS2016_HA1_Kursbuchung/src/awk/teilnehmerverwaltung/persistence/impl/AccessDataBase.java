package awk.teilnehmerverwaltung.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import awk.DatenhaltungsException;
import awk.persistence.ConnectDataBase;
import awk.teilnehmerverwaltung.entity.TeilnehmerTO;
import awk.teilnehmerverwaltung.persistence.IAccessDataBase;

public class AccessDataBase implements IAccessDataBase{
	
	public Collection<TeilnehmerTO> getTeilnehmerListe() throws DatenhaltungsException {
		Connection aConnection = ConnectDataBase.ConnectDB();
		ResultSet resultSet;
		Collection<TeilnehmerTO> teilnehmerTOListe = new ArrayList<TeilnehmerTO>();
		try{			
			resultSet =	ConnectDataBase.executeQueryStatement(aConnection,"SELECT TEILNEHMER_NR,TEILNEHMER_VORNAME,TEILNEHMER_NACHNAME FROM HA1_TEILNEHMER");
				
			while (resultSet.next()) {
				TeilnehmerTO einTeilnehmerTO = new TeilnehmerTO();
				einTeilnehmerTO.setTeilnehmerNr(resultSet.getInt("TEILNEHMER_NR"));
				einTeilnehmerTO.setVorName(resultSet.getString("TEILNEHMER_VORNAME"));
				einTeilnehmerTO.setNachName(resultSet.getString("TEILNEHMER_NACHNAME"));					
				
				teilnehmerTOListe.add(einTeilnehmerTO);
				System.out.println("Teilnehmer " + einTeilnehmerTO.getVorName() + "wurde der Liste hinzugefügt!");
			}
			
			for (TeilnehmerTO einTeilnehmerTO : teilnehmerTOListe) {
			resultSet = ConnectDataBase.executeQueryStatement(aConnection, 
						"SELECT TEILNEHMER_NR,TEILNEHMER_VORNAME,TEILNEHMER_NACHNAME " +
						"FROM VS2016_24.HA1_TEILNEHMER " +
						"WHERE TEILNEHMER_NR = " + einTeilnehmerTO.getTeilnehmerNr());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatenhaltungsException();
		} finally {
			ConnectDataBase.closeConnection(aConnection);
		}
		System.out.println("Anzahl geladener Teilnehmer:"+teilnehmerTOListe.size());
	return teilnehmerTOListe;
	}

	
	public void saveTeilnehmerListe(Collection<TeilnehmerTO> teilnehmerTOListe) throws DatenhaltungsException {
		Connection aConnection = ConnectDataBase.ConnectDB();
		
		try {
			ConnectDataBase.executeUpdateStatement(aConnection, "DELETE FROM VS2016_24.HA1_TEILNEHMER ");
			for (TeilnehmerTO einTeilnehmerTO : teilnehmerTOListe) {
				ConnectDataBase.executeUpdateStatement(
							aConnection, 
							"INSERT INTO VS2016_24.HA1_TEILNEHMER VALUES ( " +
							"'"+ einTeilnehmerTO.getTeilnehmerNr() + "'," +
							"'"+ einTeilnehmerTO.getVorName() + "'," +
							"'"+ einTeilnehmerTO.getNachName() +"'"+")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatenhaltungsException();
		} finally {
			ConnectDataBase.closeConnection(aConnection);
		}
	}

}
