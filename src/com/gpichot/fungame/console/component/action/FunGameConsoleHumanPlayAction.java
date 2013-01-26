package com.gpichot.fungame.console.component.action;

import com.gpichot.fungame.console.component.FunGameConsoleComponent;
import com.gpichot.fungame.console.component.FunGameConsoleComponentParameter;
import com.gpichot.fungame.console.component.FunGameConsoleComponentResult;
import com.gpichot.fungame.console.component.view.FunGameConsoleHumanPlayResultView;
import com.gpichot.fungame.console.component.view.FunGameConsoleHumanVersusComputerView;
import com.gpichot.fungame.factory.GamePlayServiceFactory;
import com.gpichot.fungame.game.service.GamePlayResult;
import com.gpichot.fungame.game.service.GamePlayService;

public class FunGameConsoleHumanPlayAction implements FunGameConsoleComponent {

	@Override
	public FunGameConsoleComponentResult execute(
			FunGameConsoleComponentParameter parameter) {
		return internalAction(parameter);
	}

	private FunGameConsoleComponentResult internalAction(FunGameConsoleComponentParameter parameter) {
		try{
			String gamePlayOptionIdentifier = (String) parameter.getParameterValue();
			GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
			GamePlayResult gamePlayResult = gamePlayService.play(gamePlayOptionIdentifier);
			return new FunGameConsoleComponentResult(new FunGameConsoleHumanPlayResultView(), new FunGameConsoleComponentParameter(gamePlayResult));
		}catch(Exception e){
			return new FunGameConsoleComponentResult(new FunGameConsoleHumanVersusComputerView(), null);
		}
	}

}

