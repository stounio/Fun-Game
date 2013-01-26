package com.gpichot.fungame.console.component.action;

import com.gpichot.fungame.console.component.FunGameConsoleComponent;
import com.gpichot.fungame.console.component.FunGameConsoleComponentParameter;
import com.gpichot.fungame.console.component.FunGameConsoleComponentResult;
import com.gpichot.fungame.console.component.view.FunGameConsoleWelcomeView;
import com.gpichot.fungame.factory.GamePlayServiceFactory;
import com.gpichot.fungame.game.service.GamePlayService;

public class FunGameConsoleRestartAction implements FunGameConsoleComponent {

	@Override
	public FunGameConsoleComponentResult execute(
			FunGameConsoleComponentParameter parameter) {
		return internalAction(parameter);
	}

	private FunGameConsoleComponentResult internalAction(FunGameConsoleComponentParameter parameter) {
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		gamePlayService.restart();
		return new FunGameConsoleComponentResult(new FunGameConsoleWelcomeView(), null);
	}
}
