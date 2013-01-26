package com.stounio.fungame.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.stounio.fungame.gui.FunGameGuiController;

public class FunGameGuiComputerContinuePlayingAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		FunGameGuiController.getController().displayComputerVersusComputerMode();
	}

}
