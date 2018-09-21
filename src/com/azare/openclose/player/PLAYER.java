package com.azare.openclose.player;

public enum PLAYER 
{
	HUMAN("You Win."), 
	AI("AI Win.");

	String winnerMsg;

	PLAYER(String winnerMsg) {
		this.winnerMsg = winnerMsg;
	}

	public String getWinnerMsg() {
		return winnerMsg;
	}
}
