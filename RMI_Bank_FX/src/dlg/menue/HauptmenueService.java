package dlg.menue;

import awk.kontenverwaltung.factory.IKontenverwaltungFactory;
import awk.kontenverwaltung.factory.impl.KontenverwaltungFactory;
import awk.kontenverwaltung.usecase.IKontenPflegen;
import awk.kontenverwaltung.usecase.IKontobewegungBuchen;
import awk.kundenverwaltung.factory.IKundenverwaltungFactory;
import awk.kundenverwaltung.factory.impl.KundenverwaltungFactory;
import awk.kundenverwaltung.usecase.IKundenPflegen;
import awk.kundenverwaltung.usecase.IKundenSuchen;
import awk.kundenverwaltung.usecase.IKundenlisteErstellen;


public class HauptmenueService {

	private static IKundenverwaltungFactory kundenvf;
	private static IKontenverwaltungFactory kontenvf;
	
	private static IKundenPflegen kundenPflegen;
	private static IKundenSuchen kundenSuchen;
	private static IKundenlisteErstellen kundenlisteErstellen;
	private static IKontenPflegen kontenPflegen;
	private static IKontobewegungBuchen kontobewegungBuchen;
	
	public HauptmenueService() {
		/* 1. Implementierung der Komponenten des Anwendungskerns aus Factory beziehen */
		 kundenvf = new KundenverwaltungFactory();
		 kontenvf = new KontenverwaltungFactory();
		
		/* 2. Implementierung der benoetigten Use Cases beziehen */
		 kundenPflegen = kundenvf.getKundenPflegen();
		 kundenSuchen = kundenvf.getKundenSuchen();
		 kundenlisteErstellen = kundenvf.getKundenlisteErstellen();
		
		 kontenPflegen = kontenvf.getKontenPflegen();
		 kontobewegungBuchen = kontenvf.getKontobewegungBuchen();
	}
	
	
	public static IKundenPflegen getKundenPflegen() {
		return kundenPflegen;
	}

	public static IKundenSuchen getKundenSuchen() {
		return kundenSuchen;
	}

	public static IKundenlisteErstellen getKundenlisteErstellen() {
		return kundenlisteErstellen;
	}

	public static IKontobewegungBuchen getKontobewegungBuchen() {
		return kontobewegungBuchen;
	}

	public static IKontenPflegen getKontenPflegen() {
		return kontenPflegen;
	}
	
	
}
