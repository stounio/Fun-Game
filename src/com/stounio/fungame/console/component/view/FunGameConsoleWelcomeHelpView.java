package com.stounio.fungame.console.component.view;

import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_COMPUTER_VERSUS_COMPUTER_MODE_HELP_KEY;
import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_HELP_TITLE_KEY;
import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_HUMAN_VERSUS_COMPUTER_MODE_HELP_KEY;
import static com.stounio.fungame.resource.FunGameConstants.SECTION_SEPARATOR;

import com.stounio.fungame.console.component.FunGameConsoleComponent;
import com.stounio.fungame.console.component.FunGameConsoleComponentParameter;
import com.stounio.fungame.console.component.FunGameConsoleComponentResult;
import com.stounio.fungame.resource.service.ResourceService;

public class FunGameConsoleWelcomeHelpView implements FunGameConsoleComponent {

	@Override
	public FunGameConsoleComponentResult execute(
			FunGameConsoleComponentParameter parameter) {
		internalDisplay();
		return new FunGameConsoleComponentResult(new FunGameConsoleWelcomeView(), null);
	}

	private void internalDisplay() {
		System.out.println(SECTION_SEPARATOR);
		System.out.println(ResourceService.getService().getResource(FUNGAME_HELP_TITLE_KEY));
		System.out.println(SECTION_SEPARATOR);
		System.out.println("1 - " + ResourceService.getService().getResource(FUNGAME_HUMAN_VERSUS_COMPUTER_MODE_HELP_KEY));
		System.out.println("2 - " + ResourceService.getService().getResource(FUNGAME_COMPUTER_VERSUS_COMPUTER_MODE_HELP_KEY));
	}

}
