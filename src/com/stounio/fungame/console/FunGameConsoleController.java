package com.stounio.fungame.console;

import com.stounio.fungame.console.component.FunGameConsoleComponent;
import com.stounio.fungame.console.component.FunGameConsoleComponentParameter;
import com.stounio.fungame.console.component.FunGameConsoleComponentResult;
import com.stounio.fungame.console.component.view.FunGameConsoleWelcomeView;


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
