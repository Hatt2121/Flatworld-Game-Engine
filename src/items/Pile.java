package items;

import java.util.ArrayList;

public class Pile {
	
	public String CHARACTER = "A";
	
	public ArrayList<Item> itemlist = new  ArrayList<Item>();
	
	public void printItemList() {
		System.out.println("This is what is contained in the pile: ");
		for(Item a : itemlist) {
			a.printStats();
		}
	}
	
	public void rngGenerate() {
		int howmany = (int) Math.random() * 25 + 2;
		int typenumber = (int) Math.random() * 5;
		Item whatisit; //Item sub-class
		
		for(int x = 0; x < howmany; x++) {
			switch(typenumber) {
			case(0):
				whatisit = new Foodstuff();
				whatisit.generateProperties();
			break;
			default:
			break;
			}
		}
	}
}
