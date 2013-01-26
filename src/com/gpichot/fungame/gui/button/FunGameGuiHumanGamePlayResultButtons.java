package com.gpichot.fungame.gui.button;

import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.gpichot.fungame.game.service.GamePlayResult;
import com.gpichot.fungame.gui.action.FunGameGuiHumanContinuePlayingAction;
import com.gpichot.fungame.resource.service.ResourceService;

public class FunGameGuiHumanGamePlayResultButtons {

	public Map<GamePlayResult, JButton> buttonsByGamePlayResult;
	
	public FunGameGuiHumanGamePlayResultButtons(){
		buttonsByGamePlayResult = new HashMap<GamePlayResult, JButton>();
		buttonsByGamePlayResult.put(GamePlayResult.WINNER,createButton(GamePlayResult.WINNER));
		buttonsByGamePlayResult.put(GamePlayResult.LOSER,createButton(GamePlayResult.LOSER));
		buttonsByGamePlayResult.put(GamePlayResult.DEAD_HEAT,createButton(GamePlayResult.DEAD_HEAT));
		buttonsByGamePlayResult.put(GamePlayResult.UNDECIDED,createButton(GamePlayResult.UNDECIDED));
	}

	private JButton createButton(GamePlayResult gamePlayResult) {
		ImageIcon imageIcon = new ImageIcon(gamePlayResult.getPicturePath());
		JButton button = new JButton(imageIcon);
		button.addActionListener(new FunGameGuiHumanContinuePlayingAction());
		button.setToolTipText(ResourceService.getService().getResource(gamePlayResult.getResourceKey()));
		return button;
	}
	
	public void addButtonsToPanel(JPanel panel){
		panel.add(buttonsByGamePlayResult.get(GamePlayResult.WINNER));
		panel.add(buttonsByGamePlayResult.get(GamePlayResult.LOSER));
		panel.add(buttonsByGamePlayResult.get(GamePlayResult.DEAD_HEAT));
		panel.add(buttonsByGamePlayResult.get(GamePlayResult.UNDECIDED));
	}
	
	public void hide(){
		buttonsByGamePlayResult.get(GamePlayResult.WINNER).setVisible(false);
		buttonsByGamePlayResult.get(GamePlayResult.LOSER).setVisible(false);
		buttonsByGamePlayResult.get(GamePlayResult.DEAD_HEAT).setVisible(false);
		buttonsByGamePlayResult.get(GamePlayResult.UNDECIDED).setVisible(false);
	}
	
	public void display(GamePlayResult gamePlayResult){
		buttonsByGamePlayResult.get(gamePlayResult).setVisible(true);
	}
}
