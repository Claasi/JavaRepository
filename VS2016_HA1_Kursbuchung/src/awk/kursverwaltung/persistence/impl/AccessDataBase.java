package awk.kursverwaltung.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import awk.DatenhaltungsException;
import awk.kursverwaltung.entity.KursTO;
import awk.kursverwaltung.persistence.IAccessDataBase;
import awk.persistence.ConnectDataBase;

public class AccessDataBase implements IAccessDataBase{
	
	public KursTO getKursInfo() throws DatenhaltungsException {
		
		Connection aConnection = ConnectDataBase.ConnectDB();
		ResultSet resultSet;
		KursTO einKursTO = null;
		
		try{
			resultSet = ConnectDataBase.executeQueryStatement(aConnection,
					"SELECT KURS_NR,KURS_NAME,KURS_PLAETZE " +
					"FROM HA1_KURS");
			
			while(resultSet.next()){
				einKursTO = new KursTO();
				einKursTO.setKursNr(resultSet.getInt("KURS_NR"));
				einKursTO.setKursName(resultSet.getString("KURS_NAME"));
				einKursTO.setAnzahlTeilnehmer(resultSet.getInt("KURS_PLAETZE"));
		
				System.out.println("\nKurs-Nr.:\t"+ einKursTO.getKursNr() + "\nBezeichnung:\t" + einKursTO.getKursName() + "\n\nerfolgreich geladen!\n");
			};
		}catch (SQLException e){
			e.printStackTrace();
			throw new DatenhaltungsException();
		}finally {
			ConnectDataBase.closeConnection(aConnection);
		}
		return einKursTO;
	}
	
	public void updateKursInfo(int kursNr, String kursName, int anzahlTeilnehmer) throws DatenhaltungsException{
		Connection aConnection = ConnectDataBase.ConnectDB();
		String updateStatement = "UPDATE VS2016_24.HA1_KURS " +
									"SET " +
									"KURS_NAME = '"+kursName+"', " +
									"KURS_PLAETZE = '"+anzahlTeilnehmer+"' " +
									"WHERE KURS_NR = '"+kursNr+"'";
		try{
			ConnectDataBase.executeUpdateStatement(aConnection, updateStatement);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDataBase.closeConnection(aConnection);
		}
	}
	
	public void speichereKurs(int kursNr, String kursName, int anzahlTeilnehmer) throws DatenhaltungsException{
		Connection aConnection = ConnectDataBase.ConnectDB();
		String updateStatement = "INSERT INTO VS2016_24.HA1_KURS (KURS_NR, KURS_NAME, KURS_PLAETZE)"
								+ " VALUES ('" + kursNr + "', '" + kursName + "', '" + anzahlTeilnehmer +"')";
		try{
			ConnectDataBase.executeUpdateStatement(aConnection, updateStatement);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDataBase.closeConnection(aConnection);
		}
	}
	
	
	/*
	public Collection<KursTO> getKursListe() throws DatenhaltungsException {
		Connection aConnection = ConnectDataBase.ConnectDB();
		ResultSet resultSet;
		Collection<KursTO> kursTOListe = new ArrayList<KursTO>();
			
		try{			
			resultSet =	ConnectDataBase.executeQueryStatement(aConnection,"SELECT * FROM Tabellenname");
				
			while (resultSet.next()) {
				KursTO einKursTO = new KursTO();
				einKursTO.setKursNr(resultSet.getInt("columnlabel"));
				einKursTO.setKursName(resultSet.getString("columnlabel"));		
				einKursTO.setAnzahlTeilnehmer(resultSet.getInt("columnlabel"));				
				
				kursTOListe.add(einKursTO);
			}
			
		for (KursTO einKursTO:kursTOListe) {
			resultSet = 
					ConnectDataBase.executeQueryStatement(aConnection, 
						"SELECT * " +
						"FROM kundenverw_kontonummer " +
						"WHERE cusnumber = " + einKursTO.getKursNr());
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
		throw new DatenhaltungsException();
	} finally {
		ConnectDataBase.closeConnection(aConnection);
	}
	System.out.println("Anzahl geladener Kunden:"+kursTOListe.size());
	return kursTOListe;
	}
	*/
	
	
}