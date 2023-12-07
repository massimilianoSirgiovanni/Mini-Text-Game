package game.enemy;

public class Dragon extends Enemies {
	
	public Dragon () {
		super();
		this.setLifeBar(70);
		this.setManaBar(25);
		this.setMeleeAttack(20);
		this.setMagicAttack(50);
		this.setConsumeMana(25);
		this.setEnemyName("Dragon");
		this.setCritical(0.1);
		this.setCriticalBound(2);
		this.setDodge(-1);
	}

}
