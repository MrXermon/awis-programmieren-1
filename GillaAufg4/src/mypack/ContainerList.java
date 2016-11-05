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
		this.list = new Container[3];
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
	 * Ausgabe einzelnen Container aus der Liste
	 */
	public void showContainers() {
		Container c;
		for (int i = 0; i < this.count; i++) {
			c = this.getContainer(i);
			System.out.println("Container Nr.:\t" + i);
			System.out.println("Anzahl Stuecke:\t" + c.getCount());
			System.out.print("Inhalt:\t");
			c.showElements();
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
		l.showElements();
		System.out.println("FIRST-FIT:");

		this.aufContainerVerteilen(l);

		this.showContainers();
	}

	/**
	 * Methode zur Anwendung des First Fit Decreasing Algorithmus
	 * 
	 * @param l
	 *            Uebergabe einer LoadListe
	 */
	public void FFD(LoadList l) {
		System.out.print("Ladeliste: ");
		l.showElements();
		System.out.println("FIRST-FIT-DECREASING:");
		System.out.print("Ladeliste sortiert: ");
		l.sortDesc();
		l.showElements();

		this.aufContainerVerteilen(l);

		this.showContainers();
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
		Container c;

		l.reverse();
		/** Solange noch Elemente in der LoadList vorhanden sind... **/
		do {
			aktuell = l.getElement(l.getCount() - 1);
			/** LoadListen Elemente sind bei Nichtverwendung -1 **/
			if (aktuell > -1) {
				container = 0;
				do {
					/**
					 * Versuch den Wert in den erstbesten Container
					 * hinzuzufuegen, sonst den naechsten Container verwenden
					 **/
					c = this.getContainer(container);
					if (c.add(aktuell)) {
						aktuell = -1;
						l.delElement();
					} else {
						container++;
					}
				} while (aktuell != -1);
			}
		} while (l.getCount() > 0);
	}

	public static void main(String[] args) {

		/** Initialisierung der zu verwendenden Daten **/
		int[] ladeListe = new int[] { 3, 5, 2, 4 };
		ContainerList cl = null;
		LoadList loadList = null;

		/** Initialisierung und Aufruf First Fit Algorithmus **/
		loadList = new LoadList(ladeListe);
		cl = new ContainerList();
		cl.FF(loadList);

		/** Initialisierung und Aufruf First Fit Decreasing Algorithmus **/
		loadList = new LoadList(ladeListe);
		cl = new ContainerList();
		cl.FFD(loadList);

	}

}
