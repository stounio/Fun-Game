package com.gpichot.fungame.console.component.action;

import com.gpichot.fungame.console.component.FunGameConsoleComponent;
import com.gpichot.fungame.console.component.FunGameConsoleComponentParameter;
import com.gpichot.fungame.console.component.FunGameConsoleComponentResult;
import com.gpichot.fungame.console.component.view.FunGameConsoleComputerPlayResultView;
import com.gpichot.fungame.factory.GamePlayServiceFactory;
import com.gpichot.fungame.game.service.GamePlayResult;
import com.gpichot.fungame.game.service.GamePlayService;

public class FunGameConsoleComputerPlayAction implements
		FunGameConsoleComponent {

	@Override
	public FunGameConsoleComponentResult execute(
			FunGameConsoleComponentParameter parameter) {
		return internalAction(parameter);
	}

	private FunGameConsoleComponentResult internalAction(FunGameConsoleComponentParameter parameter) {
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		GamePlayResult gamePlayResult = gamePlayService.play(null);
		return new FunGameConsoleComponentResult(new FunGameConsoleComputerPlayResultView(), new FunGameConsoleComponentParameter(gamePlayResult));
	}
}
