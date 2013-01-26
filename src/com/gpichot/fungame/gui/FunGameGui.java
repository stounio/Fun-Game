package com.gpichot.fungame.gui;

import com.gpichot.fungame.factory.GamePlayServiceFactory;

/**
 * Starts the fun game using a graphical user interface.
 */
public class FunGameGui {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initializeGameService();
		try{
			startGame();
		} catch(Exception e){
			exitWithErrors(e);
		}
	}

	private static void initializeGameService() {
		GamePlayServiceFactory.getFactory().getInstance();
	}
	
	private static void startGame() {
		FunGameGuiController.getController().startGame();
	}
	
	private static void exitWithErrors(Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
		System.exit(-1);
	}
}
