package com.stounio.fungame.console.component.action;

import com.stounio.fungame.console.component.FunGameConsoleComponent;
import com.stounio.fungame.console.component.FunGameConsoleComponentParameter;
import com.stounio.fungame.console.component.FunGameConsoleComponentResult;
import com.stounio.fungame.console.component.view.FunGameConsoleComputerVersusComputerView;
import com.stounio.fungame.factory.GamePlayServiceFactory;
import com.stounio.fungame.game.service.GamePlayService;

public class FunGameConsoleInitialiazeComputerVersusComputerAction implements
		FunGameConsoleComponent {

	@Override
	public FunGameConsoleComponentResult execute(
			FunGameConsoleComponentParameter parameter) {
		return internalAction(parameter);
	}

	private FunGameConsoleComponentResult internalAction(FunGameConsoleComponentParameter parameter) {
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		gamePlayService.initializeComputerVersusComputerMode();		
		return new FunGameConsoleComponentResult(new FunGameConsoleComputerVersusComputerView(), null);
	}

}
