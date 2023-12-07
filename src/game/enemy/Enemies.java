package game.enemy;

import game.BoardContent;

public abstract class Enemies extends BoardContent {

	private int lifeBar;
	private int manaBar;
	private int meleeAttack;
	private int magicAttack;
	private int consumeMana = 1;
	private String nameEnemy;
	private double critical = 0.1;
	private int criticalBound = 1;
	private double dodge = 1;

	public Enemies() {
		this.setIcon("E");
	}

	public double getCritical() {
		return critical;
	}

	public void setCritical(double critical) {
		this.critical = critical;
	}

	public int getCriticalBound() {
		return criticalBound;
	}

	public void setCriticalBound(int criticalBound) {
		this.criticalBound = criticalBound;
	}

	public String getEnemyName() {
		return nameEnemy;
	}

	public void setEnemyName(String name) {
		nameEnemy = name;
	}

	public double getLifeBar() {
		return lifeBar;
	}

	public void setLifeBar(int lifeBar) {
		this.lifeBar = lifeBar;
	}

	public double getmeleeAttack() {
		return meleeAttack;
	}

	public void setMeleeAttack(int attack) {
		this.meleeAttack = attack;
	}

	private boolean dead = false;

	public int meleeAttack() {

		System.out.println("");
		System.out.println(nameEnemy + " has used a melee attack");
		System.out.println("");

		if (criticalAttack()) {
			System.out.println("");
			System.out.println("**CRITICAL ATTACK**");
			System.out.println("");
			return (int) (meleeAttack + meleeAttack * critical);
		}
		return meleeAttack;
	}

	public int magicAttack() {

		System.out.println("");
		System.out.println(nameEnemy + " has used a magical attack");
		System.out.println("");

		manaBar = manaBar - consumeMana;
		if (criticalAttack()) {
			System.out.println("");
			System.out.println("**CRITICAL ATTACK**");
			System.out.println("");
			return (int) (magicAttack + magicAttack * critical);
		}
		return magicAttack;
	}

	public int attack() {

		if (manaBar - consumeMana >= 0) {

			int coin = (int) ((Math.random() * (10 - 1)) + 1);

			if (coin % 2 == 0) {
				return magicAttack();
			}

		}

		return meleeAttack();

	}

	public int getManaBar() {
		return manaBar;
	}

	public void setManaBar(int manaBar) {
		this.manaBar = manaBar;
	}

	public int getMagicAttack() {
		return magicAttack;
	}

	public void setMagicAttack(int magicAttack) {
		this.magicAttack = magicAttack;
	}

	public int getConsumeMana() {
		return consumeMana;
	}

	public void setConsumeMana(int consumeMana) {
		this.consumeMana = consumeMana;
	}

	public void applyDamage(int damage) {
		
		if(this.Dodge()) {
			System.out.println(this.nameEnemy + " dodged the attack");
			System.out.println("");
			damage = 0;
		} else if (lifeBar - damage > 0) {
			lifeBar = lifeBar - damage;
		} else {
			dead = true;
		}

		System.out.println("");
		System.out.println("You did " + damage + " points of damage to the enemy");
		System.out.println("");

	}

	public double getDodge() {
		return dodge;
	}

	public void setDodge(double dodge) {
		this.dodge = dodge;
	}

	public boolean isDead() {
		return dead;
	}

	public void printStatus() {
		System.out.println(this.getEnemyName() + ": Life Bar <" + lifeBar + "> Mana Bar <" + manaBar + ">");
	}

	public boolean criticalAttack() {

		int random = (int) (Math.random() * 10);

		if (random > 0 && random <= criticalBound) {
			return true;
		}

		return false;

	}
	
	public boolean Dodge() {

		int random = (int) (Math.random() * 20);

		if (random > 0 && random <= dodge) {
			return true;
		}

		return false;

	}

}
