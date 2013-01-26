package com.stounio.fungame.console.component;

public class FunGameConsoleComponentResult {

	private final FunGameConsoleComponent component;
	private final FunGameConsoleComponentParameter parameter;

	/**
	 * Construct the result produced by a fun game component
	 * @param component can be null
	 * @param parameter can be null
	 */
	public FunGameConsoleComponentResult(FunGameConsoleComponent component, FunGameConsoleComponentParameter parameter){
		this.component = component;
		this.parameter = parameter;
	}

	public FunGameConsoleComponent getComponent() {
		return component;
	}

	public FunGameConsoleComponentParameter getParameter() {
		return parameter;
	}

	
}
