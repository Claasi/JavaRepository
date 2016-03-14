package awk.kundenverwaltung.persistence.impl;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import awk.DatenhaltungsException;
import awk.kundenverwaltung.entity.internal.Geschaeftskunde;
import awk.kundenverwaltung.entity.internal.Kunde;
import awk.kundenverwaltung.entity.internal.Privatkunde;
import awk.kundenverwaltung.persistence.IKundenDatenzugriff;


public class KundenDatenzugriff_Datei implements IKundenDatenzugriff{	
	
	public void kundendatenSpeichern(Collection<Kunde> kundendaten) throws DatenhaltungsException {
		ObjectOutputStream file = null;
		try {
			file = new ObjectOutputStream (new FileOutputStream ("kunden.bin"));
		} catch (FileNotFoundException e) {
			throw new DatenhaltungsException();
		} catch (IOException e) {
			throw new DatenhaltungsException();
		}
		
		try {
			for (Kunde einKunde:kundendaten){
				einKunde.print();
				file.writeObject(einKunde);
				}
			} catch (IOException e1) {
					throw new DatenhaltungsException();	
				}
			
		try {
			file.close();
		} catch (IOException e) {
			throw new DatenhaltungsException();
		}
	}
	
	public Collection<Kunde> kundendatenLesen() throws DatenhaltungsException{
		Collection<Kunde> kundendaten = new ArrayList<Kunde>();
		ObjectInputStream file = null;
		Kunde einKunde = null;
		try {
			file = new ObjectInputStream(new FileInputStream("kunden.bin"));
		} catch (FileNotFoundException e1) {
			System.out.println("Fehler 1");
			throw new DatenhaltungsException();
//			return kundendaten;
		} catch (IOException e1) {
			throw new DatenhaltungsException();
		}
		
		Object obj;
		try {
			while (true) {
				obj = file.readObject();
				System.out.println("Klasse: "+obj.getClass());
				
				if (obj instanceof Privatkunde)
					einKunde = (Privatkunde) obj;
				else 
					einKunde = (Geschaeftskunde) obj;

				
				kundendaten.add(einKunde);
			}
		}
		catch (EOFException e) {
		}
		catch (IOException e) {
			throw new DatenhaltungsException();
		}
		catch (ClassNotFoundException e) {
			throw new DatenhaltungsException();
		}
		finally {
			try {
				file.close();
			} catch (IOException e) {
				throw new DatenhaltungsException();
			}
		}
		
		return kundendaten;
	}

}
