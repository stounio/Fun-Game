package com.gpichot.fungame.console.component.view;

import static com.gpichot.fungame.resource.FunGameConstants.EXIT_COMMAND;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_HUMAN_VERSUS_COMPUTER_MODE_TITLE_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_MENU_CHOICE_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.HELP_COMMAND;
import static com.gpichot.fungame.resource.FunGameConstants.RESTART_COMMAND;
import static com.gpichot.fungame.resource.FunGameConstants.SECTION_SEPARATOR;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.gpichot.fungame.console.component.FunGameConsoleComponent;
import com.gpichot.fungame.console.component.FunGameConsoleComponentParameter;
import com.gpichot.fungame.console.component.FunGameConsoleComponentResult;
import com.gpichot.fungame.console.component.action.FunGameConsoleExitAction;
import com.gpichot.fungame.console.component.action.FunGameConsoleHumanPlayAction;
import com.gpichot.fungame.console.component.action.FunGameConsoleRestartAction;
import com.gpichot.fungame.factory.GamePlayServiceFactory;
import com.gpichot.fungame.game.om.GamePlayOption;
import com.gpichot.fungame.game.service.GamePlayService;
import com.gpichot.fungame.resource.service.ResourceService;

public class FunGameConsoleHumanVersusComputerView implements FunGameConsoleComponent {

	@Override
	public FunGameConsoleComponentResult execute(
			FunGameConsoleComponentParameter parameter) {
		internalDisplay();
		displayDefaultCommands(parameter);
		FunGameConsoleComponentResult result = readPlayerInput();
		return result;
	}
	
	private void internalDisplay() {
		System.out.println(SECTION_SEPARATOR);
		System.out.println(ResourceService.getService().getResource(FUNGAME_HUMAN_VERSUS_COMPUTER_MODE_TITLE_KEY));
		System.out.println(SECTION_SEPARATOR);
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		List<GamePlayOption> gamePlayOptions = gamePlayService.getGamePlayOptions();
		for(GamePlayOption gamePlayOption : gamePlayOptions){
			System.out.println("- '" + gamePlayOption.getIdentifier() + "'");
		}
	}

	private void displayDefaultCommands(
			FunGameConsoleComponentParameter parameter) {
		FunGameConsoleDefaultCommandsView funGameConsoleDefaultCommandsView = new FunGameConsoleDefaultCommandsView();
		funGameConsoleDefaultCommandsView.execute(parameter);
	}
	
	private FunGameConsoleComponentResult readPlayerInput() {
		try{
			System.out.println(ResourceService.getService().getResource(FUNGAME_MENU_CHOICE_KEY));
			InputStreamReader converter = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(converter);
			String input = in.readLine();
			if(HELP_COMMAND.equals(input)){
				return new FunGameConsoleComponentResult(new FunGameConsoleHumanVersusComputerHelpView(), null);
			}
			if(EXIT_COMMAND.equals(input)){
				return new FunGameConsoleComponentResult(new FunGameConsoleExitAction(), null);
			}
			if(RESTART_COMMAND.equals(input)){
				return new FunGameConsoleComponentResult(new FunGameConsoleRestartAction(), null);
			}
			return new FunGameConsoleComponentResult(new FunGameConsoleHumanPlayAction(), new FunGameConsoleComponentParameter(input));
		}catch(Exception e){
			return new FunGameConsoleComponentResult(new FunGameConsoleHumanVersusComputerView(), null);
		}
	}
}
