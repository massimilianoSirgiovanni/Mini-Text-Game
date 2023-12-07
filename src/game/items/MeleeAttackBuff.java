package game.items;

import game.Hero;

public class MeleeAttackBuff extends Items {

	private int buff;
	private String name;

	public MeleeAttackBuff(String name, int buff) {

		this.name = name;
		this.buff = buff;

	}

	public double getBuff() {
		return buff;
	}

	@Override
	public void use(Hero hero) {

		hero.setMeleeAttack(hero.getMeleeAttack() + buff);

		System.out.println("");

		System.out.println("You found " + this.name + ", you gain " + buff + " attack points");

		System.out.println("");

	}

}
