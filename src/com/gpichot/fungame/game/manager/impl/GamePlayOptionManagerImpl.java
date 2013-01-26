package com.gpichot.fungame.game.manager.impl;

import static com.gpichot.fungame.game.manager.GamePlayConstants.GAME_PLAY_OPTIONS_PROPERTY_FILE_NAME;
import static com.gpichot.fungame.game.manager.GamePlayConstants.GAME_PLAY_OPTION_HELP_PROPERTY_KEY;
import static com.gpichot.fungame.game.manager.GamePlayConstants.GAME_PLAY_OPTION_IDENTIFIER_PROPERTY_KEY;
import static com.gpichot.fungame.game.manager.GamePlayConstants.GAME_PLAY_OPTION_LABEL_PROPERTY_KEY;
import static com.gpichot.fungame.game.manager.GamePlayConstants.GAME_PLAY_OPTION_PICTURE_LEFT_HAND_KEY;
import static com.gpichot.fungame.game.manager.GamePlayConstants.GAME_PLAY_OPTION_PICTURE_RIGHT_HAND_KEY;
import static com.gpichot.fungame.game.manager.GamePlayConstants.GAME_PLAY_OPTION_PROPERTY_FILE_DIRECTORY;
import static com.gpichot.fungame.game.manager.GamePlayConstants.GAME_PLAY_OPTION_PROPERTY_FILE_NAME;
import static com.gpichot.fungame.game.manager.GamePlayConstants.GAME_PLAY_OPTION_WINNING_POINTS_PROPERTY_KEY;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.gpichot.fungame.factory.GamePlayOptionFactory;
import com.gpichot.fungame.game.manager.GamePlayOptionManager;
import com.gpichot.fungame.game.om.GamePlayOption;

public class GamePlayOptionManagerImpl implements GamePlayOptionManager {
	
	private final Map<String, GamePlayOption> gamePlayOptionsByIdenitifer;
	
	private final List<GamePlayOption> gamePlayOptions;
	
	public GamePlayOptionManagerImpl(){
		gamePlayOptionsByIdenitifer = new HashMap<String, GamePlayOption>();
		gamePlayOptions = new ArrayList<GamePlayOption>();
	}
	
	@Override
	public void intialize() {
		Properties gamePlayOptionsProperties = retrieveProperties(GAME_PLAY_OPTION_PROPERTY_FILE_DIRECTORY + GAME_PLAY_OPTIONS_PROPERTY_FILE_NAME);
		int index = 1;
		do{
			String gamePlayOptionPropertyFileName = gamePlayOptionsProperties.getProperty(GAME_PLAY_OPTION_PROPERTY_FILE_NAME + index);
			if(gamePlayOptionPropertyFileName!= null){
				initalizeGamePlayOptionFromPropertyFile(gamePlayOptionPropertyFileName);
				index++;
			} else {
				break;
			}
		} while(true);
	}


	private void initalizeGamePlayOptionFromPropertyFile(
			String gamePlayOptionPropertyFileName) {
		Properties gamePlayOptionProperties = retrieveProperties(GAME_PLAY_OPTION_PROPERTY_FILE_DIRECTORY + gamePlayOptionPropertyFileName);
		String gamePlayOptionIdentifier = retrieveMandatoryProperty(gamePlayOptionProperties,GAME_PLAY_OPTION_IDENTIFIER_PROPERTY_KEY);
		GamePlayOption gamePlayOption = createGamePlayOption(gamePlayOptionIdentifier);
		String labelKey = retrieveMandatoryProperty(gamePlayOptionProperties,GAME_PLAY_OPTION_LABEL_PROPERTY_KEY);
		gamePlayOption.setLabelKey(labelKey);
		String helpKey = retrieveMandatoryProperty(gamePlayOptionProperties,GAME_PLAY_OPTION_HELP_PROPERTY_KEY);
		gamePlayOption.setHelpKey(helpKey);
		String rightHandPicturePath = retrieveMandatoryProperty(gamePlayOptionProperties,GAME_PLAY_OPTION_PICTURE_RIGHT_HAND_KEY);
		gamePlayOption.setRightHandPicturePath(rightHandPicturePath);
		String leftHandPicturePath = retrieveMandatoryProperty(gamePlayOptionProperties,GAME_PLAY_OPTION_PICTURE_LEFT_HAND_KEY);
		gamePlayOption.setLeftHandPicturePath(leftHandPicturePath);
		int index = 1;
		do{
			String winningPointIdentifier = gamePlayOptionProperties.getProperty(GAME_PLAY_OPTION_WINNING_POINTS_PROPERTY_KEY+index);
			if (winningPointIdentifier != null){
				gamePlayOption.registerWinningPointIdentifiers(winningPointIdentifier);
				index++;
			}
			else{
				break;
			}
		}while(true);
		registerGamePlayOption(gamePlayOptionIdentifier,gamePlayOption);
	}

	private GamePlayOption createGamePlayOption(String gamePlayOptionIdentifierIdentifier) {
		GamePlayOption gamePlayOption = GamePlayOptionFactory.getFactory().newInstance(gamePlayOptionIdentifierIdentifier);
		return gamePlayOption;
	}
	
	/**
	 * @throws IllegalStateException if the manager tries to register a game play option that has already been registered.
	 * @param gamePlayOptionIdentifier
	 * @param gamePlayOption
	 */
	private void registerGamePlayOption(String gamePlayOptionIdentifier, GamePlayOption gamePlayOption) {
		if(gamePlayOptionsByIdenitifer.containsKey(gamePlayOptionIdentifier)){
			throw new IllegalStateException("Cannot register twice the same game play option");
		}
		gamePlayOptionsByIdenitifer.put(gamePlayOptionIdentifier, gamePlayOption);
		gamePlayOptions.add(gamePlayOption);
	}

	@Override
	public boolean isInitialized() {
		return !gamePlayOptions.isEmpty();
	}

	/**
	 * @throws InvalidParameterException if no game play option is found for the provided identifier.
	 */
	@Override
	public GamePlayOption findGamePlayOption(String gamePlayOptionIdentifier) {
		if(gamePlayOptionsByIdenitifer.containsKey(gamePlayOptionIdentifier)){
			return gamePlayOptionsByIdenitifer.get(gamePlayOptionIdentifier);
		}
		throw new InvalidParameterException("No game play option found for the following identifier : " + gamePlayOptionIdentifier);
	}
	
	@Override
	public List<GamePlayOption> retrieveAllGamePlayOptions() {
		return Collections.unmodifiableList(gamePlayOptions);
	}
	
	// UTILITY METHODS
	/**
	 * @throws IllegalStateException if the property file to initialize has not been found.
	 */
	private Properties retrieveProperties(String propertyRelativeFilePath) {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(propertyRelativeFilePath));
		} catch (FileNotFoundException e) {
			throw new IllegalStateException(e);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
		return properties;
	}
	
	private String retrieveMandatoryProperty(Properties properties, String propertyKey){
		String property = properties.getProperty(propertyKey);
		if(property==null){
			throw new InvalidParameterException("The property "+ propertyKey + " has not been correctly set in the property file");
		}
		return property;
	}
}
