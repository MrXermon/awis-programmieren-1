package mypack;

import java.util.Arrays;

public class LoadList {

	private int max;
	private int count;
	private int[] list;

	/**
	 * Standard-Konstruktor
	 */
	public LoadList() {
		this.max = 10;
		this.count = 0;
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
		this.count = l.length;
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
		this.count = 0;
		this.list = new int[max];
		for (int i = 0; i < this.count; i++)
			this.list[i] = -1;
	}

	/**
	 * Element zur Liste hinzufuegen
	 * 
	 * @param i
	 *            Element, dass hinzugefuegt werden soll.
	 */
	public void addElement(int i) {
		if (this.count < this.max)
			this.list[this.count++] = i;
	}

	/**
	 * Letztes Element aus der Liste entfernen
	 */
	public void delElement() {
		this.list[--this.count] = -1;
	}

	/**
	 * Element aus der Liste auslesen
	 * 
	 * @param i
	 * @return
	 */
	public int getElement(int i) {
		if (i < this.count)
			return this.list[i];
		else
			return -1;
	}

	/**
	 * Liste der aktuellen Elementsanzahl
	 * 
	 * @return Anzahl der akuellen Element in der Liste
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * Ausgabe der Elemente mit entsprechender Formatierung in der Konsole
	 */
	public void elementeAusgeben() {
		System.out.print("[");
		for (int i = 0; i < this.count; i++) {
			System.out.print(this.list[i]);
			if ((this.count - 1) != i)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	/**
	 * Elemente der Liste aufsteigend Sortieren
	 */
	public void sortAsc() {
		Arrays.sort(this.list);
	}

	/**
	 * Elemente der Liste absteigend Sortieren
	 */
	public void sortDesc() {
		this.sortAsc();
		this.reverse();
	}

	/**
	 * Reihenfolge der Liste umkehren
	 */
	public void reverse() {
		int[] neueListe = new int[this.max];
		for (int i = (this.max - 1); i >= 0; i--)
			neueListe[i] = this.list[(this.count - i - 1)];

		this.list = neueListe;
	}
}
