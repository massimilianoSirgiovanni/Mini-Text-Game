package game.items;

import game.Hero;

public class RestoreAbility extends Items {

	private String name;

	public RestoreAbility(String name) {

		this.name = name;

	}
	
	@Override
	public void use(Hero hero) {
		
		hero.addAbility();
		
		System.out.println("");

		System.out.println("You found " + this.name + ", you gain 1 ability point");

		System.out.println("");

	}

}
