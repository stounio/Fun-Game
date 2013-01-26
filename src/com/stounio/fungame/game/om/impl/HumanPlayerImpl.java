package com.stounio.fungame.game.om.impl;

import com.stounio.fungame.factory.GamePlayOptionManagerFactory;
import com.stounio.fungame.game.manager.GamePlayOptionManager;
import com.stounio.fungame.game.om.GamePlayOption;
import com.stounio.fungame.game.om.HumanPlayer;

public class HumanPlayerImpl implements HumanPlayer {

	@Override
	public GamePlayOption play(String gamePlayOptionIdentifier) {
		GamePlayOptionManager gamePlayOptionManager = GamePlayOptionManagerFactory.getFactory().getInstance();
		GamePlayOption gamePlayOption = gamePlayOptionManager.findGamePlayOption(gamePlayOptionIdentifier);
		return gamePlayOption;
	}

}
