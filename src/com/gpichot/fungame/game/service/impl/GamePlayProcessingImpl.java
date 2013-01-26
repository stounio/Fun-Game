package com.gpichot.fungame.game.service.impl;

import java.security.InvalidParameterException;

import com.gpichot.fungame.game.om.GamePlayOption;
import com.gpichot.fungame.game.service.GamePlayProcessing;
import com.gpichot.fungame.game.service.GamePlayResult;

public class GamePlayProcessingImpl implements GamePlayProcessing {

	@Override
	public GamePlayResult process(GamePlayOption gamePlayOption1,
			GamePlayOption gamePlayOption2) {
		if(gamePlayOption1 == null){
			throw new InvalidParameterException("Game play option 1 should not be null");
		}
		if(gamePlayOption2 == null){
			throw new InvalidParameterException("Game play option 2 should not be null");
		}
		GamePlayResult gamePlayResult = internalProcess(gamePlayOption1, gamePlayOption2);
		return gamePlayResult;
	}

	private GamePlayResult internalProcess(GamePlayOption gamePlayOption1,
			GamePlayOption gamePlayOption2) {
		if(gamePlayOption1.equals(gamePlayOption2)){
			return GamePlayResult.DEAD_HEAT;
		}
		if(gamePlayOption1.winsPointAgainstOpponent(gamePlayOption2)){
			return GamePlayResult.WINNER;
		}
		if(gamePlayOption2.winsPointAgainstOpponent(gamePlayOption1)){
			return GamePlayResult.LOSER;
		}
		return GamePlayResult.UNDECIDED;
	}

}
