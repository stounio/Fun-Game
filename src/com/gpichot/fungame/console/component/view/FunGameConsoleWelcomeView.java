package com.gpichot.fungame.console.component.view;

import static com.gpichot.fungame.resource.FunGameConstants.COMPUTER_VERSUS_COMPUTER_CODE;
import static com.gpichot.fungame.resource.FunGameConstants.EXIT_COMMAND;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_COMPUTER_VERSUS_COMPUTER_MODE_LABEL_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_HUMAN_VERSUS_COMPUTER_MODE_LABEL_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_MENU_CHOICE_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_PLAYER_MODE_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_TITLE_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.HELP_COMMAND;
import static com.gpichot.fungame.resource.FunGameConstants.HUMAN_VERSUS_COMPUTER_CODE;
import static com.gpichot.fungame.resource.FunGameConstants.RESTART_COMMAND;
import static com.gpichot.fungame.resource.FunGameConstants.SECTION_SEPARATOR;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.gpichot.fungame.console.component.FunGameConsoleComponent;
import com.gpichot.fungame.console.component.FunGameConsoleComponentParameter;
import com.gpichot.fungame.console.component.FunGameConsoleComponentResult;
import com.gpichot.fungame.console.component.action.FunGameConsoleExitAction;
import com.gpichot.fungame.console.component.action.FunGameConsoleInitialiazeComputerVersusComputerAction;
import com.gpichot.fungame.console.component.action.FunGameConsoleInitialiazeHumanVersusComputerAction;
import com.gpichot.fungame.console.component.action.FunGameConsoleRestartAction;
import com.gpichot.fungame.resource.service.ResourceService;

public class FunGameConsoleWelcomeView implements FunGameConsoleComponent {

	
	@Override
	public FunGameConsoleComponentResult execute(FunGameConsoleComponentParameter parameter) {
		internalDisplay();
		displayDefaultCommands(parameter);
		FunGameConsoleComponentResult result = readPlayerInput();
		return result;
	}


	private void internalDisplay() {
		System.out.println(SECTION_SEPARATOR);
		System.out.println(ResourceService.getService().getResource(FUNGAME_TITLE_KEY));
		System.out.println(SECTION_SEPARATOR);
		System.out.println(ResourceService.getService().getResource(FUNGAME_PLAYER_MODE_KEY));
		System.out.println("1 - " + ResourceService.getService().getResource(FUNGAME_HUMAN_VERSUS_COMPUTER_MODE_LABEL_KEY));
		System.out.println("2 - " + ResourceService.getService().getResource(FUNGAME_COMPUTER_VERSUS_COMPUTER_MODE_LABEL_KEY));
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
				return new FunGameConsoleComponentResult(new FunGameConsoleWelcomeHelpView(), null);
			}
			if(EXIT_COMMAND.equals(input)){
				return new FunGameConsoleComponentResult(new FunGameConsoleExitAction(), null);
			}
			if(RESTART_COMMAND.equals(input)){
				return new FunGameConsoleComponentResult(new FunGameConsoleRestartAction(), null);
			}
			if(Integer.valueOf(input).equals(HUMAN_VERSUS_COMPUTER_CODE)){
				return new FunGameConsoleComponentResult(new FunGameConsoleInitialiazeHumanVersusComputerAction(), null);
			}
			if(Integer.valueOf(input).equals(COMPUTER_VERSUS_COMPUTER_CODE)){
				return new FunGameConsoleComponentResult(new FunGameConsoleInitialiazeComputerVersusComputerAction(), null);
			}
			return new FunGameConsoleComponentResult(new FunGameConsoleWelcomeView(), null);
		}catch(Exception e){
			return new FunGameConsoleComponentResult(new FunGameConsoleWelcomeView(), null);
		}
	}
}