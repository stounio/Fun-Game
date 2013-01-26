package com.gpichot.fungame.game.service;

import org.junit.Assert;
import org.junit.Test;

import com.gpichot.fungame.factory.GamePlayOptionFactory;
import com.gpichot.fungame.factory.GamePlayProcessingFactory;
import com.gpichot.fungame.game.om.GamePlayOption;

/**
 * Test the rules for the game play.
 */
public class GamePlayProcessingTest {

	private static final String GAME_PLAY_OPTION_WINNER_IDENTIFIER = "winnerIdentifier";
	private static final String GAME_PLAY_OPTION_LOSER_IDENTIFIER = "loserIdentifier";
	private static final String GAME_PLAY_OPTION_DEAD_HEAT_IDENTIFIER = "deadHeatIdentifier";
	private static final String GAME_PLAY_OPTION_UNDECIDED_IDENTIFIER = "undicidedIdentifier";
	private static final String GAME_PLAY_OPTION_PLAYER_1 = "player1Identifier";
	private static final String GAME_GAME_PLAY_OPTION_PLAYER_2 = "player2Identifier";
	
	@Test
	public void should_be_able_to_instanciate_a_game_play_processing(){
		GamePlayProcessing gamePlayProcessing = createGamePlayProcessing();
		Assert.assertNotNull(gamePlayProcessing);
	}
	
	@Test
	public void the_first_player_should_win_the_game(){
		GamePlayOption firstPlayerGameOption = createGamePlayOption(GAME_PLAY_OPTION_WINNER_IDENTIFIER);
		firstPlayerGameOption.registerWinningPointIdentifiers(GAME_PLAY_OPTION_LOSER_IDENTIFIER);
		GamePlayOption secondPlayerGamePlayOption = createGamePlayOption(GAME_PLAY_OPTION_LOSER_IDENTIFIER);
		secondPlayerGamePlayOption.registerWinningPointIdentifiers(GAME_PLAY_OPTION_UNDECIDED_IDENTIFIER);
		GamePlayProcessing gamePlayProcessing = createGamePlayProcessing();
		GamePlayResult gamePlayResult = gamePlayProcessing.process(firstPlayerGameOption, secondPlayerGamePlayOption);
		Assert.assertEquals(GamePlayResult.WINNER, gamePlayResult);
	}
	
	@Test
	public void the_first_player_should_lose_the_game(){
		GamePlayOption firstPlayerGamePlayOption = createGamePlayOption(GAME_PLAY_OPTION_LOSER_IDENTIFIER);
		firstPlayerGamePlayOption.registerWinningPointIdentifiers(GAME_PLAY_OPTION_UNDECIDED_IDENTIFIER);
		GamePlayOption secondPlayerGamePlayOption = createGamePlayOption(GAME_PLAY_OPTION_WINNER_IDENTIFIER);
		secondPlayerGamePlayOption.registerWinningPointIdentifiers(GAME_PLAY_OPTION_LOSER_IDENTIFIER);
		GamePlayProcessing gamePlayProcessing = createGamePlayProcessing();
		GamePlayResult gamePlayResult = gamePlayProcessing.process(firstPlayerGamePlayOption, secondPlayerGamePlayOption);
		Assert.assertEquals(GamePlayResult.LOSER, gamePlayResult);
	}
	
	@Test
	public void the_two_players_should_get_a_dead_heat(){
		GamePlayOption firstPlayerGamePlayOption = createGamePlayOption(GAME_PLAY_OPTION_DEAD_HEAT_IDENTIFIER);
		GamePlayOption secondPlayerGamePlayOption = createGamePlayOption(GAME_PLAY_OPTION_DEAD_HEAT_IDENTIFIER);
		GamePlayProcessing gamePlayProcessing = createGamePlayProcessing();
		GamePlayResult gamePlayResult = gamePlayProcessing.process(firstPlayerGamePlayOption, secondPlayerGamePlayOption);
		Assert.assertEquals(GamePlayResult.DEAD_HEAT, gamePlayResult);
	}
	
	@Test
	public void no_player_wins_the_game(){
		GamePlayOption firstPlayerGamePlayOption = createGamePlayOption(GAME_PLAY_OPTION_PLAYER_1);
		GamePlayOption secondPlayerGamePlayOption = createGamePlayOption(GAME_GAME_PLAY_OPTION_PLAYER_2);
		GamePlayProcessing gamePlayProcessing = createGamePlayProcessing();
		GamePlayResult gamePlayResult = gamePlayProcessing.process(firstPlayerGamePlayOption, secondPlayerGamePlayOption);
		Assert.assertEquals(GamePlayResult.UNDECIDED, gamePlayResult);
		
	}
	
	private GamePlayOption createGamePlayOption(String identifier){
		GamePlayOption gamePlayOption = GamePlayOptionFactory.getFactory().newInstance(identifier);
		return gamePlayOption;
	}
	
	private GamePlayProcessing createGamePlayProcessing() {
		GamePlayProcessing gamePlayProcessing = GamePlayProcessingFactory.getFactory().newInstance();
		return gamePlayProcessing;
	}

}
