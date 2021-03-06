package com.stounio.fungame.factory;

import com.stounio.fungame.game.service.GamePlayService;

public class GamePlayServiceFactory {

	private static final GamePlayServiceFactory factory = new GamePlayServiceFactory();
	
	private final GamePlayService gamePlayService;
	
	private GamePlayServiceFactory(){
		gamePlayService = GenericObjectFactory.getFactory().newInstance(GamePlayService.class);
		gamePlayService.intialize();
	}
	
	public static final GamePlayServiceFactory getFactory(){
		return factory;
	}
	
	public GamePlayService getInstance(){
		return gamePlayService;
	}
}
