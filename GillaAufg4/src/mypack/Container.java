/**
 * Jan Gilla
 * 17.11.2016
 * V1.0
 * 
 * Abbildung eines einzelnen Containers
 */

package mypack;

public class Container {

	/** Aktuelles Gewicht des Containers **/
	private int gewicht;
	/** Maximales Gewicht des Containers **/
	private int maxSumme;
	/** Liste der Elemente im Container **/
	private int[] list;
	/** Maximale Anzahl der Elemente im Container **/
	private int max;
	/** Aktuelle Anzahl der Elemente im Container **/
	private int anzahl;

	/**
	 * Standard-Konstruktor
	 */
	public Container() {
		this.maxSumme = 7;
		this.gewicht = 0;
		this.list = new int[10];
		this.anzahl = 0;
		this.max = 10;
	}

	/**
	 * (Additions-)Summe der Elemente
	 * 
	 * @return Summe
	 */
	public int getGewicht() {
		return this.gewicht;
	}

	/**
	 * Anzahl der Elemente in der Liste
	 * 
	 * @return Anzahl
	 */
	public int getAnzahl() {
		return this.anzahl;
	}

	/**
	 * Ausgabe der Elemente mit entsprechender Formatierung in der Konsole
	 */
	public void elementeAusgeben() {
		for (int i = 0; i < this.getAnzahl(); i++)
			System.out.print(this.list[i] + " ");
	}

	/**
	 * Funktion zum hinzufuegen eines Elements zu der Liste
	 * 
	 * @param i
	 *            Hinzuzufuegendes Element
	 * @return Hinzufuegen geklappt oder nicht
	 */
	public boolean add(int i) {
		if ((this.getGewicht() + i) <= this.maxSumme && this.anzahl < this.max) {
			this.gewicht += i;
			this.list[this.anzahl++] = i;
			return true;
		} else {
			/*
			 * Nicht ausreichend Platz im Container oder maximales Gewicht
			 * erreicht
			 */
			return false;
		}
	}
}
