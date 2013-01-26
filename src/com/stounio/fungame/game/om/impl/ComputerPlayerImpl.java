package com.stounio.fungame.game.om.impl;

import java.util.List;
import java.util.Random;

import com.stounio.fungame.factory.GamePlayOptionManagerFactory;
import com.stounio.fungame.game.manager.GamePlayOptionManager;
import com.stounio.fungame.game.om.ComputerPlayer;
import com.stounio.fungame.game.om.GamePlayOption;

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
