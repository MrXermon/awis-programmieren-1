/**
 * Jan Gilla
 * 03.11.2016
 * V1.0
 * 
 * Klaase zur Abbildung eines Tamagotchis inkl. Spielablauf
 */

package mypack;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Tamagotchi {

	private String name;
	private double satt;
	private double glueck;
	private boolean lebt;

	private int gespielteRunden;

	/**
	 * Konstruktor mit Standardwerten
	 */
	public Tamagotchi() {
		this.name = "KeinName";
		this.satt = 0.5;
		this.glueck = 0.5;
		this.lebt = true;
		this.gespielteRunden = 1;
	}

	/**
	 * Konstruktor mit Angabe des Namens
	 * 
	 * @param n
	 *            Name des Tamagotchis
	 */
	public Tamagotchi(String n) {
		this.name = n;
		this.satt = 0.5;
		this.glueck = 0.5;
		this.lebt = true;
		this.gespielteRunden = 1;
	}

	/**
	 * Methode zum Erhoehen des Attributs Satt um 0.5
	 */
	public void setSatt() {
		if (this.satt < 1 && this.satt > 0) {
			this.satt += 0.5;
		}
	}

	/**
	 * Methode zum Erhoehen des Attributs Glueck um 0.5
	 */
	public void setGlueck() {
		if (this.glueck < 1 && this.glueck > 0) {
			this.glueck += 0.5;
		}
	}

	/**
	 * Rueckgabe des aktuellen Namen
	 * 
	 * @return Wert aus dem Attribut
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Methode zur Ueberpruefung der Lebendigkeit des Tamagotchis und
	 * aktualisiert das entsprechende Attribut
	 * 
	 * @return Gibt zurueck ob das Tamagotchi lebt oder nicht
	 */
	public boolean getLebt() {
		if (this.glueck < 1 && this.glueck > 0 && this.satt < 1 && this.satt > 0) {
			this.lebt = true;
		} else {
			this.lebt = false;
		}
		return this.lebt;
	}

	/**
	 * Rueckgabe der aktuellen Saettigung
	 * 
	 * @return Wert aus dem Attribut
	 */
	public double getSatt() {
		return this.satt;
	}

	/**
	 * Rueckgabe des aktuellen Gluecks
	 * 
	 * @return Wert aus dem Attribut
	 */
	public double getGlueck() {
		return this.glueck;
	}

	/**
	 * Spielt eine Runde des Tamagotchis
	 * 
	 * @param tun
	 *            Entweder f = fuettern oder u = unterhalten
	 */
	public void runde() {
		String tun = "";
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		/** Abfangen von nicht validen Eingaben **/
		do {
			System.out.print("        Eingabe (f = fuettern, u = unterhalten): ");
			tun = input.nextLine();
		} while (!tun.equals("f") && !tun.contentEquals("u"));

		switch (tun) {
		case "f":
			this.setSatt();
			break;
		case "u":
			this.setGlueck();
			break;
		}

		this.satt -= Math.random() / 2;
		this.glueck -= Math.random() / 2;
		this.gespielteRunden += 1;
	}

	/**
	 * Spielt die Uebergebene Anzahl der Runden durch
	 * 
	 * @param anzRunden
	 *            Uebergibt die zu spielende Rundenzahl
	 */
	public void spiel(int anzRunden) {
		int i = 1;

		/** Durchspielen der einzelen Runden **/
		do {
			System.out.print("Runde " + i + " ");
			this.infoAusgabe();
			this.runde();
			i++;
		} while (this.getLebt() && i <= anzRunden);

		System.out.print("\n");

		/** Ausgabe der Ergebniszeile **/
		if (!this.getLebt()) {
			System.out.print("Verloren ...");
			if (this.getSatt() <= 0) {
				System.out.print("verhungert");
			} else if (this.getSatt() >= 1) {
				System.out.print("geplatzt");
			} else if (this.getGlueck() <= 0) {
				System.out.print("verkuemmert");
			} else if (this.getGlueck() >= 1) {
				System.out.print("verhaaetschelt");
			}
		} else {
			System.out.print("Gewonnen!");
		}

		System.out.print(" Endzustand: Runde " + (this.gespielteRunden - 1) + " ");
		this.infoAusgabe();
	}

	/**
	 * Angepasste Aufgabe der Statusinformationen
	 */
	public void infoAusgabe() {
		DecimalFormat ausgFormat = new DecimalFormat("#,##0.00");
		System.out.println(this.name + " satt: " + ausgFormat.format(this.satt) + " gluecklich: "
				+ ausgFormat.format(this.glueck) + " lebend: " + this.lebt);
	}

	/**
	 * Funktion zur Ausgabe der Tamagotchi-tamagotchiListe
	 * 
	 * @param liste
	 *            tamagotchiListe mit Tamagotchi-Elementen
	 * @param laenge
	 *            Laenge der vorhandenen Elemente in der Liste
	 */
	public void listeAusgeben(Tamagotchi[] liste, int laenge) {
		System.out.println("\nAusgabe der Familienliste:");
		if (laenge == 0) {
			System.out.println("Keine Elemente in der Liste!");
		} else {
			for (int i = 0; i < laenge; i++)
				liste[i].infoAusgabe();
		}
	}

	/**
	 * Programmablauf
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/** Anzahl der Tamagotchis **/
		final int MAX_TAMAGOTCHI = 3;
		/** Anzahl der zu spielenden Runden **/
		final int MAX_RUNDENZAHL = 3;

		/** Fuer die Familie genoetigte Variablen **/
		Tamagotchi[] tamagotchiListe = new Tamagotchi[MAX_TAMAGOTCHI];
		int lebendigAnzahl = 0;
		int i = 1;

		Tamagotchi T = new Tamagotchi("Name1");
		T.spiel(MAX_RUNDENZAHL);
		if (T.getLebt()) {
			tamagotchiListe[0] = T;
			lebendigAnzahl++;
		}

		/**
		 * Schleife zum Erzeugen und Durchspielen der einzelnen Tamagotchis.
		 **/
		while (lebendigAnzahl > 0 && i == lebendigAnzahl && i < MAX_TAMAGOTCHI) {
			tamagotchiListe[i] = new Tamagotchi("Name" + (i + 1));
			tamagotchiListe[i].spiel(MAX_RUNDENZAHL);
			if (tamagotchiListe[i].getLebt()) {
				/** Sofern das Tamagotchi ueberlebt hat wird weiter gemacht **/
				lebendigAnzahl++;
			} else {
				/** ansonsten wird das Tamagotchi begraben... **/
				tamagotchiListe[i] = null;
			}
			i++;
		}

		T.listeAusgeben(tamagotchiListe, lebendigAnzahl);

	}

}
