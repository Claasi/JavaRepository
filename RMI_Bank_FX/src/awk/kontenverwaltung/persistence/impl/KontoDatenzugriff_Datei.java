package awk.kontenverwaltung.persistence.impl;
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
import awk.kontenverwaltung.entity.internal.Konto;
import awk.kontenverwaltung.persistence.IKontoDatenzugriff;

public class KontoDatenzugriff_Datei implements IKontoDatenzugriff{	
	
	public void kontendatenSpeichern(Collection<Konto> kontendaten) throws DatenhaltungsException {
		ObjectOutputStream file = null;
		try {
			file = new ObjectOutputStream (new FileOutputStream ("konten.bin"));
		} catch (FileNotFoundException e) {
			throw new DatenhaltungsException();
		} catch (IOException e) {
			throw new DatenhaltungsException();
		}
		
		try {
			for (Konto einKonto:kontendaten)
				file.writeObject(einKonto);
			} catch (IOException e1) {
					throw new DatenhaltungsException();	
				}
			
		try {
			file.close();
		} catch (IOException e) {
			throw new DatenhaltungsException();
		}
	}
	
	public Collection<Konto> kontendatenLesen() throws DatenhaltungsException{
		Collection<Konto> kontendaten = new ArrayList<Konto>();
		ObjectInputStream file = null;
		Konto einKonto;
		try {
			file = new ObjectInputStream(new FileInputStream("konten.bin"));
		} catch (FileNotFoundException e1) {
//			throw new DatenhaltungsException();
			return kontendaten;
		} catch (IOException e1) {
			throw new DatenhaltungsException();
		}
		
		try {
			while (true) {
				einKonto = (Konto) file.readObject();
				kontendaten.add(einKonto);
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
		
		return kontendaten;
	}

}
