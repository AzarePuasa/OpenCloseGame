package com.azare.openclose.game;

import java.util.Scanner;

import com.azare.openclose.round.Round;

public class Game {
	
	private boolean play;
	
	public Game()
	{
		play = true;
	}
	
	public void start()
	{
		// repeat game until player does not want to continue.
		while (play) 
		{			
			boolean winner = false; // set/reset.
			boolean bAIPredictor = false;

			// repeat game as long as there is no winner.
			while (!winner) 
			{
				//create a new round.
				Round round = new Round(bAIPredictor);
				
				round.playRound();
				
				//is there a winner?
				if (round.hasWinner()) {
					System.out.println("Winner: " + round.roundWinner().getWinnerMsg());
					winner = true;
				} else {
					// inverse role
					bAIPredictor = bAIPredictor == true ? false : true;
				}
			}
			
			if (quit())
			{
				System.out.println("Thank You For Playing the game!");
				System.exit(0);
			}
			else
			{
				play = false;
			}
		}
	}
	
	private boolean quit()
	{
		try (Scanner scan = new Scanner(System.in);)
		{
			System.out.print("Do you want to play again?(Y[y])");
			boolean invalid = true;
			String repeatGame = "";
			while (invalid) 
			{
				repeatGame = scan.next();
				
				if (!repeatGame.isEmpty() 
						&& repeatGame != null 
						&& repeatGame.length() == 1) 
				{	
					invalid = false;
					
					if(!repeatGame.toLowerCase().equals("y"))
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}
