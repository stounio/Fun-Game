package com.gpichot.fungame.factory;

import java.security.InvalidParameterException;

import junit.framework.Assert;

import org.junit.Test;

import com.gpichot.fungame.factory.GamePlayOptionFactory;
import com.gpichot.fungame.game.om.GamePlayOption;

/**
 * Test the factory for the game play option.
 */
public class GamePlayOptionFactoryTest {
	
	public static final String DEFAULT_GAME_PLAY_OPTION_IDENTIFIER="defaultIdentifier";

	@Test(expected=InvalidParameterException.class)
	public void should_throw_an_invalid_parameter_exception_when_creating_a_game_play_option_with_a_null_identifier(){
		GamePlayOptionFactory.getFactory().newInstance(null);
	}
	
	@Test
	public void should_create_a_game_play_option_and_set_the_identifier(){
		GamePlayOption gamePlayOption = GamePlayOptionFactory.getFactory().newInstance(DEFAULT_GAME_PLAY_OPTION_IDENTIFIER);
		Assert.assertNotNull(gamePlayOption);
		Assert.assertEquals(DEFAULT_GAME_PLAY_OPTION_IDENTIFIER, gamePlayOption.getIdentifier());
		
	}
}
