package com.gpichot.fungame.console.component.view;

import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_NUMBER_OF_DEAD_HEAT_LABEL_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_NUMBER_OF_LOSSES_LABEL_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_NUMBER_OF_WINS_LABEL_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_OPPONENT_LAST_PLAY_LABEL_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_PLAYER_LAST_PLAY_LABEL_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.SUB_SECTION_SEPARATOR;

import com.gpichot.fungame.console.component.FunGameConsoleComponent;
import com.gpichot.fungame.console.component.FunGameConsoleComponentParameter;
import com.gpichot.fungame.console.component.FunGameConsoleComponentResult;
import com.gpichot.fungame.factory.GamePlayServiceFactory;
import com.gpichot.fungame.game.om.GamePlayOption;
import com.gpichot.fungame.game.om.GameScoringBoard;
import com.gpichot.fungame.game.service.GamePlayResult;
import com.gpichot.fungame.game.service.GamePlayService;
import com.gpichot.fungame.resource.service.ResourceService;

public class FunGameConsolePlayResultView implements FunGameConsoleComponent {

	@Override
	public FunGameConsoleComponentResult execute(
			FunGameConsoleComponentParameter parameter) {
		displayPlayerLastPlay();
		displayOpponentLastPlay();
		displayGamePlayResult(parameter);
		displayScoringBoard();
		return new FunGameConsoleComponentResult(null, null);
	}
	
	private void displayPlayerLastPlay() {
		System.out.println(SUB_SECTION_SEPARATOR);
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		GamePlayOption gamePlayOption = gamePlayService.getPlayerLastPlay();
		System.out.println(ResourceService.getService().getResource(FUNGAME_PLAYER_LAST_PLAY_LABEL_KEY) + "'" + gamePlayOption.getIdentifier() + "'");
	}

	private void displayOpponentLastPlay() {
		System.out.println(SUB_SECTION_SEPARATOR);
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		GamePlayOption gamePlayOption = gamePlayService.getOpponentLastPlay();
		System.out.println(ResourceService.getService().getResource(FUNGAME_OPPONENT_LAST_PLAY_LABEL_KEY) + "'" + gamePlayOption.getIdentifier() + "'");
	}

	private void displayGamePlayResult(
			FunGameConsoleComponentParameter parameter) {
		GamePlayResult gamePlayResult = (GamePlayResult) parameter.getParameterValue();
		System.out.println(SUB_SECTION_SEPARATOR);
		System.out.println(ResourceService.getService().getResource(gamePlayResult.getResourceKey()));
	}

	private void displayScoringBoard() {
		System.out.println(SUB_SECTION_SEPARATOR);
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		GameScoringBoard playerScoringBoard = gamePlayService.getPlayerScoringBoard();
		System.out.println(ResourceService.getService().getResource(FUNGAME_NUMBER_OF_WINS_LABEL_KEY) + playerScoringBoard.getWins());
		System.out.println(ResourceService.getService().getResource(FUNGAME_NUMBER_OF_LOSSES_LABEL_KEY) + playerScoringBoard.getLosses());
		System.out.println(ResourceService.getService().getResource(FUNGAME_NUMBER_OF_DEAD_HEAT_LABEL_KEY) + playerScoringBoard.getDeadHeats());
	}


}
