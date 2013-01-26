package com.gpichot.fungame.factory;

import com.gpichot.fungame.game.om.ComputerPlayer;

public class ComputerPlayerFactory {

	private static final ComputerPlayerFactory factory = new ComputerPlayerFactory();
	
	private ComputerPlayerFactory(){
		
	}
	
	public static final ComputerPlayerFactory getFactory(){
		return factory;
	}
	
	public ComputerPlayer newInstance(){
		 ComputerPlayer computerPlayer = GenericObjectFactory.getFactory().newInstance(ComputerPlayer.class);
		 return computerPlayer;
	}
}
