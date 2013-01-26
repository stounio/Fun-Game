package com.stounio.fungame.gui.button;

import static com.stounio.fungame.gui.FunGameGuiConstants.HUMAN_VERSUS_COMPUTER_PICTURE_PATH;
import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_HUMAN_VERSUS_COMPUTER_MODE_LABEL_KEY;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.stounio.fungame.gui.action.FunGameGuiInitialiazeHumanVersusComputerAction;
import com.stounio.fungame.resource.service.ResourceService;

public class FunGameGuiHumanVersusComputerButton {

	private JButton button;

	public FunGameGuiHumanVersusComputerButton(){
		ImageIcon imageIcon = new ImageIcon(HUMAN_VERSUS_COMPUTER_PICTURE_PATH);
		button = new JButton(imageIcon);
		button.addActionListener(new FunGameGuiInitialiazeHumanVersusComputerAction());
		button.setToolTipText(ResourceService.getService().getResource(FUNGAME_HUMAN_VERSUS_COMPUTER_MODE_LABEL_KEY));
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
