/**
 * Jan Gilla
 * 17.09.2016
 * Berechnung der Collatz Zahlen im definierten Bereich und verschiedener Kenngroessen.
 */

package mypack;

import java.text.DecimalFormat;

public class Collatz {

	public static void main(String[] args) {
		final double startwert = 10;

		double maxLaenge = 0; // Maximale Anzahl der Elemente zum Vergleichen
		double maxLaengeBei = 0; // Speichern des zugehoergien n's

		double maxElemente = 0; // Maximaler Abstand zum Startwert zum
								// Vergleichen
		double maxElementeBei = 0; // Speichern des zugehoergien n's

		double maxRelGroesse = 0; // Maximale Relative Groesse zum Vergleichen
		double maxRelGroesseBei = 0; // Speichern des zugehoergien n's

		double n; // Zur Berechnung der Collatz-Folge verwendet
		double aktuellElemente; // Zaehler der Elemente der aktuellen Folge
		double aktuellHoechstes; // Hoechstes Element der aktuellen Folge
		double aktuellRelGroesse; // Relative Groesse der aktuellen Folge
		boolean weiter = true; // Beendet die Schleife, sobald das Ende erreicht
								// ist

		for (int i = 1; i <= startwert; i++) {
			weiter = true;
			n = i;
			aktuellElemente = 0;
			aktuellHoechstes = i;
			aktuellRelGroesse = 0;
			do {
				if ((int) n == 1) {
					/** Folgenende erreicht */
					weiter = false;
				} else {
					if (n % 2.0 == 0) {
						/** Fall 1, gerade Zahl */
						n = n / 2.0;
					} else {
						/** Fall 2, ungerade Zahl */
						n = (3 * n) + 1;
					}
					aktuellElemente++;
				}

				if (n > aktuellHoechstes) {
					aktuellHoechstes = n;
				}
			} while (weiter);
			aktuellRelGroesse = aktuellHoechstes / i;

			/** Vergleiche zur Determination der Kennzahl: Laengste Folge */
			if (aktuellElemente > maxLaenge) {
				maxLaenge = aktuellElemente;
				maxLaengeBei = i;
			}
			/**
			 * Vergleiche zur Determination der Kennzahl: Hoechstes Element der
			 * Folge
			 */
			if ((aktuellHoechstes - i) > maxElemente) {
				maxElemente = aktuellHoechstes - i;
				maxElementeBei = i;
			}
			/**
			 * Vergleiche zur Determination der Kennzahl: Hoechste Relative
			 * Groesse
			 */
			if (aktuellRelGroesse > maxRelGroesse) {
				maxRelGroesse = aktuellRelGroesse;
				maxRelGroesseBei = i;
			}

		}

		ausgabe(maxLaenge, maxLaengeBei, maxElemente, maxElementeBei, maxRelGroesse, maxRelGroesseBei);
	}

	public static void ausgabe(double l, double lBei, double e, double eBei, double r, double rBei) {
		DecimalFormat dezFormat = new DecimalFormat("#0.00");
		System.out.println("Maximale Laenge: " + (int) l + " bei n = " + (int) lBei);
		System.out.println("Maximales Element: " + (int) (e + eBei) + " bei n = " + (int) eBei);
		System.out.println("Maximale relative Groesse: " + dezFormat.format(r) + " bei n = " + (int) rBei);
	}
}
