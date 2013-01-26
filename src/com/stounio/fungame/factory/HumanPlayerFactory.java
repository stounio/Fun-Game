package com.stounio.fungame.factory;

import com.stounio.fungame.game.om.HumanPlayer;

public class HumanPlayerFactory {

	private static final HumanPlayerFactory factory = new HumanPlayerFactory();
	
	private HumanPlayerFactory(){
		
	}
	
	public static final HumanPlayerFactory getFactory(){
		return factory;
	}
	
	public HumanPlayer newInstance(){
		HumanPlayer humanPlayer = GenericObjectFactory.getFactory().newInstance(HumanPlayer.class);
		return humanPlayer;
	}
}
