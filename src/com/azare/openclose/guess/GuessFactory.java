package com.azare.openclose.guess;

public class GuessFactory {
	
	public enum GUESSTYPE
	{
		PREDICTOR,
		NOTPREDICTOR;
	}
	
	public static Guess getGuess(GUESSTYPE type, String guess) {
		if (type == GUESSTYPE.PREDICTOR)
		{
			return new PredictorGuess(guess);
		}
		else if (type == GUESSTYPE.NOTPREDICTOR)
		{
			return new NotPredictorGuess(guess);
		}
		
		return null;
	}
}
