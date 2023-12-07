package game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean play = true;
		
		System.out.println("THE JOURNEY OF A HERO");
		System.out.println("");
		System.out.println("");
		System.out.println("Press enter to Start");
		System.out.println("");
		System.out.println("");
		
		Scanner input = new Scanner(System.in);
		String userMove = input.nextLine();
		
		while(play) {
		
		Board board = new Board(8,8);
		board.initialPrint();
		
		while (!board.getEnd()) {
			board.print();
			board.move();
			
			
		}
		
		System.out.println("");
		System.out.println("WANT TO PLAY AGAIN? (Y/N)");
		System.out.println("");
		
		Scanner rematchInput = new Scanner(System.in);
		String rematch = rematchInput.nextLine();
		if (rematch.equalsIgnoreCase("N")) {
			play = false;
			System.out.println("");
			System.out.println("THANKS FOR PLAYING!");
			System.out.println("");
		}
			
		
	}

	}
	
	

}
