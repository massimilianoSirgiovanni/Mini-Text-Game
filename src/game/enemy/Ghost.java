package game.enemy;

public class Ghost extends Enemies {

	
	public Ghost () {
		super();
		this.setLifeBar(80);
		this.setManaBar(30);
		this.setConsumeMana(10);
		this.setMeleeAttack(2);
		this.setMagicAttack(10);
		this.setEnemyName("Ghost");
		this.setCritical(0.1);
		this.setCriticalBound(4);
		this.setDodge(2);
	}
	
	
}
