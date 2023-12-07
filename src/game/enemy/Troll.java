package game.enemy;

public class Troll extends Enemies{
	

	public Troll () {
		super();
		this.setLifeBar(60);
		this.setMeleeAttack(5);
		this.setEnemyName("Troll");
		this.setCritical(0.3);
		this.setCriticalBound(2);
		
	}
	


}
