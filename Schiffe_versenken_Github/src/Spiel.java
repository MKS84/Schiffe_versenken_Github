import java.util.Scanner;

public abstract class Spiel {

	public static Flotte aktuelleFlotte = null;
	public static Spielfeld aktuellesSpielfeld = null;

	public static void ausfuehren(Flotte spielerEins, Flotte spielerZwei, Spielfeld spielfeldSpielerEins,
			Spielfeld spielfeldSpielerZwei) {

	}

	public static void spielStart(Flotte flotteEins, Flotte flotteZwei, Spielfeld spielfeldEins,
			Spielfeld spielfeldZwei) {

		aktuelleFlotte = flotteEins;
		aktuellesSpielfeld = spielfeldEins;

		System.out.println(
				"Willkommen beim Spiel Schiffeversenken\n\nInstruktionen:\nDas Spiel besteht aus 2 Phasen. In der ersten Phase, setzt jeder Spieler\n"
						+ "seine Schiffe auf dem Spielbrett (4 Zerstoerer, 3 Kreuzer, 2 Flugzeugtraeger). In der zweiten Phase,\n"
						+ "versuchen die Spieler abwechselnd die gegnerischen Schiffe zu bombardieren. Der Spieler dem es als erster gelingt, alle Schiffe seines Gegners\n"
						+ "zu versenken hat die Runde gewonnen.\n\nViel Spass!!!\n");

//		System.out.println("\nSpiel beginnen? (J/N)");
//		Scanner input = new Scanner(System.in);
//		char temp = input.next().charAt(0);
//		input.close();

		System.out.println(aktuelleFlotte.spielerName + ", setze deine Schiffe!\n");

		setzeSchiff();

		swapPlayer(flotteEins, flotteZwei, spielfeldEins, spielfeldZwei);

		System.out.println(aktuelleFlotte.spielerName + ", setze deine Schiffe!\n");

		setzeSchiff();

		swapPlayer(flotteEins, flotteZwei, spielfeldEins, spielfeldZwei);

		aktuellesSpielfeld.ausgeben(true, aktuelleFlotte);

		System.out.println("Alle Schiffe sind platziert. Zeit etwas zu bombardieren!!!");

		System.out.println(aktuelleFlotte.spielerName + " , du bist dran!");

	}

	public static void setzeSchiff() {

		int spalteX = 0;
		int reiheY = 0;
		char orientierung = ' ';

		Scanner input = new Scanner(System.in);

		while (aktuelleFlotte.anzahl != aktuelleFlotte.limit) {

			aktuellesSpielfeld.ausgeben(true, aktuelleFlotte);

			System.out.println("Bitte geben Sie die Spalte(X-Position) der Anfangskoordinaten des Schiffes an");
			spalteX = input.nextInt();

			System.out.println("Bitte geben Sie die Reihe(Y-Position) der Anfangskoordinaten des Schiffes an");
			reiheY = input.nextInt();

			System.out.println(
					"Bitte geben Sie an ob das Schiff vertikal oder horizontal ausgerichtet werden soll(v oder h) ");
			orientierung = input.next().charAt(0);

			if (aktuelleFlotte.limit3 == 0 && aktuelleFlotte.limit4 == 0) {

				aktuelleFlotte.neuesSchiff(new Schiff(5, spalteX, reiheY, orientierung));
				aktuelleFlotte.limit5--;

			} else if (aktuelleFlotte.limit3 == 0) {

				aktuelleFlotte.neuesSchiff(new Schiff(4, spalteX, reiheY, orientierung));
				aktuelleFlotte.limit4--;

			} else {

				aktuelleFlotte.neuesSchiff(new Schiff(3, spalteX, reiheY, orientierung));
				aktuelleFlotte.limit3--;

			}

			aktuellesSpielfeld.hinzufuegen(aktuelleFlotte);

		}
		aktuellesSpielfeld.ausgeben(true, aktuelleFlotte);
		// input.close();

	}

	/**
	 * Die Methode tauscht die Flotten- und Spielfeld-Objekte des aktuellen Spielers
	 * und des aktuellen Spielfeldes.
	 * 
	 * @author Markus Kraft
	 * 
	 * @version 3.0 (25.01.2020, 16:05)
	 * 
	 * @param flotteEins
	 * @param flotteZwei
	 * @param spielfeldEins
	 * @param spielfeldZwei
	 */
	public static void swapPlayer(Flotte flotteEins, Flotte flotteZwei, Spielfeld spielfeldEins,
			Spielfeld spielfeldZwei) {

		if (aktuelleFlotte == flotteEins) {
			Flotte temp1 = aktuelleFlotte;
			aktuelleFlotte = flotteZwei;
			flotteEins = temp1;

			Spielfeld temp2 = aktuellesSpielfeld;
			aktuellesSpielfeld = spielfeldZwei;
			spielfeldEins = temp2;

		} else if (aktuelleFlotte == flotteZwei) {
			Flotte temp1 = aktuelleFlotte;
			aktuelleFlotte = flotteEins;
			flotteZwei = temp1;

			Spielfeld temp2 = aktuellesSpielfeld;
			aktuellesSpielfeld = spielfeldEins;
			spielfeldZwei = temp2;
		}

	}



	public static void bombardieren(Spielfeld spielfeld, int x, int y) {
		if (spielfeld.koordinaten[x][y] == '#') {
// ja->@
//nein->X
		}
	}

}