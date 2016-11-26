/**
 * Jan Gilla
 * 17.11.2016
 * V1.0
 * 
 * Abbildung der Ladeliste
 */

package mypack;

import java.util.Arrays;

public class LoadList {

	/** Maximale Elemente in der Ladeliste **/
	private int max;
	/** Aktuelle Anzahl der Elemente in der Ladeliste **/
	private int anzahl;
	/** Liste mit Elementen **/
	private int[] list;

	/**
	 * Standard-Konstruktor
	 */
	public LoadList() {
		this.max = 10;
		this.anzahl = 0;
		this.list = new int[10];
	}

	/**
	 * Konstruktor mit vorgegebener Liste
	 * 
	 * @param l
	 *            int Array mit beliebiger Groesse
	 */
	public LoadList(int[] l) {
		this.max = l.length;
		this.anzahl = l.length;
		this.list = new int[l.length];

		for (int i = 0; i < l.length; i++)
			this.list[i] = l[i];
	}

	/**
	 * Konstruktor mit vorgegebener Listengroesse
	 * 
	 * @param max
	 *            Listengroesse
	 */
	public LoadList(int max) {
		this.max = max;
		this.anzahl = 0;
		this.list = new int[max];
		for (int i = 0; i < this.anzahl; i++)
			this.list[i] = -1;
	}

	/**
	 * Element zur Liste hinzufuegen
	 * 
	 * @param i
	 *            Element, dass hinzugefuegt werden soll.
	 */
	public void addElement(int i) {
		if (this.anzahl < this.max)
			this.list[this.anzahl++] = i;
	}

	/**
	 * Letztes Element aus der Liste entfernen
	 */
	public void delElement() {
		this.list[--this.anzahl] = -1;
	}

	/**
	 * Element aus der Liste auslesen
	 * 
	 * @param i
	 *            Element in der Liste
	 * @return Wert des Elements
	 */
	public int getElement(int i) {
		if (i < this.getAnzahl())
			return this.list[i];
		else
			return -1;
	}

	/**
	 * Liste der aktuellen Elementsanzahl
	 * 
	 * @return Anzahl der akuellen Element in der Liste
	 */
	public int getAnzahl() {
		return this.anzahl;
	}

	/**
	 * Ausgabe der Elemente mit entsprechender Formatierung in der Konsole
	 */
	public void elementeAusgeben() {
		System.out.print("[");
		for (int i = 0; i < this.getAnzahl(); i++) {
			System.out.print(this.list[i]);
			if ((this.getAnzahl() - 1) != i)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	/**
	 * Elemente der Liste aufsteigend Sortieren
	 */
	public void sortAufsteigend() {
		Arrays.sort(this.list);
	}

	/**
	 * Elemente der Liste absteigend Sortieren
	 */
	public void sortAbsteigen() {
		this.sortAufsteigend();
		this.umkehren();
	}

	/**
	 * Reihenfolge der Liste umkehren
	 */
	public void umkehren() {
		int[] neueListe = new int[this.max];
		for (int i = (this.max - 1); i >= 0; i--)
			neueListe[i] = this.list[(this.anzahl - i - 1)];

		this.list = neueListe;
	}
}
