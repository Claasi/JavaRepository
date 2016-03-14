package konfiguration;

import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

import awk.autostamm.factory.IDogFactory;
import awk.autostamm.factory.impl.DogFactory;
import awk.autostamm.usecases.IDogAnlegen;

public class Server {
	
	public static void main (String args[]) throws AccessException, RemoteException {
	
		// Relevante Komponenten des AWK's aus der Factory erzeugen
		IDogFactory dogFactoryLocal = new DogFactory();

		// Benötigte Use Cases mittels erzeugter Factory beziehen
		IDogAnlegen dogAnlegenLocal = dogFactoryLocal.exeUCdogsAnlegen();
		
		// Objekte für Remote verfügbar machen
//		IDogAnlegenRemote stubDogAnlegenRemote =
//				(IDogAnlegenRemote) UnicastRemoteObject.exportObject(dogAnlegenRemote,0);
//		
//		// Namensdienst für RMI starten und Remoteobjekte anmelden	
//		RemoteServer.setLog(System.out);
//		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);	
//		Registry registry = LocateRegistry.getRegistry();
//			
//		// Use Cases einbinden
//		registry.rebind("dogAnlegen", stubDogAnlegenRemote);
		
		
		
	
	}

}
