package com.stounio.fungame.game.om.impl;

import java.util.ArrayList;
import java.util.List;

import com.stounio.fungame.game.om.GamePlayOption;

public class GamePlayOptionImpl implements GamePlayOption {

	private List<String> winningPointIdentifiers;
	
	private String identifier;

	private String labelKey;

	private String helpKey;

	private String rightHandPicturePath;

	private String leftHandPicturePath;

	public GamePlayOptionImpl(){
		winningPointIdentifiers = new ArrayList<String>();
	}
	
	@Override
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public void initialize(String identifier) {
		if (isAlreadyInitialized()){
			throw new IllegalStateException("Game play option has already been initialized");
		}
		this.identifier = identifier;
	}

	private boolean isAlreadyInitialized() {
		return identifier != null;
	}

	@Override
	public void registerWinningPointIdentifiers(String winningPointIdentifier) {
		winningPointIdentifiers.add(winningPointIdentifier);
	}

	
	
	@Override
	public boolean winsPointAgainstOpponent(GamePlayOption opponentGamePlayOption) {
		String opponentIdentifier = opponentGamePlayOption.getIdentifier();
		return winningPointIdentifiers.contains(opponentIdentifier);
	}

	
	@Override
	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

	@Override
	public String getLabelKey() {
		return labelKey;
	}

	@Override
	public void setHelpKey(String helpKey) {
		this.helpKey = helpKey;
	}

	@Override
	public String getHelpKey() {
		return helpKey;
	}
	
	@Override
	public void setRightHandPicturePath(String rightHandPicturePath) {
		this.rightHandPicturePath = rightHandPicturePath;
	}

	@Override
	public String getRightHandPicturePath() {
		return rightHandPicturePath;
	}

	@Override
	public void setLeftHandPicturePath(String leftHandPicturePath) {
		this.leftHandPicturePath = leftHandPicturePath;
	}

	@Override
	public String getLeftHandPicturePath() {
		return leftHandPicturePath;
	}

	// GENERATED METHODS 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identifier == null) ? 0 : identifier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GamePlayOptionImpl other = (GamePlayOptionImpl) obj;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		return true;
	}

	
}
