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
	 * Konstruktor mit vorgegebenem Feld
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
	 * Konstruktor mit vorgegebener Feldgroesse
	 * 
	 * @param max
	 *            Maximale Feldgroesse
	 */
	public LoadList(int max) {
		this.max = max;
		this.count = 0;
		this.list = new int[max];
		for (int i = 0; i < this.count; i++)
			this.list[i] = -1;
	}

	public void addElement(int i) {
		if (this.count < this.max)
			this.list[this.count++] = i;
	}

	public void delElement() {
		this.list[--this.count] = -1;
	}

	public int getElement(int i) {
		if (i < this.count)
			return this.list[i];
		else
			return -1;
	}

	public int[] getElements() {
		return this.list;
	}

	public int getCount() {
		return this.count;
	}

	public void showElements() {
		System.out.print("[");
		for (int i = 0; i < this.count; i++) {
			System.out.print(this.list[i]);
			if ((this.count - 1) != i)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	public void sortAsc() {
		Arrays.sort(this.list);
	}

	public void sortDesc() {
		this.sortAsc();
		this.reverse();
	}
	
	public void reverse(){
		int[] neueListe = new int[this.max];
		for (int i = (this.max - 1); i >= 0; i--)
			neueListe[i] = this.list[(this.count - i - 1)];

		this.list = neueListe;
	}
}
