package com.gpichot.fungame.game.om.impl;

import com.gpichot.fungame.game.om.GameScoringBoard;
import com.gpichot.fungame.game.service.GamePlayResult;

public class GameScoringBoardImpl implements GameScoringBoard{

	int wins;
	
	int losses;
	
	int deadHeats;
	
	@Override
	public void updateScore(GamePlayResult gamePlayResult) {
		if(GamePlayResult.WINNER.equals(gamePlayResult)){
			increaseWins();
			return;
		}
		if (GamePlayResult.LOSER.equals(gamePlayResult)){
			increaseLosses();
			return;
		}
		if(GamePlayResult.DEAD_HEAT.equals(gamePlayResult)){
			increaseDeadHeats();
			return;
		}
	}

	private void increaseWins() {
		wins++;
	}

	@Override
	public int getWins() {
		return wins;
	}

	private void increaseLosses() {
		losses++;
	}

	@Override
	public int getLosses() {
		return losses;
	}

	private void increaseDeadHeats() {
		deadHeats++;
	}

	@Override
	public int getDeadHeats() {
		return deadHeats;
	}

}
