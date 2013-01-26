package com.gpichot.fungame.console.component.view;

import com.gpichot.fungame.console.component.FunGameConsoleComponent;
import com.gpichot.fungame.console.component.FunGameConsoleComponentParameter;
import com.gpichot.fungame.console.component.FunGameConsoleComponentResult;

public class FunGameConsoleHumanPlayResultView implements
		FunGameConsoleComponent {

	@Override
	public FunGameConsoleComponentResult execute(
			FunGameConsoleComponentParameter parameter) {
		FunGameConsolePlayResultView funGameConsolePlayResultView = new FunGameConsolePlayResultView();
		funGameConsolePlayResultView.execute(parameter);
		return new FunGameConsoleComponentResult(new FunGameConsoleHumanVersusComputerView(), null);
	}
}
