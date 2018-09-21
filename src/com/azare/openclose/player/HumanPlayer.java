package com.azare.openclose.player;

import java.util.Scanner;

import com.azare.openclose.guess.Guess;
import com.azare.openclose.guess.GuessFactory;
import com.azare.openclose.guess.GuessFactory.GUESSTYPE;

public class HumanPlayer implements IPlayer{

	private static final String NOTPREDICTOR = "AI is the predictor, What is your input?";
	private static final String PREDICTOR = "You are the predictor, What is your input?";
	
	private Scanner scanner;
	private Guess guess;
	
	public HumanPlayer() 
	{
		scanner = new Scanner(System.in);
	}
	
	@Override
	public int playAsPredictor() throws Exception
	{
		boolean consolevalid = false;
		int prediction = -1;

		while (!consolevalid) 
		{
			System.out.print(PREDICTOR);

			String input = scanner.next();
			
			guess = GuessFactory.getGuess(GUESSTYPE.PREDICTOR, input);
			
			if (guess.isvalid()) 
			{
				consolevalid = true;
				prediction = guess.getPrediction();
			} 
			else 
			{
				throw new Exception(guess.getValidationError());
			}
		}
		
		return prediction;
	}

	@Override
	public void playAsNotPredictor() throws Exception{
		
		boolean consolevalid = false;
		while (!consolevalid) 
		{
			System.out.print(NOTPREDICTOR);

			String input = scanner.next();
			
			guess = GuessFactory.getGuess(GUESSTYPE.NOTPREDICTOR, input);

			if (guess.isvalid()) 
			{
				consolevalid = true;
			} 
			else 
			{
				throw new Exception(guess.getValidationError());
			}
		}
	}
	
	public String getGuess()
	{
		return guess.getGuess();
	}
}
