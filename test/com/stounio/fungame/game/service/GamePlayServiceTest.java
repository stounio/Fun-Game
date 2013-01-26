package com.stounio.fungame.game.service;

import junit.framework.Assert;

import org.junit.Test;

import com.stounio.fungame.factory.GamePlayServiceFactory;
import com.stounio.fungame.game.om.GamePlayOption;
import com.stounio.fungame.game.om.GameScoringBoard;
import com.stounio.fungame.game.service.GamePlayResult;
import com.stounio.fungame.game.service.GamePlayService;

public class GamePlayServiceTest {

	private static final String ROCK_GAME_PLAY_OPTION = "ROCK";

	@Test
	public void should_not_be_able_to_instanciate_the_game_play_service(){
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		Assert.assertNotNull(gamePlayService);
	}
	
	@Test(expected=IllegalStateException.class)
	public void should_not_be_able_to_initialize_the_game_twice(){
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		gamePlayService.intialize();
	}

	@Test(expected=IllegalStateException.class)
	public void should_not_be_able_to_play_before_initializing_the_player_mode(){
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		gamePlayService.play(ROCK_GAME_PLAY_OPTION);
	}
	
	@Test
	public void should_be_able_to_play_human_versus_computer(){
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		gamePlayService.initializeHumanVersusComputerMode();
		GamePlayResult gamePlayResult = gamePlayService.play(ROCK_GAME_PLAY_OPTION);
		Assert.assertNotNull(gamePlayResult);
		Assert.assertNotSame(GamePlayResult.UNDECIDED, gamePlayResult);
		GameScoringBoard scoringBoard = gamePlayService.getPlayerScoringBoard();
		Assert.assertTrue(scoringBoard.getWins()+scoringBoard.getLosses()+scoringBoard.getDeadHeats()>0);
	}

	@Test 
	public void should_be_able_to_play_computer_versus_computer(){
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		gamePlayService.initializeComputerVersusComputerMode();
		GamePlayResult gamePlayResult = gamePlayService.play(null);
		Assert.assertNotNull(gamePlayResult);
		Assert.assertNotSame(GamePlayResult.UNDECIDED, gamePlayResult);
		GameScoringBoard scoringBoard = gamePlayService.getPlayerScoringBoard();
		Assert.assertTrue(scoringBoard.getWins()+scoringBoard.getLosses()+scoringBoard.getDeadHeats()>0);
	}
	
	@Test
	public void should_record_player_and_opponent_last_game_play_option(){
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		gamePlayService.initializeHumanVersusComputerMode();
		gamePlayService.play(ROCK_GAME_PLAY_OPTION);
		GamePlayOption playerLastPlay = gamePlayService.getPlayerLastPlay();
		Assert.assertNotNull(playerLastPlay);
		GamePlayOption opponentLastPlay = gamePlayService.getOpponentLastPlay();
		Assert.assertNotNull(opponentLastPlay);
	}
	
	@Test
	public void should_be_able_to_restart_a_new_game_and_reset_the_player_scoring_board(){
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		gamePlayService.initializeHumanVersusComputerMode();
		gamePlayService.play(ROCK_GAME_PLAY_OPTION);
		gamePlayService.restart();
		GameScoringBoard scoringBoard = gamePlayService.getPlayerScoringBoard();
		Assert.assertTrue(scoringBoard.getWins()+scoringBoard.getLosses()+scoringBoard.getDeadHeats()==0);
	}
}

