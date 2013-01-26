package com.gpichot.fungame.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.gpichot.fungame.factory.GamePlayServiceFactory;
import com.gpichot.fungame.game.service.GamePlayService;
import com.gpichot.fungame.gui.FunGameGuiController;

public class FunGameGuiRestartAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		gamePlayService.restart();
		FunGameGuiController.getController().displayWelcome();
	}
}
