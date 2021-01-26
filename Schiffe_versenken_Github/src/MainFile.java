
/**
 * 
 * @author Thomas Weisel
 *
 */
public class MainFile {
	
	public static void main(String[] args) {

		final int ZEILEN = 11;
		final int SPALTEN = 11;
		
		int SPALTEN_test = 11;
	
		int variable_test = 42;
		
		// Markus flottengroesse entfernt
		Flotte flotteEins = new Flotte("Spieler 1");
		Flotte flotteZwei = new Flotte("Spieler 2");
		
		// Halli Hallo
		//ölhjkjhlkhglhkgljh
		
		// Neuer Text
		// Kommentar für Konflikt
		
		// Markus: neuer Text für Konflikt
	
		// Markus flotten entfernt
		Spielfeld spielfeldEins = new Spielfeld(ZEILEN, SPALTEN);
		Spielfeld spielfeldZwei = new Spielfeld(ZEILEN, SPALTEN);
				
		System.out.println("Die Antwort ist "+variable_test);
		System.out.println("Aber was ist die Frage?");
		
		Spiel.spielStart(flotteEins, flotteZwei, spielfeldEins, spielfeldZwei);
		
		System.out.println("Hallo");
		
		Spiel.setzeSchiff();
	
		Spiel.ausfuehren(flotteEins, flotteZwei, spielfeldEins, spielfeldZwei);
		
		//Spiel.spielStart(flotteEins, spielfeldEins);

		

	}

}
