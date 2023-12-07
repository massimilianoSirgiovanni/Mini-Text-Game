package game;

public class Hero extends BoardContent {

	private int lifeBar = 100;
	private int manaBar = 50;
	private int meleeAttack = 10;
	private int magicAttack = 25;
	private int consumeMana = 25;
	private double critical = 0.5;
	private double dodge = 2;
	private int criticalBound = 2;
	private boolean showOnMap = true;
	private int ability = 1;
	private boolean pickaxe = false;

	public Hero() {
		this.setIcon("H");
		this.setShowIcon(true);
	}

	public boolean getPickaxe() {
		return pickaxe;
	}

	public void setPickaxe(boolean pickaxe) {
		this.pickaxe = pickaxe;
	}

	public int getMeleeAttack() {
		return meleeAttack;
	}

	public int getLifeBar() {
		return lifeBar;
	}

	public void setLifeBar(int lifeBar) {
		this.lifeBar = lifeBar;
	}

	public int getMagicAttack() {
		return magicAttack;
	}

	public int meleeAttack() {

		if (criticalAttack()) {
			System.out.println("");
			System.out.println("**CRITICAL ATTACK**");
			System.out.println("");
			return (int) (meleeAttack + meleeAttack * critical);

		}

		return meleeAttack;
	}

	public int magicAttack() {

		if (manaBar - consumeMana >= 0) {
			manaBar = manaBar - consumeMana;
		} else {
			System.out.println("You do not have enough mana to use magic Attack");
			return -1;
		}
		if (criticalAttack()) {
			System.out.println("");
			System.out.println("**CRITICAL ATTACK**");
			System.out.println("");
			return (int)(magicAttack + magicAttack * critical);
		}
		return magicAttack;
	}

	public int getManaBar() {
		return manaBar;
	}

	public void setManaBar(int manaBar) {
		this.manaBar = manaBar;
	}

	public double getConsumeMana() {
		return consumeMana;
	}

	public void setConsumeMana(int consumeMana) {
		this.consumeMana = consumeMana;
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

	public boolean isShowOnMap() {
		return showOnMap;
	}

	public void setShowOnMap(boolean showOnMap) {
		this.showOnMap = showOnMap;
	}

	public void setMeleeAttack(int meleeAttack) {
		this.meleeAttack = meleeAttack;
	}

	public void setMagicAttack(int magicAttack) {
		this.magicAttack = magicAttack;
	}

	public int applyDamage(int damage) {
		
		if(this.Dodge()) {
			System.out.println("You dodged the attack: 0 damage!");
			System.out.println("");
			return 0;
		}

		System.out.println("You have taken damage of " + damage + " points");
		System.out.println("");

		if (lifeBar - damage > 0) {
			
			lifeBar = lifeBar - damage;
			return 0;
			
		} else {
			return gameOver();
		}

	}

	public void printStatus() {

		System.out.print("Hero --> Life Bar: <" + lifeBar + ">  Mana Bar: <" + manaBar + "> + Ability points: <" + ability + ">");
		
		System.out.print(" Objects: <");
		if(this.pickaxe) {
			System.out.print(" Pickaxe ");
		}
		
		System.out.print("> ");
		System.out.println("");

	}

	public int gameOver() {
		System.out.println("GAME OVER!");
		return -1;
	}

	public boolean criticalAttack() {

		int random = (int) (Math.random() * 20);

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

	public int getAbility() {
		return ability;
	}

	public void usedAbility() {
		this.ability = ability - 1;
	}

	public void addAbility() {
		this.ability = ability + 1;
	}

}
