package game.items;

import game.Hero;

public class LifeTraps extends Items {

	private int debuff;
	private String name;

	public LifeTraps(String name, int debuff) {

		this.name = name;
		this.debuff = debuff;
		this.setIcon("T");

	}

	public int getDebuff() {
		return debuff;
	}

	@Override
	public void use(Hero hero) {

		hero.setLifeBar(hero.getLifeBar() - debuff);

		System.out.println("");

		System.out.println("You found " + this.name + ", you lose " + debuff + " life points");

		System.out.println("");

	}

}
