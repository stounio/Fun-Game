package com.gpichot.fungame.factory;

import com.gpichot.fungame.game.manager.GamePlayOptionManager;


public class GamePlayOptionManagerFactory {
	
	private GamePlayOptionManager gamePlayOptionManager;
	
	private static final GamePlayOptionManagerFactory factory = new GamePlayOptionManagerFactory();
	
	private GamePlayOptionManagerFactory(){
		gamePlayOptionManager = GenericObjectFactory.getFactory().newInstance(GamePlayOptionManager.class);
		gamePlayOptionManager.intialize();
	}

	public static final GamePlayOptionManagerFactory getFactory(){
		return factory;
	}
	
	public GamePlayOptionManager getInstance(){
		return gamePlayOptionManager;
	}
}
