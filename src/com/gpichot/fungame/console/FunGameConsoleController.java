package com.gpichot.fungame.console;

import com.gpichot.fungame.console.component.FunGameConsoleComponent;
import com.gpichot.fungame.console.component.FunGameConsoleComponentParameter;
import com.gpichot.fungame.console.component.FunGameConsoleComponentResult;
import com.gpichot.fungame.console.component.view.FunGameConsoleWelcomeView;


public class FunGameConsoleController {

	private static final FunGameConsoleController controller = new FunGameConsoleController();
	
	
	public static final FunGameConsoleController getController(){
		return controller;
	}

	/** 
	 * Start the game in console mode.
	 */
	public void startGame() {
		FunGameConsoleComponent component = new FunGameConsoleWelcomeView();
		FunGameConsoleComponentParameter parameter = new FunGameConsoleComponentParameter(null);
		do{
			FunGameConsoleComponentResult consoleComponentResult = component.execute(parameter);
			component = consoleComponentResult.getComponent();
			parameter = consoleComponentResult.getParameter();
		}while(component != null);
	}
	
}
