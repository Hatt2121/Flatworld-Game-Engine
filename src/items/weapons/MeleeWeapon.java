package items.weapons;

import org.fusesource.jansi.Ansi;

import jsonreader.*;

public class MeleeWeapon extends Weapon {

	public int aoetype;
	
	public MeleeWeapon(String character) {
		super(character);
	}
	
	public MeleeWeapon(String character, Ansi.Color color) {
		super(character, color);
	}


	public void use() {
				
	}

	public void attackWith() {
				
	}
	
	public void generateProperties() {
		
	}
	
	public void generateProperties(ItemReader ir) {
		WeaponReader wr = new WeaponReader(ir.jr);
		
		this.aoetype = wr.returnAOEType();
		this.name = wr.returnName();
		this.durability = 100;
		this.damage = wr.returnDamage();
		this.weight = wr.returnWeightMaximum();
		this.density = wr.returnDensity();
		this.value = wr.returnValueMaximum();
	}
}
