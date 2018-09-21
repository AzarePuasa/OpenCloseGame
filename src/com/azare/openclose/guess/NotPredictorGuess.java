package com.azare.openclose.guess;

import com.azare.openclose.guess.GuessFactory.GUESSTYPE;

public class NotPredictorGuess extends Guess implements IGuess {
	
	public String guess;
	public static final int guesslength = 2;
	
	public NotPredictorGuess(String guess) 
	{
		super(guess, GUESSTYPE.NOTPREDICTOR);
	}

	@Override
	public boolean isvalid() 
	{
		boolean bValidation = false;
		
		//filter invalid length guess. 
		if (getGuess().length() != guesslength)
		{
			System.out.println("Invalid Guess. Must be 2 characters.");
		}
		else
		{
			char[] openclose = getGuess().toCharArray();
			
			if (!this.isOpenClose(openclose) )
			{
				appendValidationError("Invalid Guess. The 2 characters "
						+ "must be either 'O' or 'C'\n");
			}
			
			bValidation = true;
		}
		
		return bValidation;
	}
}
