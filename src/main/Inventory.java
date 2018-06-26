package main;
import java.util.ArrayList;

import items.Item;

public class Inventory {
	public ArrayList<Item> itemlist = new ArrayList<Item>();
	public Ask h = new Ask();
	
	boolean packed;
	boolean filled;
	
	boolean overweight;
	
	double weightlimit;
	double sizelimit;
	
	double weighttotal = 0;
	double sizetotal = 0;
	
	public void addToInventory(Item a) {
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
}
