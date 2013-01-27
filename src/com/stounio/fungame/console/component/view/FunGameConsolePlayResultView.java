package com.stounio.fungame.console.component.view;

import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_NUMBER_OF_DEAD_HEAT_LABEL_KEY;
import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_NUMBER_OF_LOSSES_LABEL_KEY;
import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_NUMBER_OF_WINS_LABEL_KEY;
import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_OPPONENT_LAST_PLAY_LABEL_KEY;
import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_PLAYER_LAST_PLAY_LABEL_KEY;
import static com.stounio.fungame.resource.FunGameConstants.SUB_SECTION_SEPARATOR;

import com.stounio.fungame.console.FunGameConsoleIOService;
import com.stounio.fungame.console.component.FunGameConsoleComponent;
import com.stounio.fungame.console.component.FunGameConsoleComponentParameter;
import com.stounio.fungame.console.component.FunGameConsoleComponentResult;
import com.stounio.fungame.factory.GamePlayServiceFactory;
import com.stounio.fungame.game.om.GamePlayOption;
import com.stounio.fungame.game.om.GameScoringBoard;
import com.stounio.fungame.game.service.GamePlayResult;
import com.stounio.fungame.game.service.GamePlayService;
import com.stounio.fungame.resource.service.ResourceService;

public class FunGameConsolePlayResultView implements FunGameConsoleComponent {

    @Override
    public FunGameConsoleComponentResult execute(FunGameConsoleComponentParameter parameter) {
        displayPlayerLastPlay();
        displayOpponentLastPlay();
        displayGamePlayResult(parameter);
        displayScoringBoard();
        return new FunGameConsoleComponentResult(null, null);
    }

    private void displayPlayerLastPlay() {
        FunGameConsoleIOService funGameConsoleIOService = FunGameConsoleIOService.getService();
        funGameConsoleIOService.println(SUB_SECTION_SEPARATOR);
        GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
        GamePlayOption gamePlayOption = gamePlayService.getPlayerLastPlay();
        funGameConsoleIOService.println(ResourceService.getService().getResource(FUNGAME_PLAYER_LAST_PLAY_LABEL_KEY)
                + "'" + gamePlayOption.getIdentifier() + "'");
    }

    private void displayOpponentLastPlay() {
        FunGameConsoleIOService funGameConsoleIOService = FunGameConsoleIOService.getService();
        funGameConsoleIOService.println(SUB_SECTION_SEPARATOR);
        GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
        GamePlayOption gamePlayOption = gamePlayService.getOpponentLastPlay();
        funGameConsoleIOService.println(ResourceService.getService().getResource(FUNGAME_OPPONENT_LAST_PLAY_LABEL_KEY)
                + "'" + gamePlayOption.getIdentifier() + "'");
    }

    private void displayGamePlayResult(FunGameConsoleComponentParameter parameter) {
        FunGameConsoleIOService funGameConsoleIOService = FunGameConsoleIOService.getService();
        GamePlayResult gamePlayResult = (GamePlayResult) parameter.getParameterValue();
        funGameConsoleIOService.println(SUB_SECTION_SEPARATOR);
        funGameConsoleIOService.println(ResourceService.getService().getResource(gamePlayResult.getResourceKey()));
    }

    private void displayScoringBoard() {
        FunGameConsoleIOService funGameConsoleIOService = FunGameConsoleIOService.getService();
        funGameConsoleIOService.println(SUB_SECTION_SEPARATOR);
        GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
        GameScoringBoard playerScoringBoard = gamePlayService.getPlayerScoringBoard();
        funGameConsoleIOService.println(ResourceService.getService().getResource(FUNGAME_NUMBER_OF_WINS_LABEL_KEY)
                + playerScoringBoard.getWins());
        funGameConsoleIOService.println(ResourceService.getService().getResource(FUNGAME_NUMBER_OF_LOSSES_LABEL_KEY)
                + playerScoringBoard.getLosses());
        funGameConsoleIOService.println(ResourceService.getService().getResource(FUNGAME_NUMBER_OF_DEAD_HEAT_LABEL_KEY)
                + playerScoringBoard.getDeadHeats());
    }

}
