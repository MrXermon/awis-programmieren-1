package mypack;

import java.text.*;

public class Collatz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double STARTWERT = 10;
		double maxLaenge = 0, maxLaengeBei = 0, maxElemente = 0, maxElementeBei = 0, maxRelGroesse = 0,
				maxRelGroesseBei = 0;

		DecimalFormat dezFormat = new DecimalFormat("#0.00");

		for (int i = 1; i <= STARTWERT; i++) {
			if (Collatz.collatz_elemente(i) > maxLaenge) {
				maxLaenge = Collatz.collatz_elemente(i);
				maxLaengeBei = i;
			}
			if ((Collatz.collatz_maxElement(i) - i) > maxElemente) {
				maxElemente = Collatz.collatz_maxElement(i) - i;
				maxElementeBei = i;
			}
			if (Collatz.collatz_relgroesse(i) > maxRelGroesse) {
				maxRelGroesse = Collatz.collatz_relgroesse(i);
				maxRelGroesseBei = i;
			}
		}

		System.out.println("Maximale Laenge: " + (int) maxLaenge + " bei n = " + (int) maxLaengeBei);
		System.out.println(
				"Maximales Element: " + (int) (maxElemente + maxElementeBei) + " bei n = " + (int) maxElementeBei);
		System.out.println(
				"Maximale relative Groesse: " + dezFormat.format(maxRelGroesse) + " bei n = " + (int) maxRelGroesseBei);
	}

	public static void collatz(double n, boolean ausgabe) {
		boolean go = true;
		while (go) {
			if (ausgabe)
				System.out.print((int) n);
			if (n % 2.0 == 0) {
				n = n / 2.0;
			} else {
				n = (3 * n) + 1;
			}
			if (n == 1) {
				if (ausgabe)
					System.out.print(" -> 1");
				go = false;
			} else {
				if (ausgabe)
					System.out.print(" -> ");
			}
		}
	}

	public static int collatz_elemente(double n) {
		// Kettenlaenge
		boolean go = true;
		int zaehler = 0;
		while (go) {
			if (n % 2.0 == 0) {
				n = n / 2.0;
			} else {
				n = (3 * n) + 1;
			}
			if ((int) n == 1) {
				zaehler++;
				go = false;
			} else {
				zaehler++;
			}
		}
		return zaehler;
	}

	public static int collatz_maxElement(double n) {
		// Hoechstes Element
		boolean go = true;
		double maximales = n;
		while (go) {
			if (n % 2.0 == 0) {
				n = n / 2.0;
			} else {
				n = (3 * n) + 1;
			}
			if ((int) n == 1) {
				go = false;
			}
			if (n > maximales)
				maximales = n;
		}
		return (int) maximales;
	}

	public static double collatz_relgroesse(double n) {
		// rel. Groesse
		return collatz_maxElement(n) / n;
	}

}
