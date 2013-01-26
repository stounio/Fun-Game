package com.stounio.fungame.console.component.view;

import com.stounio.fungame.console.component.FunGameConsoleComponent;
import com.stounio.fungame.console.component.FunGameConsoleComponentParameter;
import com.stounio.fungame.console.component.FunGameConsoleComponentResult;

public class FunGameConsoleComputerPlayResultView implements
		FunGameConsoleComponent {

	@Override
	public FunGameConsoleComponentResult execute(
			FunGameConsoleComponentParameter parameter) {
		FunGameConsolePlayResultView funGameConsolePlayResultView = new FunGameConsolePlayResultView();
		funGameConsolePlayResultView.execute(parameter);
		return new FunGameConsoleComponentResult(new FunGameConsoleComputerVersusComputerView(), null);
	}

}
