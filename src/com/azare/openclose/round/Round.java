package com.azare.openclose.round;

import com.azare.openclose.player.AIPlayer;
import com.azare.openclose.player.HumanPlayer;
import com.azare.openclose.player.PLAYER;

public class Round {
	
	//public static HashMap< String, String> WinnerMsg = new HashMap<>();
	
	private boolean bAIPredictor;
	private boolean bWinner;
	private PLAYER winner;
	
	private int prediction;
	
	public Round(boolean bAIPredictor)
	{
		this.bAIPredictor = bAIPredictor;	
		bWinner = false;

		prediction = 0;
	}
		
	/**
	 * 
	 * @return winner(YOU or AI).
	 */
	public void playRound()
	{	
		if (bAIPredictor) 
		{
			//When AI is predictor, human is not predictor.
			
			try
			{
				HumanPlayer human = new HumanPlayer();
				
				human.playAsNotPredictor();
				
				AIPlayer ai = new AIPlayer();
				
				prediction = ai.playAsPredictor();
				
				if (isPredictionCorrect(ai.getGuess(),human.getGuess()))
				{
					bWinner = true;
					winner = PLAYER.AI;
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		} 
		else 
		{
			//When Human Player is the predictor, AI is not predictor

			try
			{
				HumanPlayer human = new HumanPlayer();
				
				prediction = human.playAsPredictor();
				
				AIPlayer ai = new AIPlayer();
				
				ai.playAsNotPredictor();
				
				if (isPredictionCorrect(ai.getGuess(),human.getGuess()))
				{
					bWinner = true;
					winner = PLAYER.HUMAN;
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	private boolean isPredictionCorrect(String aiGuess, String playerGuess) {
		int countopen = 0;

		char ai[] = aiGuess.toCharArray();

		for (Character c : ai) {
			if (c == 'O') {
				countopen++;
			}
		}

		char player[] = playerGuess.toCharArray();

		for (Character c : player) {
			if (c == 'O') {
				countopen++;
			}
		}

		return countopen == prediction;
	}
	
	public boolean hasWinner()
	{
		return bWinner;
	}
	
	public PLAYER roundWinner()
	{
		return winner;
	}
}
