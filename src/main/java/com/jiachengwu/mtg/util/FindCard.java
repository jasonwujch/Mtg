package com.jiachengwu.mtg.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jiachengwu.mtg.model.MTGCard;

public class FindCard {
	public static MTGCard findCardByName(String name) throws JsonParseException, JsonMappingException, IOException{
		return findCardByName(name, LoadAll.getAllCards());
	}
	
	public static MTGCard findCardByName(String name, List<MTGCard> cards) throws JsonParseException, JsonMappingException, IOException{
		for (MTGCard card : cards) {
			if (card.getName().equals(name)) {
				return card;
			}
		}
		return null;
	}
}
