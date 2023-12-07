package game.items;

import game.Hero;

public class Pickaxe extends Items {
	
	@Override
	public void use(Hero hero) {
		
		hero.setPickaxe(true);
		
		System.out.println("");

		System.out.println("You found the PICKAXE, now you can break WALLS");

		System.out.println("");

	}

}
