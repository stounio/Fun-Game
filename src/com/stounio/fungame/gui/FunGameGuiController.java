package com.stounio.fungame.gui;

import javax.swing.JPanel;

import com.stounio.fungame.game.service.GamePlayResult;
import com.stounio.fungame.gui.button.FunGameGuiComputerPlayButton;
import com.stounio.fungame.gui.button.FunGameGuiComputerPlayResultButtons;
import com.stounio.fungame.gui.button.FunGameGuiComputerVersusComputerButton;
import com.stounio.fungame.gui.button.FunGameGuiHumanGamePlayOptionButtons;
import com.stounio.fungame.gui.button.FunGameGuiHumanGamePlayResultButtons;
import com.stounio.fungame.gui.button.FunGameGuiHumanVersusComputerButton;
import com.stounio.fungame.gui.component.FunGameGuiLastGamePlayOptionPictures;
import com.stounio.fungame.gui.component.FunGameGuiMainFrame;
import com.stounio.fungame.gui.component.FunGameGuiScoringBoard;

public class FunGameGuiController {

    private static final FunGameGuiController controller = new FunGameGuiController();

    private FunGameGuiMainFrame mainFrame;

    private FunGameGuiHumanVersusComputerButton humanVersusComputerButton;

    private FunGameGuiComputerVersusComputerButton ComputerVersusComputerButton;

    private FunGameGuiHumanGamePlayOptionButtons humanGamePlayOptionButtons;

    private FunGameGuiHumanGamePlayResultButtons humanGamePlayResultButtons;

    private FunGameGuiLastGamePlayOptionPictures lastGamePlayOptionPictures;

    private FunGameGuiComputerPlayButton computerPlayButton;

    private FunGameGuiComputerPlayResultButtons funGameGuiComputerPlayResultButtons;

    private FunGameGuiScoringBoard funGameGuiScoringBoard;

    public static final FunGameGuiController getController() {
        return controller;
    }

    private FunGameGuiController() {
        createMainFrameComponent();
        createHumanVersusComputerButton();
        createComputerVersusHumanButton();
        createHumanGamePlayOptionButtons();
        createHumanGamePlayResultButtons();
        createComputerPlayButton();
        createComputerGamePlayResultButtons();
        createLastGamePlayOptionPictures();
        createScoringBoard();
    }

    private void createMainFrameComponent() {
        mainFrame = new FunGameGuiMainFrame();
        mainFrame.initialize();
    }

    private void createHumanVersusComputerButton() {
        humanVersusComputerButton = new FunGameGuiHumanVersusComputerButton();
        JPanel topPanel = mainFrame.getTopPanel();
        humanVersusComputerButton.addButtonToPanel(topPanel);
    }

    private void createComputerVersusHumanButton() {
        ComputerVersusComputerButton = new FunGameGuiComputerVersusComputerButton();
        JPanel centralPanel = mainFrame.getCentralPanel();
        ComputerVersusComputerButton.addButtonToPanel(centralPanel);
    }

    private void createHumanGamePlayOptionButtons() {
        humanGamePlayOptionButtons = new FunGameGuiHumanGamePlayOptionButtons();
        JPanel centralPanel = mainFrame.getCentralPanel();
        humanGamePlayOptionButtons.addButtonsToPanel(centralPanel);
        hideHumanGamePlayOptionButtons();
    }

    private void createHumanGamePlayResultButtons() {
        humanGamePlayResultButtons = new FunGameGuiHumanGamePlayResultButtons();
        JPanel centralPanel = mainFrame.getCentralPanel();
        humanGamePlayResultButtons.addButtonsToPanel(centralPanel);
        hideHumanGamePlayResultButtons();
    }

    private void createComputerPlayButton() {
        computerPlayButton = new FunGameGuiComputerPlayButton();
        JPanel centralPanel = mainFrame.getCentralPanel();
        computerPlayButton.addButtonToPanel(centralPanel);
        hideComputerPlayButton();
    }

    private void createComputerGamePlayResultButtons() {
        funGameGuiComputerPlayResultButtons = new FunGameGuiComputerPlayResultButtons();
        JPanel centralPanel = mainFrame.getCentralPanel();
        funGameGuiComputerPlayResultButtons.addButtonsToPanel(centralPanel);
        hideComputerGamePlayResultButtons();
    }

    private void createLastGamePlayOptionPictures() {
        lastGamePlayOptionPictures = new FunGameGuiLastGamePlayOptionPictures();
        JPanel topPanel = mainFrame.getTopPanel();
        lastGamePlayOptionPictures.addPicturesToPanel(topPanel);
    }

    private void createScoringBoard() {
        funGameGuiScoringBoard = new FunGameGuiScoringBoard();
        JPanel topPanel = mainFrame.getTopPanel();
        funGameGuiScoringBoard.addScoringBoardToPanel(topPanel);
        hideScoringBoard();
    }

    public void startGame() {
        displayWelcome();
        displayMainFrameComponent();
    }

    private void displayMainFrameComponent() {
        mainFrame.display();
    }

    public void displayWelcome() {
        hideHumanGamePlayOptionButtons();
        hideHumanGamePlayResultButtons();
        hideComputerPlayButton();
        hideComputerGamePlayResultButtons();
        hideLastGamePlayPictures();
        hideScoringBoard();
        displayWelcomeButtons();
    }

    public void displayHumanVersusComputerMode() {
        hideWelcomeButtons();
        hideHumanGamePlayResultButtons();
        hideComputerPlayButton();
        hideComputerGamePlayResultButtons();
        hideLastGamePlayPictures();
        displayScoringBoard();
        displayHumanGamePlayOptionButtons();
    }

    public void displayComputerVersusComputerMode() {
        hideWelcomeButtons();
        hideHumanGamePlayOptionButtons();
        hideLastGamePlayPictures();
        hideComputerGamePlayResultButtons();
        hideLastGamePlayPictures();
        displayScoringBoard();
        displayComputerPlayButton();
    }

    public void displayHumanVersusComputerGamePlayResult(GamePlayResult gamePlayResult) {
        hideWelcomeButtons();
        hideHumanGamePlayOptionButtons();
        hideComputerPlayButton();
        hideComputerGamePlayResultButtons();
        hideScoringBoard();
        displayLastGamePlayPictures();
        displayHumanGamePlayResultButton(gamePlayResult);
    }

    public void displayComputerVersusComputerGamePlayResult(GamePlayResult gamePlayResult) {
        hideWelcomeButtons();
        hideHumanGamePlayOptionButtons();
        hideHumanGamePlayResultButtons();
        hideComputerPlayButton();
        hideScoringBoard();
        displayLastGamePlayPictures();
        displayComputerGamePlayResultButtons(gamePlayResult);
    }

    private void displayWelcomeButtons() {
        humanVersusComputerButton.display();
        ComputerVersusComputerButton.display();
    }

    private void hideWelcomeButtons() {
        humanVersusComputerButton.hide();
        ComputerVersusComputerButton.hide();
    }

    private void displayHumanGamePlayOptionButtons() {
        humanGamePlayOptionButtons.display();
    }

    private void hideHumanGamePlayOptionButtons() {
        humanGamePlayOptionButtons.hide();
    }

    private void displayHumanGamePlayResultButton(GamePlayResult gamePlayResult) {
        humanGamePlayResultButtons.display(gamePlayResult);
    }

    private void hideHumanGamePlayResultButtons() {
        humanGamePlayResultButtons.hide();
    }

    private void displayLastGamePlayPictures() {
        lastGamePlayOptionPictures.display();
    }

    private void hideLastGamePlayPictures() {
        lastGamePlayOptionPictures.hide();
    }

    private void displayComputerPlayButton() {
        computerPlayButton.display();
    }

    private void hideComputerPlayButton() {
        computerPlayButton.hide();
    }

    private void displayComputerGamePlayResultButtons(GamePlayResult gamePlayResult) {
        funGameGuiComputerPlayResultButtons.display(gamePlayResult);
    }

    private void hideComputerGamePlayResultButtons() {
        funGameGuiComputerPlayResultButtons.hide();
    }

    private void displayScoringBoard() {
        funGameGuiScoringBoard.display();
    }

    private void hideScoringBoard() {
        funGameGuiScoringBoard.hide();
    }
}
