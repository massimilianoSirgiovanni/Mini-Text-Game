package game;

import java.util.Scanner;

import game.enemy.DarkJoker;
import game.enemy.Dragon;
import game.enemy.Enemies;
import game.enemy.Ghost;
import game.enemy.Troll;
import game.items.Items;
import game.items.LifeBuff;
import game.items.LifeTraps;
import game.items.ManaBuff;
import game.items.MeleeAttackBuff;
import game.items.Pickaxe;
import game.items.RestoreAbility;

public class Board {

	private BoardContent board[][];

	private Hero hero = new Hero();
	private int positionHero[] = { 0, 0 };
	private HeroAbility useAbility = new HeroAbility();

	private boolean end = false;

	public Board(int row, int column) {
		board = new BoardContent[row][column];
		this.initializateBoard(row, column);
	}

	public void move() {

		board[positionHero[0]][positionHero[1]] = new NullObject();

		Scanner input = new Scanner(System.in);
		String userMove = input.nextLine();
		if (userMove.equalsIgnoreCase("W") && positionHero[0] != 0
				&& this.checkObstacles(positionHero[0] - 1, positionHero[1])) {
			positionHero[0] = positionHero[0] - 1;
		} else if (userMove.equalsIgnoreCase("S") && positionHero[0] != board.length - 1
				&& this.checkObstacles(positionHero[0] + 1, positionHero[1])) {
			positionHero[0] = positionHero[0] + 1;
		} else if (userMove.equalsIgnoreCase("D") && positionHero[1] != board[0].length - 1
				&& this.checkObstacles(positionHero[0], positionHero[1] + 1)) {
			positionHero[1] = positionHero[1] + 1;
		} else if (userMove.equalsIgnoreCase("A") && positionHero[1] != 0
				&& this.checkObstacles(positionHero[0], positionHero[1] - 1)) {
			positionHero[1] = positionHero[1] - 1;
		} else if (userMove.equalsIgnoreCase("Q")) {
			hero.printStatus();
			System.out.println("");
		} else if (userMove.equalsIgnoreCase("E")) {
			if (hero.getAbility() > 0) {
				board = useAbility.eagleEye(positionHero, board);
				hero.usedAbility();
			} else {
				System.out.println("You don't have enaugh ABILITY POINTS");
			}
		} else if (userMove.equalsIgnoreCase("T")) {
			if (hero.getAbility() > 0) {
				board[positionHero[0]][positionHero[1]] = new NullObject();
				positionHero = useAbility.teleport(hero, board, positionHero);
				hero.usedAbility();
			} else {
				System.out.println("You don't have enaugh ABILITY POINTS");
			}

		} else if (userMove.equalsIgnoreCase("F")) {
			if (hero.getAbility() > 0) {
				board = useAbility.fortuneChallenge(board);
				hero.usedAbility();
			} else {
				System.out.println("You don't have enaugh ABILITY POINTS");
			}
		} else if (userMove.equalsIgnoreCase("I")) {

			this.ability();

		}

		updateHeroPosition();

	}

	public void updateHeroPosition() {
		BoardContent content = board[positionHero[0]][positionHero[1]];
		if (content == null || content.getIcon().equals("X")) {
			board[positionHero[0]][positionHero[1]] = hero;
		} else if (content.getIcon().equals("E")) {
			content.setShowIcon(true);
			this.print();
			System.out.println("");
			System.out.println("");
			System.out.println("You have found a " + ((Enemies) content).getEnemyName());
			System.out.println("BATTLE START");
			System.out.println("");
			System.out.println("");
			Battle battleground = new Battle(hero, (Enemies) content);
			if (battleground.battle() == -1) {
				end = true;
			}
			board[positionHero[0]][positionHero[1]] = hero;

		} else if (content.getIcon().equals("P")) {

			System.out.println("");
			System.out.println("");
			System.out.println("YOU HAVE FOUND THE PRINCESS");
			System.out.println("CONGRATULATIONS!!!");
			System.out.println("YOU WON");
			System.out.println("");
			System.out.println("");
			board[positionHero[0]][positionHero[1]] = hero;
			end = true;

		}

		else if (content.getIcon().equals("I") || content.getIcon().equals("T")) {

			((Items) content).use(hero);
			board[positionHero[0]][positionHero[1]] = hero;

		}

		if (hero.getLifeBar() <= 0) {
			end = true;
		}

	}

	public void print() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == null || !board[i][j].getShowIcon()) {
					System.out.print("[ ]");
				} else {
					System.out.print("[" + board[i][j].getIcon() + "]");
				}
			}
			System.out.println("");
		}
	}

	public void initialPrint() {
		System.out.println("Decidi come muoverti");
		System.out.println("Tasti:");
		System.out.println("       W");
		System.out.println(
				"     A   D                                       Premi Q per conoscere i parametri dell'eroe");
		System.out.println(
				"       S                                         Premi I per conoscere le abilità dell'eroe (puoi usare un'abilità, solo una volta, per partita)");
	}

	public boolean getEnd() {
		return end;
	}

	public int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	public void initializateBoard(int row, int column) {

		board[0][0] = hero;

		this.initializateBox(row, column, new Princess());
		this.initializateBox(row, column, new LifeBuff("Weel of Lazarus", 50));
		this.initializateBox(row, column, new LifeBuff("Healing stone", 20));
		this.initializateBox(row, column, new ManaBuff("Book of Knowledge", 30));
		this.initializateBox(row, column, new ManaBuff("Millennium Eye", 30));
		this.initializateBox(row, column, new MeleeAttackBuff("Exodia's Chain", 12));
		this.initializateBox(row, column, new LifeTraps("Souichi Doll", 35));
		this.initializateBox(row, column, new Pickaxe());
		this.initializateBox(row, column, new Wall());
		this.initializateBox(row, column, new Wall());
		this.initializateBox(row, column, new Wall());
		this.initializateBox(row, column, new Wall());
		this.initializateBox(row, column, new Wall());
		this.initializateBox(row, column, new Wall());
		this.initializateBox(row, column, new LifeTraps("Ryuk's Apple", 15));
		this.initializateBox(row, column, new RestoreAbility("Komi's blessing"));
		this.initializateBox(row, column, new Troll());
		this.initializateBox(row, column, new Troll());
		this.initializateBox(row, column, new Troll());
		this.initializateBox(row, column, new Ghost());
		this.initializateBox(row, column, new Ghost());
		this.initializateBox(row, column, new Dragon());
		this.initializateBox(row, column, new DarkJoker());

	}

	public void initializateBox(int row, int column, BoardContent content) {

		int randomRow = 0;
		int randomColumn = 0;

		while (board[randomRow][randomColumn] != null) {
			randomRow = getRandomNumber(0, row);
			randomColumn = getRandomNumber(0, column);
		}
		board[randomRow][randomColumn] = content;

	}

	public boolean checkObstacles(int row, int column) {

		if (board[row][column] != null && board[row][column].getIcon().equals("W")) {
			if (!hero.getPickaxe()) {

				board[row][column].setShowIcon(true);
				System.out.println("A WALL interrupts your path: find the Pickaxe to destroy the WALL");
				return false;

			} else {
				System.out.println("You have destroyed a WALL");
				board[row][column] = hero;
			}
		}

		return true;
	}

	public void ability() {

		System.out.println("");
		System.out.println("The available abilities are: ");
		System.out.println(
				"                             Eagle Eye --> For your next move you will be able to learn about the vicissitudes that lie in your path (Press E and enter to use this ability)");
		System.out.println(
				"                             Teleport --> You will be teleported in a different box of the map (Press T and enter to use this ability)");

		System.out.println("");

	}

}
