/**
 * Jan Gilla
 * 17.09.2016
 * Berechnug und Ausgabe einer linearen, Geometrisch-degressiven und Methodenwechsel Abschreibung
 */

package mypack;

import java.text.*;

public class Abschreibung {

	public static void main(String[] args) {
		final double anschkosten = 21000;
		final double prozentsatz = 20;
		final int nutzdauer = 7;

		double restBuchWert = anschkosten; // Aktueller Restbuchwert
		double abschreibung = 0; // Aktuelle Abschreibung
		double wechselJahr = 0; // Jahr ab dem gewechselt wird

		/** Start Lineare Abschreibung */
		System.out.println("Lineare Abschreibung:");
		zeileTitel();
		for (int j = 0; j < nutzdauer + 1; j++) {
			abschreibung = anschkosten / nutzdauer;
			restBuchWert = anschkosten - (j * anschkosten / nutzdauer);
			zeileAusgeben(j, abschreibung, restBuchWert, "");
		}

		/** Zuruecksetzen fuer Geometrisch-degressive Abschreibung */
		restBuchWert = anschkosten;
		abschreibung = 0;
		System.out.println("Geometrisch-degressive Abschreibung:");
		zeileTitel();
		for (int j = 0; j < nutzdauer + 1; j++) {
			if (j == 0) {
				abschreibung = 0;
			} else {
				abschreibung = restBuchWert * (prozentsatz / 100);
				restBuchWert -= abschreibung;
			}
			zeileAusgeben(j, abschreibung, restBuchWert, "");
		}

		/** Zuruecksetzen auf Methodenwechsel Abschreibung */
		restBuchWert = anschkosten;
		abschreibung = 0;
		wechselJahr = nutzdauer - (100 / prozentsatz) + 1;
		System.out.println("Methodenwechsel Abschreibung:");
		zeileTitel();
		for (int j = 0; j < nutzdauer + 1; j++) {
			if (j == 0) {
				/** Ausnahmewert fuer NULL */
				abschreibung = 0;
			}
			if (j > 0 && j <= wechselJahr) {
				/** Geometrisch-degressive Abschreibung */
				abschreibung = restBuchWert * prozentsatz / 100;
				restBuchWert -= abschreibung;
			} else if (j == wechselJahr + 1) {
				/** Berechnung der Abschreibung und Abzug im Wechseljahr */
				abschreibung = restBuchWert / (nutzdauer - j + 1);
				restBuchWert -= abschreibung;
			} else if (j > wechselJahr) {
				/** Lineare Abschreibung */
				restBuchWert -= abschreibung;
			}

			/** Ausgabebereich */
			if (j <= wechselJahr)
				zeileAusgeben(j, abschreibung, restBuchWert, "");
			else
				zeileAusgeben(j, abschreibung, restBuchWert, "Wechsel linear");
		}
	}

	/**
	 * Zeile passend formatieren und ausgeben.
	 * @param jhr
	 * 	Wert fuer die Spalte Jahr
	 * @param abschr
	 * 	Wert fuer die Spalte Abschreibung
	 * @param rbw
	 * 	Wert fuer die Spalte Restuchwert
	 * @param txt
	 * 	Wert, der ggf. an die Ausgabe angehaengt wird.
	 */
	public static void zeileAusgeben(int jhr, double abschr, double rbw, String txt) {
		DecimalFormat ausgFormat = new DecimalFormat("#,##0.00");
		System.out.println(" " + jhr + "\t " + String.format("%1$9s", ausgFormat.format(abschr)) + " EUR\t"
				+ String.format("%1$9s", ausgFormat.format(rbw)) + " EUR " + txt);
	}

	/**
	 * Funktion zur Ausgabe der Ueberschriften.
	 */
	public static void zeileTitel() {
		System.out.println("Jahr\tAbschreibung\tRestbuchwert");
	}

}
