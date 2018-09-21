package com.azare.openclose.guess;

import com.azare.openclose.guess.GuessFactory.GUESSTYPE;

public class PredictorGuess extends Guess implements IGuess{

	public static final int guesslength = 3;
	
	private int prediction;
		
	public PredictorGuess(String guess) 
	{
		super(guess, GUESSTYPE.PREDICTOR);
		
		prediction = -1;
	}
	
	@Override
	public boolean isvalid()
	{
		boolean bValidation = false;
		
		//filter invalid length guess. 
		if (getGuess().length() != guesslength)
		{
			appendValidationError("Invalid Guess. Must be 3 characters.\n");
		}
		else
		{
			char[] openclose = new char[2];
			
			for (int i=0; i < 2; i++)
			{
				openclose[i] = getGuess().toCharArray()[i];
			}
			
			if (!this.isOpenClose(openclose) )
			{
				appendValidationError("Invalid Guess. First 2 character "
						+ "must be either 'O' or 'C'\n");
			}
			
			prediction = Integer.parseInt(String.valueOf(getGuess().toCharArray()[2]));
			
			if (!isValidPrediction(prediction))
			{
				appendValidationError("Invalid Guess. Prediction must be between 0 and 4.\n");
			}
			
			bValidation = true;
		}
		
		return bValidation;
	}
	
	private boolean isValidPrediction(int prediction)
	{
		return (prediction >= 0 && prediction <= 4);
	}
	
	public int getPrediction()
	{
		return prediction;
	}
	
}
