package com.gpichot.fungame.game.manager;

import junit.framework.Assert;

import org.junit.Test;

import com.gpichot.fungame.factory.GamePlayOptionManagerFactory;
import com.gpichot.fungame.game.om.GamePlayOption;

/**
 * Test the manager of the game play options.
 */
public class GamePlayOptionManagerTest {

    private static final String ROCK_GAME_PLAY_OPTION_IDENTIFIER = "ROCK";

    private static final String PAPER_GAME_PLAY_OPTION_IDENTIFIER = "PAPER";

    private static final String SCISSORS_GAME_PLAY_OPTION_IDENTIFIER = "SCISSORS";

    @Test
    public void should_initialize_game_play_options_successfully_with_all_required_options() {
        GamePlayOptionManager gamePlayOptionManager = GamePlayOptionManagerFactory.getFactory().getInstance();
        Assert.assertTrue(gamePlayOptionManager.isInitialized());
        GamePlayOption gamePlayOption = gamePlayOptionManager.findGamePlayOption(ROCK_GAME_PLAY_OPTION_IDENTIFIER);
        Assert.assertNotNull(gamePlayOption);
        Assert.assertEquals(ROCK_GAME_PLAY_OPTION_IDENTIFIER, gamePlayOption.getIdentifier());
        gamePlayOption = gamePlayOptionManager.findGamePlayOption(PAPER_GAME_PLAY_OPTION_IDENTIFIER);
        Assert.assertNotNull(gamePlayOption);
        Assert.assertEquals(PAPER_GAME_PLAY_OPTION_IDENTIFIER, gamePlayOption.getIdentifier());
        gamePlayOption = gamePlayOptionManager.findGamePlayOption(SCISSORS_GAME_PLAY_OPTION_IDENTIFIER);
        Assert.assertNotNull(gamePlayOption);
        Assert.assertEquals(SCISSORS_GAME_PLAY_OPTION_IDENTIFIER, gamePlayOption.getIdentifier());
    }

}
