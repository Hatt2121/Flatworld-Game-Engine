package items.weapons;

import org.fusesource.jansi.Ansi;
import items.Consumable;

public class ThrowableWeapon extends RangeWeapon implements Consumable {

	
	public ThrowableWeapon(String character) {
		super(character);
		
	}
	
	public ThrowableWeapon(String character, Ansi.Color color) {
		super(character,color);
	}

	public void destroyThyself() {
		
	}

	
	public void use() {
				
	}

	
	public void attackWith() {
		
	}
}
