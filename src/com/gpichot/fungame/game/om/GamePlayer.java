package com.gpichot.fungame.game.om;

/**
 * Define the player in the game.
 */
public interface GamePlayer {

	/**
	 * Action of playing.
	 * @param gamePlayOptionIdentifier
	 * @return
	 */
	GamePlayOption play(String gamePlayOptionIdentifier);
}
