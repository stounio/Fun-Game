package com.gpichot.fungame.game.om;

/**
 * Game play option that composes the actions which can be played in the game. 
 */
public interface GamePlayOption {
	
	/**
	 * Initialize the game play option using the required identifier.
	 * @param identifier
	 */
	void initialize(String identifier);

	/**
	 * Unique identifier of the game play option.
	 * @return
	 */
	String getIdentifier();
	
	/**
	 * Register the identifier of the game play options against which the current game play option wins the point.
	 * @param winningPointIdentifier
	 */
	void registerWinningPointIdentifiers(String winningPointIdentifier);

	/**
	 * Check if the current game play option wins the point against the opponent game play option.
	 * @param opponentGamePlayOption
	 * @return
	 */
	boolean winsPointAgainstOpponent(GamePlayOption opponentGamePlayOption);
	
	/**
	 * Define the key corresponding to the game play option label resource.
	 * @param labelKey
	 */
	void setLabelKey(String labelKey);
	
	String getLabelKey();
	
	/**
	 * Define the key corresponding to the game play option help resource.
	 * @param helpKey
	 */
	void setHelpKey(String helpKey);
	
	String getHelpKey();
	
	/**
	 * Define the path to the right hand picture.
	 */
	void setRightHandPicturePath(String rightHandPicturePath);
	
	String getRightHandPicturePath();
	
	/**
	 * Define the path to the left hand picture.
	 */
	void setLeftHandPicturePath(String leftHandPicturePath);
	
	String getLeftHandPicturePath();
}
