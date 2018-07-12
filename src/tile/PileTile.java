package tile;

import items.Pile;

public class PileTile extends ContainerTile<Pile> {

	public PileTile(Pile a) {
		super(a.CHARACTER+" ");
		t = a;
	}
	
	public void spawn() {
		positionrows = (int) Math.random();
	}
	
	@Override
	public void interact() {
		
	}

	@Override
	public void interfac() {
				
	}

}
