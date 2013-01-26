package com.stounio.fungame.gui.button;

import static com.stounio.fungame.gui.FunGameGuiConstants.COMPUTER_PLAY_PICTURE_PATH;
import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_COMPUTER_VERSUS_COMPUTER_TOOL_TIP_KEY;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.stounio.fungame.gui.action.FunGameGuiComputerPlayAction;
import com.stounio.fungame.resource.service.ResourceService;

public class FunGameGuiComputerPlayButton {
	
	private JButton button;

	public FunGameGuiComputerPlayButton(){
		ImageIcon imageIcon = new ImageIcon(COMPUTER_PLAY_PICTURE_PATH);
		button = new JButton(imageIcon);
		button.addActionListener(new FunGameGuiComputerPlayAction());
		button.setToolTipText(ResourceService.getService().getResource(FUNGAME_COMPUTER_VERSUS_COMPUTER_TOOL_TIP_KEY));
	}

	public void addButtonToPanel(JPanel panel) {
		panel.add(button);
	}

	public void display() {
		button.setVisible(true);
	}

	public void hide() {
		button.setVisible(false);
	}

}
