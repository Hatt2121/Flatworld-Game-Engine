package player;
import java.util.ArrayList;

import items.Item;
import main.Ask;

public class Inventory {
	public ArrayList<Item> itemlist = new ArrayList<Item>();
	public Ask h = new Ask();
	
	boolean packed;
	boolean filled;
	
	boolean overweight;
	
	//These values are temporary
	double weightlimit = 7;
	double sizelimit = 7;
	
	double weighttotal = 0;
	double sizetotal = 0;
	
	public void addToInventory(Item a) {
		checkWeight();
		checkPack();
		if(!filled&&!overweight) {
			itemlist.add(a);
		}
	}
	
	public void checkWeight() {
		for(int x = 0; x < itemlist.size(); x++) {
			weighttotal = itemlist.get(x).weight + weighttotal;
		}
		if(weighttotal>weightlimit) {
			overweight = true;
		}
	}

	public void repack() {
		for(int x = 0; x < itemlist.size(); x++) {
			double a = itemlist.get(x).size;
			if(a<1) {
				a = 0;
			} else {
				a = Math.ceil(a);
			}
			itemlist.get(x).size = a;
		}
		packed = true;
	}
	
	public void checkPack() {
		for(int x = 0; x < itemlist.size(); x++) {
			sizetotal = itemlist.get(x).size + sizetotal;
		}
		if((sizetotal>sizelimit)) {
			filled = true;
		}
		if(filled) {
			boolean b = h.yeno("Do you want to reorganize your inventory?");
			if(b) {
				repack();
			}
		}
	}
	
	public void printInventory() {
		System.out.println("+--------------------------------------------------+");
		System.out.println("|Name - Character - Value - Weight - Size - Density|");
		System.out.println("+--------------------------------------------------+");
		System.out.println();
		//Make it more dynamic
		for(int x = 0; x < itemlist.size(); x++) {
			itemlist.get(x).printStats();
		}
	}

	public void printStats() {
		System.out.println("Inventory Statistics: ");
		System.out.println("Weight: " +
				"\n" +weighttotal+'/'+weightlimit + " " + ((int) (weighttotal/weightlimit)*100)+"%");
		System.out.println();
		System.out.println("Size: " +
				"\n" +sizetotal+'/'+sizelimit + " " + ((int) (sizetotal/sizelimit)*100)+"%");
		
	}
}
