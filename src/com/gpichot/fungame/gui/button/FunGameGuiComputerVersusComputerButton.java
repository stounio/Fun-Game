package com.gpichot.fungame.gui.button;

import static com.gpichot.fungame.gui.FunGameGuiConstants.COMPUTER_VERSUS_COMPUTER_PICTURE_PATH;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_COMPUTER_VERSUS_COMPUTER_MODE_LABEL_KEY;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.gpichot.fungame.gui.action.FunGameGuiInitialiazeComputerVersusComputerAction;
import com.gpichot.fungame.resource.service.ResourceService;

public class FunGameGuiComputerVersusComputerButton {

	private JButton button;

	public FunGameGuiComputerVersusComputerButton(){
		ImageIcon imageIcon = new ImageIcon(COMPUTER_VERSUS_COMPUTER_PICTURE_PATH);
		button = new JButton(imageIcon);
		button.addActionListener(new FunGameGuiInitialiazeComputerVersusComputerAction());
		button.setToolTipText(ResourceService.getService().getResource(FUNGAME_COMPUTER_VERSUS_COMPUTER_MODE_LABEL_KEY));
	}

	public void addButtonToPanel(JPanel panel){
		panel.add(button);
	}

	public void hide() {
		button.setVisible(false);
	}
	
	public void display(){
		button.setVisible(true);
	}
}
