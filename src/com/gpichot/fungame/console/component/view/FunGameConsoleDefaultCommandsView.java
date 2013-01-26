package com.gpichot.fungame.console.component.view;

import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_EXIT_COMMAND_HELP_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_HELP_COMMAND_HELP_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_RESTART_COMMAND_HELP_KEY;
import static com.gpichot.fungame.resource.FunGameConstants.SUB_SECTION_SEPARATOR;

import com.gpichot.fungame.console.component.FunGameConsoleComponent;
import com.gpichot.fungame.console.component.FunGameConsoleComponentParameter;
import com.gpichot.fungame.console.component.FunGameConsoleComponentResult;
import com.gpichot.fungame.resource.service.ResourceService;

public class FunGameConsoleDefaultCommandsView implements FunGameConsoleComponent {

	@Override
	public FunGameConsoleComponentResult execute(
			FunGameConsoleComponentParameter parameter) {
		internalDisplay();
		return new FunGameConsoleComponentResult(null, null);
	}

	private void internalDisplay() {
		System.out.println(SUB_SECTION_SEPARATOR);
		System.out.println(ResourceService.getService().getResource(FUNGAME_HELP_COMMAND_HELP_KEY));
		System.out.println(ResourceService.getService().getResource(FUNGAME_EXIT_COMMAND_HELP_KEY));
		System.out.println(ResourceService.getService().getResource(FUNGAME_RESTART_COMMAND_HELP_KEY));
		System.out.println(SUB_SECTION_SEPARATOR);
	}

}
