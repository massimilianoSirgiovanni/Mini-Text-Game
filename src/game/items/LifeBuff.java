package game.items;

import game.Hero;

public class LifeBuff extends Items {

	private int buff;
	private String name;

	public LifeBuff(String name, int buff) {

		this.name = name;
		this.buff = buff;

	}

	public double getBuff() {
		return buff;
	}

	@Override
	public void use(Hero hero) {

		hero.setLifeBar(hero.getLifeBar() + buff);

		System.out.println("");

		System.out.println("You found " + this.name + ", you gain " + buff + " life points");

		System.out.println("");

	}

}
