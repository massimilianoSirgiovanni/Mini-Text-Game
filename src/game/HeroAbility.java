package game;

public class HeroAbility {

	public BoardContent[][] eagleEye(int[] positionHero, BoardContent[][] board) {

		if (positionHero[0] - 1 >= 0) {
			if (board[positionHero[0] - 1][positionHero[1]] != null) {
				board[positionHero[0] - 1][positionHero[1]].setShowIcon(true);
			} else {

				board[positionHero[0] - 1][positionHero[1]] = new NullObject();

			}
		}

		if (positionHero[0] + 1 < board.length) {

			if (board[positionHero[0] + 1][positionHero[1]] != null) {

				board[positionHero[0] + 1][positionHero[1]].setShowIcon(true);

			} else {

				board[positionHero[0] + 1][positionHero[1]] = new NullObject();
			}
		}

		if (positionHero[1] + 1 < board[0].length) {

			if (board[positionHero[0]][positionHero[1] + 1] != null) {

				board[positionHero[0]][positionHero[1] + 1].setShowIcon(true);
			} else {

				board[positionHero[0]][positionHero[1] + 1] = new NullObject();
			}
		}
		if (positionHero[1] - 1 >= 0) {

			if (board[positionHero[0]][positionHero[1] - 1] != null) {
				board[positionHero[0]][positionHero[1] - 1].setShowIcon(true);
			} else {

				board[positionHero[0]][positionHero[1] - 1] = new NullObject();

			}

		}

		return board;

	}

	public int[] teleport(Hero hero, BoardContent[][] board, int[] positionHero) {

		int row;

		int column;

		do {

			row = getRandomNumber(0, board.length);
			column = getRandomNumber(0, board[0].length);

		} while (board[row][column] != null);

		positionHero[0] = row;
		positionHero[1] = column;

		return positionHero;

	}

	public BoardContent[][] fortuneChallenge(BoardContent[][] board) {

		System.out.println("");
		System.out.println("**Coin toss**");
		System.out.println("");

		int coin = getRandomNumber(0, 2);

		if (coin == 0) {
			System.out.println("");
			System.out.println("Came out HEAD");
			System.out.println("You were LUCKY");
			System.out.println("");
			
			int row = 0;
			int column = 0;
			int i = 0;
			while (i < 4) {
				do {

					row = getRandomNumber(0, board.length);
					column = getRandomNumber(0, board[0].length);

				} while (board[row][column] == null || board[row][column].getShowIcon());

				board[row][column].setShowIcon(true);
				i++;
			}

		} else {

			System.out.println("");
			System.out.println("Came out CROSS");
			System.out.println("You were UNLUCKY");
			System.out.println("");

		}

		return board;

	}

	public int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

}