package com.stounio.fungame.gui.button;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.stounio.fungame.factory.GamePlayServiceFactory;
import com.stounio.fungame.game.om.GamePlayOption;
import com.stounio.fungame.game.service.GamePlayService;
import com.stounio.fungame.gui.action.FunGameGuiHumanPlayAction;
import com.stounio.fungame.resource.service.ResourceService;

public class FunGameGuiHumanGamePlayOptionButtons {

	private List<JButton> buttons;
	
	public FunGameGuiHumanGamePlayOptionButtons(){
		buttons = new ArrayList<JButton>();
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		List<GamePlayOption> gamePlayOptions = gamePlayService.getGamePlayOptions();
		for(GamePlayOption gamePlayOption : gamePlayOptions){
			JButton button = createButton(gamePlayOption);
			buttons.add(button);
		}
	}

	private JButton createButton(GamePlayOption gamePlayOption) {
		ImageIcon imageIcon = new ImageIcon(gamePlayOption.getRightHandPicturePath());
		JButton button = new JButton(imageIcon);
		button.addActionListener(new FunGameGuiHumanPlayAction(gamePlayOption.getIdentifier()));
		button.setToolTipText(ResourceService.getService().getResource(gamePlayOption.getHelpKey()));
		return button;
	}
	
	public void addButtonsToPanel(JPanel panel){
		for(JButton button:buttons){
			panel.add(button);
		}
	}
	
	public void hide() {
		for(JButton button:buttons){
			button.setVisible(false);
		}
	}
	
	public void display(){
		for(JButton button:buttons){
			button.setVisible(true);
		}
	}
}
