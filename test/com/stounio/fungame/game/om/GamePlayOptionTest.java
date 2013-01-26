package com.stounio.fungame.game.om;

import org.junit.Assert;
import org.junit.Test;

import com.stounio.fungame.factory.GamePlayOptionFactory;
import com.stounio.fungame.game.om.GamePlayOption;

public class GamePlayOptionTest {

	private static final String GAME_PLAY_OPTION_DEFAULT_IDENTIFIER = "defaultIdentifier";
	
	private static final String GAME_PLAY_OPTION_OTHER_IDENTIFIER = "otherIdentifier";
	
	private static final String GAME_PLAY_OPPONENT_IDENTIFIER = "opponentIdentifier";
	
	private static final String WINNING_POINT_INDENTIFIER = "winningPointIdentifier";

	@Test
	public void should_be_able_to_instanciate_a_game_play_option_initialized_with_the_provided_identifier(){
		GamePlayOption gamePlayOption = GamePlayOptionFactory.getFactory().newInstance(GAME_PLAY_OPTION_DEFAULT_IDENTIFIER);
		Assert.assertEquals(GAME_PLAY_OPTION_DEFAULT_IDENTIFIER, gamePlayOption.getIdentifier());
	}
	
	@Test(expected=IllegalStateException.class)
	public void should_not_be_able_initialize_twice_the_game_option(){
		GamePlayOption gamePlayOption = GamePlayOptionFactory.getFactory().newInstance(GAME_PLAY_OPTION_DEFAULT_IDENTIFIER);
		gamePlayOption.initialize(GAME_PLAY_OPTION_DEFAULT_IDENTIFIER);
	}
	
	@Test
	public void should_be_able_to_register_a_winning_point_identifer(){
		GamePlayOption gamePlayOption = GamePlayOptionFactory.getFactory().newInstance(GAME_PLAY_OPTION_DEFAULT_IDENTIFIER);
		gamePlayOption.registerWinningPointIdentifiers(WINNING_POINT_INDENTIFIER);
	}
	
	@Test
	public void two_game_play_options_with_the_same_identifier_should_be_equal(){
		GamePlayOption defaultGamePlayOption1 = createGamePlayOption(GAME_PLAY_OPTION_DEFAULT_IDENTIFIER);
		GamePlayOption defaultGamePlayOption2 = createGamePlayOption(GAME_PLAY_OPTION_DEFAULT_IDENTIFIER);
		Assert.assertEquals(defaultGamePlayOption1, defaultGamePlayOption2);
	}
	
	@Test
	public void two_game_play_options_with_distinct_identifiers_should_not_be_equal(){
		GamePlayOption defaultGamePlayOption = createGamePlayOption(GAME_PLAY_OPTION_DEFAULT_IDENTIFIER);
		GamePlayOption otherGamePlayOption = createGamePlayOption(GAME_PLAY_OPTION_OTHER_IDENTIFIER);
		Assert.assertNotSame(defaultGamePlayOption, otherGamePlayOption);
	}

	@Test
	public void should_win_the_point_against_the_opponent_game_play_option(){
		GamePlayOption defaultGamePlayOption = createGamePlayOption(GAME_PLAY_OPTION_DEFAULT_IDENTIFIER);
		defaultGamePlayOption.registerWinningPointIdentifiers(GAME_PLAY_OPPONENT_IDENTIFIER);
		GamePlayOption opponentGamePlayOption = createGamePlayOption(GAME_PLAY_OPPONENT_IDENTIFIER);
		boolean winsPointAgainstOpponent = defaultGamePlayOption.winsPointAgainstOpponent(opponentGamePlayOption);
		Assert.assertTrue(winsPointAgainstOpponent);
	}
	
	// UTILITY METHODS
	private GamePlayOption createGamePlayOption(String identifier){
		GamePlayOption gamePlayOption = GamePlayOptionFactory.getFactory().newInstance(identifier);
		return gamePlayOption;
	}
}

