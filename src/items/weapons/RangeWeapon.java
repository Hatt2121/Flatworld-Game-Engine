package items.weapons;

import org.fusesource.jansi.Ansi;

import jsonreader.ItemReader;

public class RangeWeapon extends Weapon {

	public Ammo ammunition;
	public int amount;
	
	public RangeWeapon(String character) {
		super(character);
	}
	
	public RangeWeapon(String character, Ansi.Color color) {
		super(character,color);
	}
	
	public void eject() {
		
	}

	public void use() {
		
	}

	public void attackWith() {
				
	}
	
	public void generateProperties() {
	
		
	}

	
	public void generateProperties(ItemReader itemreader) {
		
		
	}
}
