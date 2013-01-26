package com.stounio.fungame.factory;

import com.stounio.fungame.game.service.GamePlayProcessing;

public class GamePlayProcessingFactory {

	private static final GamePlayProcessingFactory factory = new GamePlayProcessingFactory();
	
	private GamePlayProcessingFactory(){
		
	}
	
	public static final GamePlayProcessingFactory getFactory(){
		return factory;
	}
	
	public GamePlayProcessing newInstance() {
		GamePlayProcessing gamePlayProcessing = GenericObjectFactory.getFactory().newInstance(GamePlayProcessing.class);
		return gamePlayProcessing;
	}
}
