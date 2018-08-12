package items.weapons;

import org.fusesource.jansi.Ansi;

import items.Item;
import items.Tool;

public abstract class Weapon extends Item implements Tool {
	
	public double durability;
	public double damage;
	public Ability ability;
	
	public Weapon(String character) {
		super(character,Ansi.Color.WHITE);
	}
	
	public Weapon(String character, Ansi.Color color) {
		super(character,color);
	}
	
	public abstract void attackWith();
}
