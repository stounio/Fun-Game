package com.stounio.fungame.gui.button;

import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.stounio.fungame.game.service.GamePlayResult;
import com.stounio.fungame.gui.action.FunGameGuiComputerContinuePlayingAction;
import com.stounio.fungame.resource.service.ResourceService;

public class FunGameGuiComputerPlayResultButtons {

	public Map<GamePlayResult, JButton> buttonsByGamePlayResult;
	
	public FunGameGuiComputerPlayResultButtons(){
		buttonsByGamePlayResult = new HashMap<GamePlayResult, JButton>();
		buttonsByGamePlayResult.put(GamePlayResult.WINNER,createButton(GamePlayResult.WINNER));
		buttonsByGamePlayResult.put(GamePlayResult.LOSER,createButton(GamePlayResult.LOSER));
		buttonsByGamePlayResult.put(GamePlayResult.DEAD_HEAT,createButton(GamePlayResult.DEAD_HEAT));
		buttonsByGamePlayResult.put(GamePlayResult.UNDECIDED,createButton(GamePlayResult.UNDECIDED));
	}

	private JButton createButton(GamePlayResult gamePlayResult) {
		ImageIcon imageIcon = new ImageIcon(gamePlayResult.getPicturePath());
		JButton button = new JButton(imageIcon);
		button.addActionListener(new FunGameGuiComputerContinuePlayingAction());
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
