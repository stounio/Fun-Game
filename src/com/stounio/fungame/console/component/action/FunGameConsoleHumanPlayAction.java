package com.stounio.fungame.console.component.action;

import com.stounio.fungame.console.component.FunGameConsoleComponent;
import com.stounio.fungame.console.component.FunGameConsoleComponentParameter;
import com.stounio.fungame.console.component.FunGameConsoleComponentResult;
import com.stounio.fungame.console.component.view.FunGameConsoleHumanPlayResultView;
import com.stounio.fungame.console.component.view.FunGameConsoleHumanVersusComputerView;
import com.stounio.fungame.factory.GamePlayServiceFactory;
import com.stounio.fungame.game.service.GamePlayResult;
import com.stounio.fungame.game.service.GamePlayService;

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

