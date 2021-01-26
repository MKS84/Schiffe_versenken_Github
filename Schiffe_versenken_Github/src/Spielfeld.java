
/**
 * 
 * Die Klasse Spielfeld stellt das Spielfeld von Schiffe versenken dar. Es
 * besteht aus 11 Zeilen und Spalten, die durch ein char Array der Groesse 11x11
 * erzeugt wird. Das Spielfeld selbst hat 10x10 Felder, die jeweils 1. Zeile und
 * Spalte geben die Koordinaten aus.
 * 
 * @author Markus
 * @version 4.0 (26.01.2021, 11:10)
 * 
 * @param zeilen      Anzahl der Zeilen des Spielfeldes
 * @param spalten     Anzahl der Spalten des Spielfeldes
 * @param koordinaten char Array mit den Koordinaten des Spielfeldes, das die
 *                    Größe Zeilen x Spalten hat.
 * @param spielerName Name des dem Spielfeld zugeordneten Spielers.
 * 
 */

public class Spielfeld {

	// Spielfeldgroesse auf 10x10 festgelegt. In der zusätzlichen Zeile/Spalte
	// werden die Koordnatein angezeigt.
	int zeilen = 11;
	int spalten = 11;
	char[][] koordinaten = null;

	public Spielfeld(int zeilen, int spalten) {

		// Ein Spielfeld erhaelt ein char-Array der Groesse 11x11, in dem neben den
		// Koordinaten auch die Stati der einzelnen Felder eingetragen werden sollen.
		this.zeilen = zeilen;
		this.spalten = spalten;
		this.koordinaten = new char[zeilen][spalten];

		for (int z = 0; z < this.koordinaten.length; z++) {
			for (int s = 0; s < this.koordinaten.length; s++) {
				this.koordinaten[z][s] = '.';
			}
		}

	}

	// TODO
	// Anzeigen, wo man es schon versucht hat und wo man getroffen hat.
	// Miss = X
	// Treffer = @
	// eigenes Schiff = # (nur beim Setzen der Schiffe)

	/**
	 * 
	 * Die Methode ausgeben gibt das Spielfeld einer Flotte aus. Dabei kann man
	 * entscheiden, ob die Schiffe einer Flotte bei der Ausgabe angezeigt werden
	 * sollen.
	 * 
	 * @author Markus
	 * @version 3.2 (25.01.2021, 11:48)
	 * @param schiffeAnzeigen Entscheidet, ob die Position der Schiffe einer Flotte
	 *                        bei der Ausgabe angezeigt werden. Dies ist nur beim
	 *                        Setzen der Schiffe notwendig. true = Schiffe anzeigen,
	 *                        false = Schiffe verbergen
	 */

	public void ausgeben(Boolean schiffeAnzeigen, Flotte flotte) { // TODO Boolean aktiverSpieler

		System.out.println("Spielfeld " + flotte.spielerName + "\n");

		for (int z = 1; z < this.zeilen; z++) {

			if (z == 0) {
				System.out.print("  ");
			} else {
				System.out.print((z+1) + " ");
			}

			for (int s = 1; s < this.spalten; s++) {

				if (z == 0) {
					System.out.print(" " + (char) ('A' ) + " ");

				} else {
					if (this.koordinaten[z][s] == '#' && schiffeAnzeigen == false) {
						System.out.print(" " + ' ' + " ");
					} else {
						System.out.print(" " + this.koordinaten[z][s] + " ");
					}
				}

			}
			System.out.println("\n");
		}
	}

	/**
	 * 
	 * Die Methode hinzufuegen fuegt dem aufrufenden Spielfeld-Objekt die
	 * Schiff-Objekte des uebergebenen Flotten-Objekts hinzu. Dabei werden die
	 * Koordinaten-Arrays der einzelnen Schiffe ausgelesen und in das
	 * Koordinaten-Array des Spielfeldes kopiert.
	 * 
	 * In den Koordinaten-Arrays werden folgende Stati durch char-Variablen
	 * dargestellt. <br>
	 * X = Miss <br>
	 * @ = Treffer <br>
	 * # = Schiff
	 * 
	 * @author Markus
	 * @version 3.2 (25.01.2021, 11:48)
	 * 
	 * @param flotte Das übergebene Flotten-Objekt, aus welchem die Koordinaten für
	 *               das Spielfeld ausgelesen werden sollen.
	 */

	public void hinzufuegen(Flotte flotte) {

		// Jedes Schiff einer Flotte wird nacheinander aufgerufen.
		for (int i = 0; i < flotte.schiffe.length; i++) {

			if (flotte.schiffe[i] != null) {
				// Zeilenweiser Aufbau des Spielfeldes.
				for (int z = 0; z < zeilen; z++) {

					// Spaltenweiser Eintrag des jeweiligen Schiffskoordinaten in das Spielfeld.
					for (int s = 0; s < spalten; s++) {

						if (flotte.schiffe[i].koordinaten[z][s] == '#') {
							this.koordinaten[z][s] = flotte.schiffe[i].koordinaten[z][s];
						}
					}
				}
			}
		}
	}
}
