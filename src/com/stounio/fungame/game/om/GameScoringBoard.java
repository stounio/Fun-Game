package com.stounio.fungame.game.om;

import com.stounio.fungame.game.service.GamePlayResult;

/**
 * The scoring board for a game.
 * <p>
 * The scoring board the following information:
 * <ul>
 * <li>Number of wins
 * <li>Number of losses
 * <li>Number of dead heat
 */
public interface GameScoringBoard {
	
	void updateScore(GamePlayResult gamePlayResult);

	int getWins();
	
	int getLosses();
	
	int getDeadHeats();

}
