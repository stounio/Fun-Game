package com.gpichot.fungame.game.service;

import java.util.List;

import com.gpichot.fungame.game.om.GamePlayOption;
import com.gpichot.fungame.game.om.GameScoringBoard;


/**
 * Service in charge of the logic of the game.
 */
public interface GamePlayService {
	
	/**
	 * Initialize the game.
	 */
	void intialize();
	
	/**
	 * Initialize the human versus computer mode.
	 */
	void initializeHumanVersusComputerMode();
	
	/**
	 * Initialize the computer versus computer mode.
	 */
	void initializeComputerVersusComputerMode();
	
	/**
	 * Play a game option.
	 * @param gamePlayOptionIdentifier
	 * @return
	 */
	GamePlayResult play(String gamePlayOptionIdentifier);
	
	/**
	 * Return the last game play option played by the player.
	 * @return
	 */
	GamePlayOption getPlayerLastPlay();

	/**
	 * Return the last game play option played by the opponent.
	 * @return
	 */
	GamePlayOption getOpponentLastPlay();
	/**
	 * Return the scoring board for player.
	 * @return
	 */
	GameScoringBoard getPlayerScoringBoard();
	
	/**
	 * Return the list of game play options.
	 * @return
	 */
	List<GamePlayOption> getGamePlayOptions();
	
	/**
	 * Restart a new game.
	 * <p>
	 * It clears the player previously initialized and clears the player scoring board.
	 */
	void restart();

	/**
	 * Exit the game.
	 */
	void exit();

}

