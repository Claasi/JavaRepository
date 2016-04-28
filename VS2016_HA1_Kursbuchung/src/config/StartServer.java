package config;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

import gui.StartMenueJavaClass;

public class StartServer {
	
	public static void main(String args[]) throws AccessException, RemoteException, NotBoundException{
	
		// Relevante Komponenten des AWK's aus der Factory erzeugen
//		IxRemoteFactory xRemoteFactory = new xRemoteFactory();
		
		// Benoetigte Use Cases mittels erzeugter Factory beziehen
//		IKursListeAnzeigenRemote xxyyzz = xRemoteFactory.useCasexxx;
//		ITeilnehmerZumKursAnmeldenRemote abcde = xRemoteFactory.useCasexxx;
		
		// Remote-Objekte extern verfuegbar machen
//		IKursListeAnzeigenRemote stubKursListeAnzeigenRemote = (IKursListeAnzeigenRemote) UnicastRemoteObject.exportObject(xxyyzz, 0);
//		ITeilnehmerZumKursAnmelden stubTeilnehmerZumKursAnmeldenRemote = (ITeilnehmerZumKursAnmelden) UnicastRemoteObject.exportObject(abcde, 0);
		
		
		// Namensdienst starten und Remote Objekte dort anmelden
		RemoteServer.setLog(System.out);
		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		Registry registry = LocateRegistry.getRegistry();
		
//		registry.rebind("kursListeAnzeigen", stubKursListeAnzeigenRemote);
//		registry.rebind("teilnehmerZumKursAnmelden", stubTeilnehmerZumKursAnmeldenRemote);
		
		StartMenueJavaClass awkService = null;
		awkService.main(args);
		
	}
}
