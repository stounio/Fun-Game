package com.stounio.fungame.factory;

import com.stounio.fungame.game.om.GameScoringBoard;

public class GameScoringBoardFactory {

	private static final GameScoringBoardFactory factory = new GameScoringBoardFactory();
	
	private GameScoringBoardFactory(){
		
	}
	
	public static final GameScoringBoardFactory getFactory(){
		return factory;
	}
	
	public GameScoringBoard newInstance(){
		GameScoringBoard gameScoringBoard = GenericObjectFactory.getFactory().newInstance(GameScoringBoard.class);
		return gameScoringBoard;
	}
}
