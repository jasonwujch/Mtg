package com.jiachengwu.mtg.model;

import java.util.Map;

public class MTGDeck {
	private Map<MTGCard, Integer> mainDeck;
	private Map<MTGCard, Integer> sideboard;
	
	public MTGDeck(){}
	
	public MTGDeck(Map<MTGCard, Integer> mainDeck,
			Map<MTGCard, Integer> sideboard) {
		super();
		this.mainDeck = mainDeck;
		this.sideboard = sideboard;
	}
	public Map<MTGCard, Integer> getMainDeck() {
		return mainDeck;
	}
	public void setMainDeck(Map<MTGCard, Integer> mainDeck) {
		this.mainDeck = mainDeck;
	}
	public Map<MTGCard, Integer> getSideboard() {
		return sideboard;
	}
	public void setSideboard(Map<MTGCard, Integer> sideboard) {
		this.sideboard = sideboard;
	}
}
