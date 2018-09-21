package com.azare.openclose.guess;

import com.azare.openclose.guess.GuessFactory.GUESSTYPE;

public abstract class Guess implements IGuess
{
	private String guess;
	private StringBuilder sbValidationError;
	private GUESSTYPE type;
	
	public Guess(String guess, GUESSTYPE type) 
	{
		this.guess = guess;
		this.type = type;
		sbValidationError = new StringBuilder();
	}
	
	public String getValidationError()
	{
		return sbValidationError.toString();
	}
	
	public boolean validationFail()
	{
		return sbValidationError.length() > 0;
	}
	
	public String getGuess()
	{
		return guess;
	}
	
	protected void appendValidationError(String error)
	{
		if (sbValidationError.length() > 0)
		{
			sbValidationError.append("\n").append(error);
		}
		else
		{
			sbValidationError.append(error);
		}
	}
	
	protected boolean isOpenClose(char[] input)
	{
		boolean validchars = true;
			
		int guesslength = input.length;
		
		for (int i=0; i < guesslength; i++)
		{
			char c_compare = input[i];
			
			boolean valid = false;
			
			for (char c: allowedguess)
			{
				if (c_compare == c)
				{
					//'O' or 'C', valid. check next one.
					valid = true; 
					break;
				}
			}
			
			if (!valid) 
			{
				//not 'O' nor 'C', invalid. return false.

				validchars = false;
				break;
			}
		}
		
		return validchars;
	}
	
	public int getPrediction() throws Exception 
	{
		if (type == GUESSTYPE.NOTPREDICTOR) {
			throw new Exception("No prediction if you are not predictor.");
		}

		if (this.guess.length() != 3) {
			throw new Exception("No prediction found.");
		}

		return Integer.parseInt(String.valueOf(this.guess.toCharArray()[2]));
	}
}
