package game.items;

import game.Hero;

public class ManaBuff extends Items {

	private int buff;
	private String name;

	public ManaBuff(String name, int buff) {

		this.name = name;
		this.buff = buff;

	}

	public double getBuff() {
		return buff;
	}

	@Override
	public void use(Hero hero) {

		hero.setManaBar(hero.getManaBar() + buff);

		System.out.println("");

		System.out.println("You found " + this.name + ", you gain " + buff + " mana points");

		System.out.println("");

	}

}
