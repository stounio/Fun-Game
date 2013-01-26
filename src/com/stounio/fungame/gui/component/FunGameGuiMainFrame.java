package com.stounio.fungame.gui.component;

import static com.stounio.fungame.gui.FunGameGuiConstants.BOTTOM_PANEL_HEIGHT;
import static com.stounio.fungame.gui.FunGameGuiConstants.CENTER_PANEL_HEIGHT;
import static com.stounio.fungame.gui.FunGameGuiConstants.PANEL_WIDTH;
import static com.stounio.fungame.gui.FunGameGuiConstants.TOP_PANEL_HEIGHT;
import static com.stounio.fungame.resource.FunGameConstants.FUNGAME_TITLE_KEY;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.stounio.fungame.gui.button.FunGameGuiExitButton;
import com.stounio.fungame.gui.button.FunGameGuiRestartButton;
import com.stounio.fungame.resource.service.ResourceService;

public class FunGameGuiMainFrame {

	private JFrame mainFrame;
	
	private JPanel topPanel;
	
	private JPanel centralPanel;
	
	private JPanel bottomPanel;
	
	private FunGameGuiExitButton funGameGuiExitButton;

	private FunGameGuiRestartButton funGameGuiRestartButton;

	public FunGameGuiMainFrame(){
		mainFrame = new JFrame();
	}
	
	public void initialize(){
		createMainFrame();
		createTopInternalFrame();
		createCentralInternalFrame();
		createBottomInternalFrame();
		addButtonsToBottomPanel();
		pack();
	}

	private void pack() {
		mainFrame.pack();
	}

	private void createMainFrame() {
		mainFrame.setBackground(Color.WHITE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setSize(screenSize);
		mainFrame.setTitle(ResourceService.getService().getResource(FUNGAME_TITLE_KEY));
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createTopInternalFrame() {
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(PANEL_WIDTH, TOP_PANEL_HEIGHT));
		mainFrame.getContentPane().add(topPanel, BorderLayout.NORTH);
	}

	private void createCentralInternalFrame() {
		centralPanel = new JPanel();
		centralPanel.setPreferredSize(new Dimension(PANEL_WIDTH, CENTER_PANEL_HEIGHT));
		mainFrame.getContentPane().add(centralPanel, BorderLayout.CENTER);
	}

	private void createBottomInternalFrame() {
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(PANEL_WIDTH, BOTTOM_PANEL_HEIGHT));
		bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		mainFrame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
	}
	
	public void display() {
		mainFrame.setVisible(true);
	}

	private void addButtonsToBottomPanel() {
		funGameGuiRestartButton = new FunGameGuiRestartButton();
		funGameGuiRestartButton.addRestartButtonToPanel(bottomPanel);
		funGameGuiExitButton = new FunGameGuiExitButton();
		funGameGuiExitButton.addExitButtonToPanel(bottomPanel);
	}

	public JPanel getTopPanel() {
		return topPanel;
	}

	public JPanel getCentralPanel() {
		return centralPanel;
	}
}
