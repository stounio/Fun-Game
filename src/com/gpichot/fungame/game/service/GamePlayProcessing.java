package com.gpichot.fungame.game.service;

import com.gpichot.fungame.game.om.GamePlayOption;

public interface GamePlayProcessing {

	/**
	 * Process the game play options played by the two players of the game and return the result.
	 * @param gamePlayOption1
	 * @param gamePlayOption2
	 * @return
	 */
	GamePlayResult process(GamePlayOption gamePlayOption1, GamePlayOption gamePlayOption2);
		
}
