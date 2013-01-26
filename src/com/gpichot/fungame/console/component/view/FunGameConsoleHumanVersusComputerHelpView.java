package com.gpichot.fungame.console.component.view;

import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_HELP_TITLE_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.SECTION_SEPARATOR;

import java.util.List;

import com.gpichot.fungame.console.component.FunGameConsoleComponent;
import com.gpichot.fungame.console.component.FunGameConsoleComponentParameter;
import com.gpichot.fungame.console.component.FunGameConsoleComponentResult;
import com.gpichot.fungame.factory.GamePlayServiceFactory;
import com.gpichot.fungame.game.om.GamePlayOption;
import com.gpichot.fungame.game.service.GamePlayService;
import com.gpichot.fungame.resource.service.ResourceService;

public class FunGameConsoleHumanVersusComputerHelpView implements
		FunGameConsoleComponent {

	@Override
	public FunGameConsoleComponentResult execute(
			FunGameConsoleComponentParameter parameter) {
		internalDisplay();
		return new FunGameConsoleComponentResult(new FunGameConsoleHumanVersusComputerView(), null);
	}

	private void internalDisplay() {
		System.out.println(SECTION_SEPARATOR);
		System.out.println(ResourceService.getService().getResource(FUNGAME_HELP_TITLE_KEY));
		System.out.println(SECTION_SEPARATOR);
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		List<GamePlayOption> gamePlayOptions = gamePlayService.getGamePlayOptions();
		for(GamePlayOption gamePlayOption : gamePlayOptions){
			System.out.println("- '" + gamePlayOption.getIdentifier() + "' - " + 
					ResourceService.getService().getResource(gamePlayOption.getLabelKey()) + 
					" - " + ResourceService.getService().getResource(gamePlayOption.getHelpKey()));
		}
	}

}
