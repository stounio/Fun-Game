package com.stounio.fungame.console.component.view;

import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_HELP_TITLE_KEY;
import static com.stounio.fungame.resource.FunGameConstants.SECTION_SEPARATOR;

import java.util.List;

import com.stounio.fungame.console.FunGameConsoleIOService;
import com.stounio.fungame.console.component.FunGameConsoleComponent;
import com.stounio.fungame.console.component.FunGameConsoleComponentParameter;
import com.stounio.fungame.console.component.FunGameConsoleComponentResult;
import com.stounio.fungame.factory.GamePlayServiceFactory;
import com.stounio.fungame.game.om.GamePlayOption;
import com.stounio.fungame.game.service.GamePlayService;
import com.stounio.fungame.resource.service.ResourceService;

public class FunGameConsoleHumanVersusComputerHelpView implements FunGameConsoleComponent {

    @Override
    public FunGameConsoleComponentResult execute(FunGameConsoleComponentParameter parameter) {
        internalDisplay();
        return new FunGameConsoleComponentResult(new FunGameConsoleHumanVersusComputerView(), null);
    }

    private void internalDisplay() {
        FunGameConsoleIOService funGameConsoleIOService = FunGameConsoleIOService.getService();
        funGameConsoleIOService.println(SECTION_SEPARATOR);
        funGameConsoleIOService.println(ResourceService.getService().getResource(FUNGAME_HELP_TITLE_KEY));
        funGameConsoleIOService.println(SECTION_SEPARATOR);
        GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
        List<GamePlayOption> gamePlayOptions = gamePlayService.getGamePlayOptions();
        for (GamePlayOption gamePlayOption : gamePlayOptions) {
            funGameConsoleIOService.println("- '" + gamePlayOption.getIdentifier() + "' - "
                    + ResourceService.getService().getResource(gamePlayOption.getLabelKey()) + " - "
                    + ResourceService.getService().getResource(gamePlayOption.getHelpKey()));
        }
    }

}
