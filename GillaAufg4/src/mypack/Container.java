package mypack;

public class Container {

	private int summe;
	private int maxSumme;
	private int[] list;
	private int max;
	private int count;

	public Container() {
		this.maxSumme = 7;
		this.summe = 0;
		this.list = new int[10];
		this.count = 0;
		this.max = 10;
	}
	
	public int getSumme(){
		return this.summe;
	}
	
	public int getCount(){
		return this.count;
	}
	
	public void showElements(){
		for(int i = 0; i < this.count; i++)
			System.out.print(this.list[i] + " ");
	}

	public boolean add(int i) {
		if ((this.summe + i) <= this.maxSumme && this.count < this.max) {
			this.summe += i;
			this.list[this.count++] = i;
			return true;
		} else {
			return false;
		}
	}
}
