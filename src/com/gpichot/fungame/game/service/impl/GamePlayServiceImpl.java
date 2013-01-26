package com.gpichot.fungame.game.service.impl;

import java.util.List;

import com.gpichot.fungame.factory.ComputerPlayerFactory;
import com.gpichot.fungame.factory.GamePlayOptionManagerFactory;
import com.gpichot.fungame.factory.GamePlayProcessingFactory;
import com.gpichot.fungame.factory.GameScoringBoardFactory;
import com.gpichot.fungame.factory.HumanPlayerFactory;
import com.gpichot.fungame.game.manager.GamePlayOptionManager;
import com.gpichot.fungame.game.om.ComputerPlayer;
import com.gpichot.fungame.game.om.GamePlayOption;
import com.gpichot.fungame.game.om.GamePlayer;
import com.gpichot.fungame.game.om.GameScoringBoard;
import com.gpichot.fungame.game.service.GamePlayProcessing;
import com.gpichot.fungame.game.service.GamePlayResult;
import com.gpichot.fungame.game.service.GamePlayService;

public class GamePlayServiceImpl implements GamePlayService {

	private GamePlayer player;
	
	private GamePlayOption playerGamePlayOption;
	
	private ComputerPlayer computerOpponent;
	
	private GamePlayOption opponentGamePlayOption;
	
	private boolean initialized;

	private GameScoringBoard playerScoringBoard;
	
	@Override
	public void intialize() {
		if(isInitialized()){
			throw new IllegalStateException("Game play service is already initialized");
		}
		initializeGamePlayOptions();
		createComputerOpponent();
		createNewScoringBoard();
		initialized = true ;
	}


	private boolean isInitialized() {
		return initialized;
	}

	private void initializeGamePlayOptions() {
		GamePlayOptionManager gamePlayOptionManager = GamePlayOptionManagerFactory.getFactory().getInstance();
		if(!gamePlayOptionManager.isInitialized()){
			throw new IllegalStateException("Game play options have not been successgfully initialized");
		}
	}
	
	private void createComputerOpponent() {
		computerOpponent = ComputerPlayerFactory.getFactory().newInstance();
	}
	private void createNewScoringBoard() {
		playerScoringBoard = GameScoringBoardFactory.getFactory().newInstance();
	}
	
	@Override
	public void initializeHumanVersusComputerMode() {
		player = HumanPlayerFactory.getFactory().newInstance();
	}

	@Override
	public void initializeComputerVersusComputerMode() {
		player = ComputerPlayerFactory.getFactory().newInstance();
	}

	/**
	 * @throws IllegalStateException if the game game play options have not been initialized.
	 * @throws IllegalStateException if the players have not been initialized.
	 */
	@Override
	public GamePlayResult play(String gamePlayOptionIdentifier) {
		if(!areGamePlayOptionsInitialized()){
			throw new IllegalStateException("Cannot play before having intialized the game play options");
		}
		if (!arePlayersInitialized()){
			throw new IllegalStateException("Cannot play before having intialized the players");
		}
		GamePlayResult gameResult = internalPlay(gamePlayOptionIdentifier);
		return gameResult;
	}


	/**
	 * Check if the game play options have been initialized.
	 * @return
	 */
	private boolean areGamePlayOptionsInitialized() {
		GamePlayOptionManager gamePlayOptionManager = GamePlayOptionManagerFactory.getFactory().getInstance();
		return gamePlayOptionManager.isInitialized();
	}

	/**
	 * Check if the players have been initialized.
	 * @return
	 */
	private boolean arePlayersInitialized() {
		return player !=null && computerOpponent != null;
	}
	
	
	private GamePlayResult internalPlay(String gamePlayOptionIdentifier) {
		playerGamePlayOption = player.play(gamePlayOptionIdentifier);
		opponentGamePlayOption = computerOpponent.play(null);
		GamePlayProcessing gamePlayProcessing = GamePlayProcessingFactory.getFactory().newInstance();
		GamePlayResult gamePlayResult = gamePlayProcessing.process(playerGamePlayOption, opponentGamePlayOption);
		updatePlayerScoringBoard(gamePlayResult);
		return gamePlayResult;
	}
	
	private void updatePlayerScoringBoard(GamePlayResult gamePlayResult) {
		playerScoringBoard.updateScore(gamePlayResult);
	}


	@Override
	public GamePlayOption getPlayerLastPlay() {
		return playerGamePlayOption;
	}


	@Override
	public GamePlayOption getOpponentLastPlay() {
		return opponentGamePlayOption;
	}


	@Override
	public GameScoringBoard getPlayerScoringBoard() {
		return playerScoringBoard;
	}



	@Override
	public void restart() {
		clearPlayer();
		createNewScoringBoard();
	}

	private void clearPlayer() {
		player = null;
	}

	@Override
	public void exit() {
		System.exit(1);
	}


	@Override
	public List<GamePlayOption> getGamePlayOptions() {
		GamePlayOptionManager manager = GamePlayOptionManagerFactory.getFactory().getInstance();
		List<GamePlayOption> gamePlayOptions = manager.retrieveAllGamePlayOptions();
		return gamePlayOptions;
	}
	
	
	
}
