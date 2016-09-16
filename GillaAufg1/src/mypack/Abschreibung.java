package mypack;

import java.text.*;

public class Abschreibung {

	public static void main(String[] args) {
		final double ANSCHKOSTEN = 21000;
		final double PROZENTSATZ = 20;
		final int NUTZDAUER = 7;

		double restBuchWert, abschreibung, wechselJahr;

		// Zuruecksetzen fuer Lineare Abschreibung
		restBuchWert = ANSCHKOSTEN;
		abschreibung = 0;
		System.out.println("Lineare Abschreibung:");
		zeileTitel();
		for (int j = 0; j < NUTZDAUER + 1; j++) {
			abschreibung = ANSCHKOSTEN / NUTZDAUER;
			restBuchWert = ANSCHKOSTEN - (j * ANSCHKOSTEN / NUTZDAUER);
			zeileAusgeben(j, abschreibung, restBuchWert, "");
		}

		// Zuruecksetzen fuer Geometrisch-degressive Abschreibung
		restBuchWert = ANSCHKOSTEN;
		abschreibung = 0;
		System.out.println("Geometrisch-degressive Abschreibung:");
		zeileTitel();
		for (int j = 0; j < NUTZDAUER + 1; j++) {
			if (j == 0) {
				abschreibung = 0;
			} else {
				abschreibung = restBuchWert * (PROZENTSATZ / 100);
				restBuchWert -= abschreibung;
			}
			zeileAusgeben(j, abschreibung, restBuchWert, "");
		}

		// Zuruecksetzen auf Methodenwechsel Abschreibung
		restBuchWert = ANSCHKOSTEN;
		abschreibung = 0;
		wechselJahr = NUTZDAUER - (100 / PROZENTSATZ) + 1;
		System.out.println("Geometrisch-degressive Abschreibung:");
		zeileTitel();
		for (int j = 0; j < NUTZDAUER + 1; j++) {
			if (j == 0) {
				// Ausnahmewert fuer NULL
				abschreibung = 0;
			}
			if (j > 0 && j <= wechselJahr) {
				// Geometrisch-degressive Abschreibung
				abschreibung = restBuchWert * PROZENTSATZ / 100;
				restBuchWert -= abschreibung;
			} else if (j == wechselJahr + 1) {
				// Berechnung der Abschreibung und Abzug im Wechseljahr
				abschreibung = restBuchWert / (NUTZDAUER - j + 1);
				restBuchWert -= abschreibung;
			} else if (j > wechselJahr) {
				// Lineare Abschreibung
				restBuchWert -= abschreibung;
			}

			// Ausgabebereich
			if (j <= wechselJahr)
				zeileAusgeben(j, abschreibung, restBuchWert, "");
			else
				zeileAusgeben(j, abschreibung, restBuchWert, "Wechsel linear");
		}
	}

	public static void zeileAusgeben(int jahr, double abschreibung, double restBuchWert, String endText) {
		DecimalFormat ausgFormat = new DecimalFormat("#,##0.00");
		System.out.println(" " + jahr + "\t " + String.format("%1$9s", ausgFormat.format(abschreibung)) + " EUR\t"
				+ String.format("%1$9s", ausgFormat.format(restBuchWert)) + " EUR " + endText);
	}

	public static void zeileTitel() {
		System.out.println("Jahr\tAbschreibung\tRestbuchwert");
	}

}
