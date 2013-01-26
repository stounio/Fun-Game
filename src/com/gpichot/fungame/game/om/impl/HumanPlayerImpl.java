package com.gpichot.fungame.game.om.impl;

import com.gpichot.fungame.factory.GamePlayOptionManagerFactory;
import com.gpichot.fungame.game.manager.GamePlayOptionManager;
import com.gpichot.fungame.game.om.GamePlayOption;
import com.gpichot.fungame.game.om.HumanPlayer;

public class HumanPlayerImpl implements HumanPlayer {

	@Override
	public GamePlayOption play(String gamePlayOptionIdentifier) {
		GamePlayOptionManager gamePlayOptionManager = GamePlayOptionManagerFactory.getFactory().getInstance();
		GamePlayOption gamePlayOption = gamePlayOptionManager.findGamePlayOption(gamePlayOptionIdentifier);
		return gamePlayOption;
	}

}
