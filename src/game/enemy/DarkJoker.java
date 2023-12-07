package game.enemy;

public class DarkJoker extends Enemies {

	
	public DarkJoker () {
		super();
		this.setLifeBar(50);
		this.setManaBar(5);
		this.setConsumeMana(1);
		this.setMeleeAttack(3);
		this.setMagicAttack(7);
		this.setEnemyName("DarkJoker");
		this.setCritical(0.2);
		this.setCriticalBound(5);
		this.setDodge(10);
	}
	
}
