package com.stounio.fungame.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.stounio.fungame.factory.GamePlayServiceFactory;
import com.stounio.fungame.game.service.GamePlayService;
import com.stounio.fungame.gui.FunGameGuiController;

public class FunGameGuiInitialiazeHumanVersusComputerAction implements
		ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		gamePlayService.initializeHumanVersusComputerMode();
		FunGameGuiController.getController().displayHumanVersusComputerMode();
	}

}
