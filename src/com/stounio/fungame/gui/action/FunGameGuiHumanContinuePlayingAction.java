package com.stounio.fungame.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.stounio.fungame.gui.FunGameGuiController;

public class FunGameGuiHumanContinuePlayingAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		FunGameGuiController.getController().displayHumanVersusComputerMode();
	}

}
