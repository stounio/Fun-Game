package com.stounio.fungame.game.service;

/**
 * The different results a player can obtain when playing a game.
 */
public enum GamePlayResult {

	/** The first player wins the game, the second player loses it.*/
	WINNER("gameplayresult.winner.label", "./resources/pictures/winner.png"), 
	/** The first player loses the game, the second player wins it. */
	LOSER("gameplayresult.loser.label", "./resources/pictures/loser.png"), 
	/** Both players played the same game. */
	DEAD_HEAT("gameplayresult.deadHeat.label", "./resources/pictures/dead_heat.png"), 
	/** No player wins the game.*/
	UNDECIDED("gameplayresult.undecided.label", "./resources/pictures/undecided.png");
	
	private String resourceKey;
	
	private String picturePath;
	
	private GamePlayResult(String resourceKey, String picturePath){
		this.resourceKey = resourceKey;
		this.picturePath = picturePath;
	}
	
	public String getResourceKey(){
		return resourceKey;
	}
	
	public String getPicturePath(){
		return picturePath;
	}
}
