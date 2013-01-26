package com.gpichot.fungame.console.component.view;

import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_COMPUTER_VERSUS_COMPUTER_HELP_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_HELP_TITLE_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.SECTION_SEPARATOR;

import com.gpichot.fungame.console.component.FunGameConsoleComponent;
import com.gpichot.fungame.console.component.FunGameConsoleComponentParameter;
import com.gpichot.fungame.console.component.FunGameConsoleComponentResult;
import com.gpichot.fungame.resource.service.ResourceService;

public class FunGameConsoleComputerVersusComputerHelpView implements
		FunGameConsoleComponent {

	@Override
	public FunGameConsoleComponentResult execute(
			FunGameConsoleComponentParameter parameter) {
		internalDisplay();
		return new FunGameConsoleComponentResult(new FunGameConsoleComputerVersusComputerView(), null);
	}

	private void internalDisplay() {
		System.out.println(SECTION_SEPARATOR);
		System.out.println(ResourceService.getService().getResource(FUNGAME_HELP_TITLE_KEY));
		System.out.println(SECTION_SEPARATOR);
		System.out.println(ResourceService.getService().getResource(FUNGAME_COMPUTER_VERSUS_COMPUTER_HELP_KEY));
	}
}
