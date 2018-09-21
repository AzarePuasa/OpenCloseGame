package com.azare.openclose.player;

import java.util.Random;

import com.azare.openclose.guess.Guess;
import com.azare.openclose.guess.GuessFactory;
import com.azare.openclose.guess.GuessFactory.GUESSTYPE;

public class AIPlayer implements IPlayer {

	private Random ai;
	private Guess guess;
	
	public AIPlayer() 
	{
		ai = new Random();
	}

	@Override
	public int playAsPredictor() throws Exception
	{
		String input = IPlayer.PredictorValues[ai.nextInt(IPlayer.PredictorValues.length - 1)];
		
		guess = GuessFactory.getGuess(GUESSTYPE.PREDICTOR, input);
		
		if (!guess.isvalid())
		{
			throw new Exception(guess.getValidationError());
		}
		
		System.out.println("AI: " + input);
		
		return guess.getPrediction();
	}

	@Override
	public void playAsNotPredictor() throws Exception
	{
		String input = IPlayer.PlayerValues[ai.nextInt(IPlayer.PlayerValues.length - 1)];
		
		guess = GuessFactory.getGuess(GUESSTYPE.NOTPREDICTOR, input);
		
		if (!guess.isvalid())
		{
			throw new Exception(guess.getValidationError());
		}
		
		System.out.println("AI: " + input);
	}
	
	public String getGuess()
	{
		return guess.getGuess();
	}
}
