package com.stounio.fungame.gui.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.stounio.fungame.factory.GamePlayServiceFactory;
import com.stounio.fungame.game.om.GamePlayOption;
import com.stounio.fungame.game.service.GamePlayService;

public class FunGameGuiLastGamePlayOptionPictures {

	private final Map<GamePlayOption, JLabel> rightHandPicturesByGamePlayOption;
	
	private final Map<GamePlayOption, JLabel> leftHandPicturesByGamePlayOption;
	
	public FunGameGuiLastGamePlayOptionPictures(){
		rightHandPicturesByGamePlayOption = new HashMap<GamePlayOption, JLabel>();
		leftHandPicturesByGamePlayOption = new HashMap<GamePlayOption, JLabel>();
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		List<GamePlayOption> gamePlayOptions = gamePlayService.getGamePlayOptions();
		for(GamePlayOption gamePlayOption : gamePlayOptions){
			createPictures(gamePlayOption);
		}
	}

	private void createPictures(GamePlayOption gamePlayOption) {
		ImageIcon rightHandPicture = new ImageIcon(gamePlayOption.getRightHandPicturePath());
		JLabel rightHandLabel = new JLabel(rightHandPicture);
		rightHandLabel.setVisible(false);
		rightHandPicturesByGamePlayOption.put(gamePlayOption, rightHandLabel);
		ImageIcon leftHandPicture = new ImageIcon(gamePlayOption.getLeftHandPicturePath());
		JLabel leftHandLabel = new JLabel(leftHandPicture);
		leftHandLabel.setVisible(false);
		leftHandPicturesByGamePlayOption.put(gamePlayOption, leftHandLabel);
	}
	
	public void addPicturesToPanel(JPanel panel){
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		List<GamePlayOption> gamePlayOptions = gamePlayService.getGamePlayOptions();
		for(GamePlayOption gamePlayOption : gamePlayOptions){
			panel.add(rightHandPicturesByGamePlayOption.get(gamePlayOption));
		}
		for(GamePlayOption gamePlayOption : gamePlayOptions){
			panel.add(leftHandPicturesByGamePlayOption.get(gamePlayOption));
		}
	}
	
	public void display(){
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		GamePlayOption playerLastPlay = gamePlayService.getPlayerLastPlay();
		JLabel playerLabel = rightHandPicturesByGamePlayOption.get(playerLastPlay);
		playerLabel.setVisible(true);
		GamePlayOption opponentLastPlay = gamePlayService.getOpponentLastPlay();
		JLabel opponentLabel = leftHandPicturesByGamePlayOption.get(opponentLastPlay);
		opponentLabel.setVisible(true);
	}
	
	public void hide(){
		GamePlayService gamePlayService = GamePlayServiceFactory.getFactory().getInstance();
		GamePlayOption playerLastPlay = gamePlayService.getPlayerLastPlay();
		if(playerLastPlay != null){
			JLabel playerLabel = rightHandPicturesByGamePlayOption.get(playerLastPlay);
			playerLabel.setVisible(false);
		}
		GamePlayOption opponentLastPlay = gamePlayService.getOpponentLastPlay();
		if(opponentLastPlay!=null){
			JLabel opponentLabel = leftHandPicturesByGamePlayOption.get(opponentLastPlay);
			opponentLabel.setVisible(false);
		}
	}
}
