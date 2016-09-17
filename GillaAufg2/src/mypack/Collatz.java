/**
 * Jan Gilla
 * 17.09.2016
 * Berechnung der Collatz Zahlen im definierten Bereich und verschiedener Kenngroessen.
 */

package mypack;

import java.text.*;

public class Collatz {

	public static void main(String[] args) {
		
		final double STARTWERT = 10;
		
		double maxLaenge = 0, maxLaengeBei = 0, maxElemente = 0, maxElementeBei = 0, maxRelGroesse = 0,
				maxRelGroesseBei = 0;
		double n, aktuellElemente, aktuellHoechstes, aktuellRelGroesse;
		boolean weiter = true;

		DecimalFormat dezFormat = new DecimalFormat("#0.00");

		for (int i = 1; i <= STARTWERT; i++) {
			weiter = true;
			n = i;
			aktuellElemente = 0;
			aktuellHoechstes = i;
			aktuellRelGroesse = 0;
			do {
				if (n % 2.0 == 0) {
					n = n / 2.0;
				} else {
					n = (3 * n) + 1;
				}
				if ((int) n == 1) {
					aktuellElemente++;
					weiter = false;
				} else {
					aktuellElemente++;
				}
				if (n > aktuellHoechstes)
					aktuellHoechstes = n;
			} while (weiter);
			aktuellRelGroesse = aktuellHoechstes / i;

			if (aktuellElemente > maxLaenge) {
				maxLaenge = aktuellElemente;
				maxLaengeBei = i;
			}
			if ((aktuellHoechstes - i) > maxElemente) {
				maxElemente = aktuellHoechstes - i;
				maxElementeBei = i;
			}
			if (aktuellRelGroesse > maxRelGroesse) {
				maxRelGroesse = aktuellRelGroesse;
				maxRelGroesseBei = i;
			}
		}

		System.out.println("Maximale Laenge: " + (int) maxLaenge + " bei n = " + (int) maxLaengeBei);
		System.out.println(
				"Maximales Element: " + (int) (maxElemente + maxElementeBei) + " bei n = " + (int) maxElementeBei);
		System.out.println(
				"Maximale relative Groesse: " + dezFormat.format(maxRelGroesse) + " bei n = " + (int) maxRelGroesseBei);
	}

}
