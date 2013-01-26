package com.gpichot.fungame.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.gpichot.fungame.factory.GamePlayServiceFactory;
import com.gpichot.fungame.game.service.GamePlayResult;
import com.gpichot.fungame.game.service.GamePlayService;
import com.gpichot.fungame.gui.FunGameGuiController;

public class FunGameGuiHumanPlayAction implements ActionListener{

	private final String gamePlayOptionIdentifier;

	public FunGameGuiHumanPlayAction(String gamePlayOptionIdentifier){
		this.gamePlayOptionIdentifier = gamePlayOptionIdentifier;
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		GamePlayResult gamePlayResult = gamePlayService.play(gamePlayOptionIdentifier);
		FunGameGuiController.getController().displayHumanVersusComputerGamePlayResult(gamePlayResult);
	}

}
