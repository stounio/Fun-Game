package com.stounio.fungame.gui.button;

import static com.stounio.fungame.gui.FunGameGuiConstants.RESTART_PICTURE_PATH;
import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_RESTART_COMMAND_TOOL_TIP_KEY;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.stounio.fungame.gui.action.FunGameGuiRestartAction;
import com.stounio.fungame.resource.service.ResourceService;

public class FunGameGuiRestartButton {

	private JButton button;

	public FunGameGuiRestartButton(){
		ImageIcon imageIcon = new ImageIcon(RESTART_PICTURE_PATH);
		button = new JButton(imageIcon);
		button.addActionListener(new FunGameGuiRestartAction());
		button.setToolTipText(ResourceService.getService().getResource(FUNGAME_RESTART_COMMAND_TOOL_TIP_KEY));
	}

	public void addRestartButtonToPanel(JPanel panel){
		panel.add(button);
	}
}
