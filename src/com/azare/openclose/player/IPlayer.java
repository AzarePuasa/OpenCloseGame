package com.azare.openclose.player;

public interface IPlayer {

	String[] PredictorValues = new String[] { "OO0", "OO1", "OO2", "OO3", "OO4", "OC0", "OC1", "OC2",
			"OC3", "OC4", "CO0", "CO1", "CO2", "CO3", "CO4", "CC0", "CC1", "CC2", "CC3", "CC4" };

	String[] PlayerValues = new String[] { "OO", "OC", "CO", "CC" };
	
	int playAsPredictor() throws Exception;
	
	void playAsNotPredictor() throws Exception;
}
