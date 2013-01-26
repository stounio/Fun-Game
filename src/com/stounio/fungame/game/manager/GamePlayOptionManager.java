package com.stounio.fungame.game.manager;

import java.util.List;

import com.stounio.fungame.game.om.GamePlayOption;

/**
 * Manager of the game play options.
 */
public interface GamePlayOptionManager {

	/**
	 * Initialize the game play options to be played by the player.
	 */
	void intialize();

	/**
	 * Check if the game play options have been initialized.
	 * 
	 * @return
	 */
	boolean isInitialized();
	
	/**
	 * Find the game play option for the corresponding identifier.
	 * @param gamePlayOptionIdentifier
	 * @return
	 */
	GamePlayOption findGamePlayOption(String gamePlayOptionIdentifier);
	
	/**
	 * Return the list of all the game play options available.
	 * @return
	 */
	List<GamePlayOption> retrieveAllGamePlayOptions();
}
