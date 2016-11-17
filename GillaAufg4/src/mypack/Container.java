/**
 * Jan Gilla
 * 17.11.2016
 * V1.0
 * 
 * Abbildung eines einzelnen Containers
 */

package mypack;

public class Container {

	private int summe;
	private int maxSumme;
	private int[] list;
	private int max;
	private int count;

	/**
	 * Standard-Konstruktor
	 */
	public Container() {
		this.maxSumme = 7;
		this.summe = 0;
		this.list = new int[10];
		this.count = 0;
		this.max = 10;
	}

	/**
	 * (Additions-)Summe der Elemente
	 * 
	 * @return Summe
	 */
	public int getSumme() {
		return this.summe;
	}

	/**
	 * Anzahl der Elemente in der Liste
	 * 
	 * @return Anzahl
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * Ausgabe der Elemente mit entsprechender Formatierung in der Konsole
	 */
	public void elementeAusgeben() {
		for (int i = 0; i < this.count; i++)
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
		if ((this.summe + i) <= this.maxSumme && this.count < this.max) {
			this.summe += i;
			this.list[this.count++] = i;
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
