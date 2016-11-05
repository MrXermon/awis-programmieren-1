package mypack;

public class ContainerList {

	private Container[] list;
	private int max;
	private int count;

	public ContainerList() {
		this.max = 3;
		this.count = 0;
		this.list = new Container[3];
		for (int i = 0; i < this.max; i++) {
			this.list[i] = new Container();
			this.count++;
		}
	}

	public Container getContainer(int i) {
		if (i < this.count && i > -1)
			return this.list[i];
		else
			return new Container();
	}

	public void setContainer(int i, Container c) {
		if (i < this.count && i > -1)
			this.list[i] = c;
	}

	public void showContainers() {
		Container c;
		for (int i = 0; i < this.max; i++) {
			c = this.getContainer(i);
			System.out.println("Container Nr.:\t" + i);
			System.out.println("Anzahl Stuecke:\t" + c.getCount());
			System.out.print("Inhalt:\t");
			c.showElements();
			System.out.println();
			System.out.println();
		}
	}

	public void FF(LoadList l) {
		System.out.print("Ladeliste: ");
		l.showElements();
		System.out.println("FIRST-FIT:");

		this.algorithmus(l);

		this.showContainers();
	}

	public void FFD(LoadList l) {
		System.out.print("Ladeliste: ");
		l.showElements();
		System.out.println("FIRST-FIT-DECREASING:");
		System.out.print("Ladeliste sortiert: ");
		l.sortDesc();
		l.showElements();

		this.algorithmus(l);

		this.showContainers();
	}

	public void algorithmus(LoadList l) {
		int aktuell;
		int container;
		Container c;

		l.reverse();
		do {
			aktuell = l.getElement(l.getCount() - 1);
			if (aktuell > 0) {
				container = 0;
				do {
					c = this.getContainer(container);
					if (c.add(aktuell))
						aktuell = -1;
					else
						container++;
				} while (aktuell != -1);
			}
			l.delElement();
		} while (l.getCount() > 0);
	}

	public static void main(String[] args) {

		int[] ladeListe = new int[] { 3, 5, 2, 4 };
		ContainerList cl = null;
		LoadList loadList = null;

		loadList = new LoadList(ladeListe);
		cl = new ContainerList();
		cl.FF(loadList);

		loadList = new LoadList(ladeListe);
		cl = new ContainerList();
		cl.FFD(loadList);

	}

}
