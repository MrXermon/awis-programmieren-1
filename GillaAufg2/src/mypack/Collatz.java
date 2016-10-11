/**
 * Jan Gilla
 * 17.09.2016
 * Berechnung der Collatz Zahlen im definierten Bereich und verschiedener Kenngroessen.
 */

package mypack;

public class Collatz {

	public static void main(String[] args) {
		final double ENDE = 10;

		/**
		 * Variablen fuer Performance
		 */
		double laenge, element, groesse;
		/**
		 * Variablen zur Berechnung der maximalen Kettenlaenge
		 */
		double maxLaenge = 0;
		double maxLaengeBei = 0;

		/**
		 * Variablen zur Berechnung des Hoechsten Elements
		 */
		double maxElemente = 0;
		double maxElementeBei = 0;

		/**
		 * Variablen zur Berechnung der relativen Groesse
		 */
		double maxRelGroesse = 0;
		double maxRelGroesseBei = 0;

		/**
		 * Variablen zur Berechnugn der laengsten Laenge
		 */
		double vermutung = 0;
		double vermutungAnzahl = 0;
		double suche = 0;
		double sucheAnzahl = 0;

		/**
		 * Ausgabe der Folge mit Startwert 13
		 */
		folge(13, 0);

		/**
		 * Berechnung der Kennwerte 1-3
		 */
		for (int i = 1; i <= ENDE; i++) {

			/**
			 * Berechnung der Kennzahlen zur Kettenlaenge i
			 */
			laenge = folge(i, 1);
			element = folge(i, 2);
			groesse = folge(i, 3);

			/**
			 * Kennzahl: Laengste Folge
			 */
			if (laenge > maxLaenge) {
				maxLaenge = laenge;
				maxLaengeBei = i;
			}

			/**
			 * Kennzahl: Hoechstes Element der Folge
			 */
			if ((element - i) > maxElemente) {
				maxElemente = element - i;
				maxElementeBei = i;
			}

			/**
			 * Kennzahl: Hoechste Relative Groesse
			 */
			if (groesse > maxRelGroesse) {
				maxRelGroesse = groesse;
				maxRelGroesseBei = i;
			}

		}

		System.out.println("Maximale Laenge: " + (int) maxLaenge + " bei n = " + (int) maxLaengeBei);
		System.out.println(
				"Maximales Element: " + (int) (maxElemente + maxElementeBei) + " bei n = " + (int) maxElementeBei);
		System.out.println("Maximale relative Groesse: " + Math.round(maxRelGroesse * 100) / 100d + " bei n = "
				+ (int) maxRelGroesseBei);

		/**
		 * Kennzahl: Haufigste Kettenlaenge
		 */
		for (int j = 1; j <= (int) maxLaenge; j++) {
			suche = j;
			sucheAnzahl = 0;

			for (int i = 1; i <= ENDE; i++) {
				if (folge(i, 1) == suche)
					sucheAnzahl++;
			}

			if (sucheAnzahl > vermutungAnzahl) {
				vermutungAnzahl = sucheAnzahl;
				vermutung = suche;
			}

		}

		System.out.println("Am haeufigsten kommt die Kettenlaenge " + (int) vermutung + " vor, und zwar "
				+ (int) vermutungAnzahl + " mal");

	}

	/**
	 * Berechnung der naechsten Zahl der Collatzfolge
	 * 
	 * @param n
	 * @return
	 */
	public static double schritt(double n) {
		if (n != 1.0) {
			if (n % 2.0 == 0) {
				/** Fall 1, gerade Zahl */
				n = n / 2.0;
			} else {
				/** Fall 2, ungerade Zahl */
				n = (3 * n) + 1;
			}
		}
		return n;
	}

	/**
	 * Berechnung der Gesamten Collatzfolge
	 * 
	 * @param start
	 * @param rueckgabe
	 *            0: Ausgabe, 1: Kettenlaenge, 2: Hoechstes, 3: Rel. Groesse
	 * @return
	 */
	public static double folge(double start, int rueckgabe) {
		double n = start;
		double elemente = 1;
		double hoechstes = 0;
		double relativ = 0;
		boolean ende = false;

		if (rueckgabe == 0)
			System.out.print((int) n + " -> ");

		do {
			if (n != 1.0) {
				n = schritt(n);
				elemente++;
				if (rueckgabe == 0) {
					if (n != 1.0) {
						System.out.print((int) n + " -> ");
					} else {
						System.out.println(1);
					}
				}
			} else {
				ende = true;
			}

			if (n > hoechstes) {
				hoechstes = n;
			}
		} while (!ende);

		relativ = hoechstes / start;

		switch (rueckgabe) {
		case 1:
			return elemente;
		case 2:
			return hoechstes;
		case 3:
			return relativ;
		default:
			break;
		}
		return 0;
	}

}
