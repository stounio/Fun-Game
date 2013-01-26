package com.gpichot.fungame.gui.button;

import static com.gpichot.fungame.gui.FunGameGuiConstants.EXIT_PICTURE_PATH;
import static com.gpichot.fungame.resource.FunGameConstants.FUNGAME_EXIT_COMMAND_TOOL_TIP_KEY;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.gpichot.fungame.gui.action.FunGameGuiExitAction;
import com.gpichot.fungame.resource.service.ResourceService;

public class FunGameGuiExitButton {
	
	private final JButton button;

	public FunGameGuiExitButton(){
		ImageIcon imageIcon = new ImageIcon(EXIT_PICTURE_PATH);
		button = new JButton(imageIcon);
		button.addActionListener(new FunGameGuiExitAction());
		button.setToolTipText(ResourceService.getService().getResource(FUNGAME_EXIT_COMMAND_TOOL_TIP_KEY));
	}

	public void addExitButtonToPanel(JPanel panel){
		panel.add(button);
	}
}
