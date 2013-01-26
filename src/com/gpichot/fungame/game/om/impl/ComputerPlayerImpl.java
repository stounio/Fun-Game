package com.gpichot.fungame.game.om.impl;

import java.util.List;
import java.util.Random;

import com.gpichot.fungame.factory.GamePlayOptionManagerFactory;
import com.gpichot.fungame.game.manager.GamePlayOptionManager;
import com.gpichot.fungame.game.om.ComputerPlayer;
import com.gpichot.fungame.game.om.GamePlayOption;

public class ComputerPlayerImpl implements ComputerPlayer {

	@Override
	public GamePlayOption play(String gamePlayOptionIdentifier) {
		GamePlayOptionManager gamePlayOptionManager = GamePlayOptionManagerFactory.getFactory().getInstance();
		List<GamePlayOption> gamePlayOptions = gamePlayOptionManager.retrieveAllGamePlayOptions();
		if(gamePlayOptions.isEmpty()){
			throw new IllegalStateException("The game play options should not be empty");
		}
		int size = gamePlayOptions.size();
		int computerPlayOptionIndex = new Random().nextInt(size);
		GamePlayOption computerGamePlayOption = gamePlayOptions.get(computerPlayOptionIndex);
		return computerGamePlayOption;
	}

}
