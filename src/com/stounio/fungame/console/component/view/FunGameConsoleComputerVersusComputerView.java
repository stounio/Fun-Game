package com.stounio.fungame.console.component.view;

import static com.stounio.fungame.resource.FunGameConstants.EXIT_COMMAND;
import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_COMPUTER_VERSUS_COMPUTER_MODE_TITLE_KEY;
import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_MENU_CHOICE_KEY;
import static com.stounio.fungame.resource.FunGameConstants.HELP_COMMAND;
import static com.stounio.fungame.resource.FunGameConstants.RESTART_COMMAND;
import static com.stounio.fungame.resource.FunGameConstants.SECTION_SEPARATOR;

import com.stounio.fungame.console.FunGameConsoleIOService;
import com.stounio.fungame.console.component.FunGameConsoleComponent;
import com.stounio.fungame.console.component.FunGameConsoleComponentParameter;
import com.stounio.fungame.console.component.FunGameConsoleComponentResult;
import com.stounio.fungame.console.component.action.FunGameConsoleComputerPlayAction;
import com.stounio.fungame.console.component.action.FunGameConsoleExitAction;
import com.stounio.fungame.console.component.action.FunGameConsoleRestartAction;
import com.stounio.fungame.resource.service.ResourceService;

public class FunGameConsoleComputerVersusComputerView implements FunGameConsoleComponent {

    @Override
    public FunGameConsoleComponentResult execute(FunGameConsoleComponentParameter parameter) {
        internalDisplay();
        displayDefaultCommands(parameter);
        return readPlayerInput();
    }

    private void internalDisplay() {
        FunGameConsoleIOService funGameConsoleIOService = FunGameConsoleIOService.getService();
        funGameConsoleIOService.println(SECTION_SEPARATOR);
        funGameConsoleIOService.println(ResourceService.getService().getResource(
                FUNGAME_COMPUTER_VERSUS_COMPUTER_MODE_TITLE_KEY));
        funGameConsoleIOService.println(SECTION_SEPARATOR);
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
                return new FunGameConsoleComponentResult(new FunGameConsoleComputerVersusComputerHelpView(), null);
            }
            if (EXIT_COMMAND.equals(input)) {
                return new FunGameConsoleComponentResult(new FunGameConsoleExitAction(), null);
            }
            if (RESTART_COMMAND.equals(input)) {
                return new FunGameConsoleComponentResult(new FunGameConsoleRestartAction(), null);
            }
            return new FunGameConsoleComponentResult(new FunGameConsoleComputerPlayAction(), null);
        } catch (Exception e) {
            return new FunGameConsoleComponentResult(new FunGameConsoleComputerVersusComputerView(), null);
        }
    }
}
