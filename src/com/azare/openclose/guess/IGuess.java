package com.azare.openclose.guess;

public interface IGuess {
	
	char[] allowedguess = {'C', 'O'};
	
	boolean isvalid() throws Exception;
}
