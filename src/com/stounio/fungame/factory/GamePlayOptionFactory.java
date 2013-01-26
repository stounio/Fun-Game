package com.stounio.fungame.factory;

import java.security.InvalidParameterException;

import com.stounio.fungame.game.om.GamePlayOption;

public class GamePlayOptionFactory {
	
	private static final GamePlayOptionFactory factory = new GamePlayOptionFactory();
	
	private GamePlayOptionFactory(){
		
	}
	
	public static final GamePlayOptionFactory getFactory(){
		return factory;
	}
	
	

	/**
	 * @throws InvalidParameterException if the provided game play option identifier is null.
	 */
	public GamePlayOption newInstance(String gamePlayOptionIdentifier) {
		if(gamePlayOptionIdentifier == null){
			throw new InvalidParameterException("Game play option idenfier cannot be null");
		}
		GamePlayOption gamePlayOption = GenericObjectFactory.getFactory().newInstance(GamePlayOption.class);
		gamePlayOption.initialize(gamePlayOptionIdentifier);
		return gamePlayOption;
	}
}
