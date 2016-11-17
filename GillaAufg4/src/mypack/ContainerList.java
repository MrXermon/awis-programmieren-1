package mypack;

public class ContainerList {

	private Container[] list;
	private int max;
	private int count;

	/**
	 * Standardkonstruktor
	 */
	public ContainerList() {
		this.max = 3;
		this.count = 0;
		this.list = new Container[this.max];
		for (int i = 0; i < this.max; i++) {
			this.list[i] = new Container();
			this.count++;
		}
	}

	/**
	 * Konstruktor zum Anlegen von Container Listen mit einer vorgegebenen
	 * Anzahl an Containern
	 * 
	 * @param max
	 *            Anzahl der anzulegenden Container
	 */
	public ContainerList(int max) {
		this.max = max;
		this.count = 0;
		this.list = new Container[this.max];
		for (int i = 0; i < this.max; i++) {
			this.list[i] = new Container();
			this.count++;
		}
	}

	/**
	 * Methode zum Auslesen eines Containers
	 * 
	 * @param i
	 *            Stelle des Containers in der Liste
	 * @return Container als Objekt
	 */
	public Container getContainer(int i) {
		if (i < this.count && i > -1)
			return this.list[i];
		else
			return new Container();
	}

	/**
	 * Methode zur Rueckgabe der Anzahl der Container
	 * 
	 * @return Anzahl
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * Ausgabe einzelnen Container aus der Liste
	 */
	public void containerAusgeben() {
		Container c;
		for (int i = 0; i < this.count; i++) {
			c = this.getContainer(i);
			System.out.println("Container Nr.:\t" + i);
			System.out.println("Anzahl Stuecke:\t" + c.getCount());
			System.out.print("Inhalt:\t");
			c.elementeAusgeben();
			System.out.println();
			System.out.println();
		}
	}

	/**
	 * Methode zur Anwendung des First Fit Algorithmus
	 * 
	 * @param l
	 *            Uebergabe einer LoadListe
	 */
	public void FF(LoadList l) {
		System.out.print("Ladeliste: ");
		l.elementeAusgeben();
		System.out.println("FIRST-FIT:");

		this.aufContainerVerteilen(l);

		this.containerAusgeben();
	}

	/**
	 * Methode zur Anwendung des First Fit Decreasing Algorithmus
	 * 
	 * @param l
	 *            Uebergabe einer LoadListe
	 */
	public void FFD(LoadList l) {
		System.out.print("Ladeliste: ");
		l.elementeAusgeben();
		System.out.println("FIRST-FIT-DECREASING:");
		System.out.print("Ladeliste sortiert: ");
		l.sortDesc();
		l.elementeAusgeben();

		this.aufContainerVerteilen(l);

		this.containerAusgeben();
	}

	/**
	 * Algorithmus zur Abarbeitung der Load Liste und Verteilung des Inhalts auf
	 * die einzelne Container
	 * 
	 * @param l
	 *            LoadListe zum Verteilen auf die Container
	 */
	private void aufContainerVerteilen(LoadList l) {
		int aktuell;
		int container;
		boolean abbruch = false;
		Container c;

		l.reverse();
		/* Solange noch Elemente in der LoadList vorhanden sind... */
		do {
			aktuell = l.getElement(l.getCount() - 1);
			/* LoadListen Elemente sind bei Nichtverwendung -1 */
			if (aktuell > -1) {
				container = 0;
				/*
				 * Versuch den Wert in den erstbesten Container hinzuzufuegen,
				 * sonst den naechsten Container verwenden
				 */
				do {
					c = this.getContainer(container);
					if (c.add(aktuell)) {
						aktuell = -1;
						l.delElement();
					} else {
						/*
						 * Wenn der letzte Container getestet wurde -> Ueberlauf
						 */
						if (container == (this.getCount() - 1)) {
							abbruch = true;
						} else {
							container++;
						}
					}
				} while (aktuell != -1 && container < this.getCount() && abbruch == false);
			}
		} while (l.getCount() > 0 && abbruch == false);
		if (abbruch) {
			System.out.println(
					"Hinweis: Es konnten nicht alle Elemte der "
					+ "Ladelste verteilt werden.\nBisherige Verteilung:");
		}
	}

	public static void main(String[] args) {

		/* Initialisierung der zu verwendenden Daten */
		int[] ladeListe = new int[] { 3, 5, 2, 4 };
		ContainerList cl = null;
		LoadList loadList = null;

		/* Initialisierung und Aufruf First Fit Algorithmus */
		loadList = new LoadList(ladeListe);
		cl = new ContainerList();
		cl.FF(loadList);

		/* Initialisierung und Aufruf First Fit Decreasing Algorithmus */
		loadList = new LoadList(ladeListe);
		cl = new ContainerList();
		cl.FFD(loadList);

	}

}
