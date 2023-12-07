package game;

import java.util.Scanner;

import game.enemy.Enemies;

public class Battle {

	private Hero hero;
	private Enemies enemy;

	public Battle(Hero hero, Enemies enemy) {

		this.hero = hero;
		this.enemy = enemy;

	}
	
	public int battle() {
		
		int gameover = 0;
		
		while(!enemy.isDead() && gameover != -1) {
			this.printStatus();
			playerMove();
			if(enemy.isDead()) {
				System.out.println("");
				System.out.println("VICTORY");
				System.out.println("");
				return gameover;
			}
			gameover = enemyMove();
			
		}
		
		return gameover;
		
	}
	
	public void playerMove() {
		
		System.out.println("Its your turn: ");
		System.out.println("               press X for melee attack --> Your melee attack is " + hero.getMeleeAttack());
		System.out.println("               press Z for magic attack --> Your magic attack is " + hero.getMagicAttack());
		
		boolean attackDone = false;
		
		while (!attackDone) {
		Scanner input = new Scanner(System.in);
		String attack = input.nextLine();
		if(attack.equalsIgnoreCase("X")) {
			enemy.applyDamage((int)hero.meleeAttack());
			attackDone = true;
		}else if(attack.equalsIgnoreCase("Z")) {
			double magicAttack = hero.magicAttack();
			if(magicAttack!= -1) {
			enemy.applyDamage((int)magicAttack);
			attackDone = true;
			}
		}
		
		}
		
		
		
	}
	
	public int enemyMove() {
		
		System.out.println("Its " + enemy.getEnemyName() + " turn: ");
		return hero.applyDamage(enemy.attack());
		
	}
	
	public void printStatus() {
		System.out.println("");
		hero.printStatus();
		System.out.println("");
		enemy.printStatus();
		System.out.println("");
	}

}
