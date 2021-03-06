package com.stounio.fungame.console.component.view;

import static com.stounio.fungame.resource.FunGameConstants.EXIT_COMMAND;
import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_HUMAN_VERSUS_COMPUTER_MODE_TITLE_KEY;
import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_MENU_CHOICE_KEY;
import static com.stounio.fungame.resource.FunGameConstants.HELP_COMMAND;
import static com.stounio.fungame.resource.FunGameConstants.RESTART_COMMAND;
import static com.stounio.fungame.resource.FunGameConstants.SECTION_SEPARATOR;

import java.util.List;

import com.stounio.fungame.console.FunGameConsoleIOService;
import com.stounio.fungame.console.component.FunGameConsoleComponent;
import com.stounio.fungame.console.component.FunGameConsoleComponentParameter;
import com.stounio.fungame.console.component.FunGameConsoleComponentResult;
import com.stounio.fungame.console.component.action.FunGameConsoleExitAction;
import com.stounio.fungame.console.component.action.FunGameConsoleHumanPlayAction;
import com.stounio.fungame.console.component.action.FunGameConsoleRestartAction;
import com.stounio.fungame.factory.GamePlayServiceFactory;
import com.stounio.fungame.game.om.GamePlayOption;
import com.stounio.fungame.game.service.GamePlayService;
import com.stounio.fungame.resource.service.ResourceService;

public class FunGameConsoleHumanVersusComputerView implements FunGameConsoleComponent {

    @Override
    public FunGameConsoleComponentResult execute(FunGameConsoleComponentParameter parameter) {
        internalDisplay();
        displayDefaultCommands(parameter);
        FunGameConsoleComponentResult result = readPlayerInput();
        return result;
    }

    private void internalDisplay() {
        FunGameConsoleIOService funGameConsoleIOService = FunGameConsoleIOService.getService();
        funGameConsoleIOService.println(SECTION_SEPARATOR);
        funGameConsoleIOService.println(ResourceService.getService().getResource(
                FUNGAME_HUMAN_VERSUS_COMPUTER_MODE_TITLE_KEY));
        funGameConsoleIOService.println(SECTION_SEPARATOR);
        GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
        List<GamePlayOption> gamePlayOptions = gamePlayService.getGamePlayOptions();
        for (GamePlayOption gamePlayOption : gamePlayOptions) {
            funGameConsoleIOService.println("- '" + gamePlayOption.getIdentifier() + "'");
        }
    }

    private void displayDefaultCommands(FunGameConsoleComponentParameter parameter) {
        FunGameConsoleDefaultCommandsView funGameConsoleDefaultCommandsView = new FunGameConsoleDefaultCommandsView();
        funGameConsoleDefaultCommandsView.execute(parameter);
    }

    private FunGameConsoleComponentResult readPlayerInput() {
        try {
            FunGameConsoleIOService funGameConsoleIOService = FunGameConsoleIOService.getService();
            funGameConsoleIOService.println(ResourceService.getService().getResource(FUNGAME_MENU_CHOICE_KEY));
            String input = FunGameConsoleIOService.getService().nextLine();
            if (HELP_COMMAND.equals(input)) {
                return new FunGameConsoleComponentResult(new FunGameConsoleHumanVersusComputerHelpView(), null);
            }
            if (EXIT_COMMAND.equals(input)) {
                return new FunGameConsoleComponentResult(new FunGameConsoleExitAction(), null);
            }
            if (RESTART_COMMAND.equals(input)) {
                return new FunGameConsoleComponentResult(new FunGameConsoleRestartAction(), null);
            }
            return new FunGameConsoleComponentResult(new FunGameConsoleHumanPlayAction(),
                    new FunGameConsoleComponentParameter(input));
        } catch (Exception e) {
            return new FunGameConsoleComponentResult(new FunGameConsoleHumanVersusComputerView(), null);
        }
    }
}
