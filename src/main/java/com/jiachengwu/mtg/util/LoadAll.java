package com.jiachengwu.mtg.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiachengwu.mtg.model.MTGCard;
import com.jiachengwu.mtg.model.MTGSet;

public class LoadAll {
	public static final File JSON_FOLDER = new File("C:/Users/Jason Wu/workspace/Mtg/Json");
	public static Map<String, MTGSet> getAllSets() throws JsonParseException, JsonMappingException, IOException{

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		@SuppressWarnings("unchecked")
		Map<String, MTGSet>allSetsMap = (Map<String, MTGSet>)mapper.readValue(new File(JSON_FOLDER,"AllSets.json"), new TypeReference<Map<String, MTGSet>>()  {});
		
		return allSetsMap;
	}
	public static List<MTGCard> getAllCards() throws JsonParseException, JsonMappingException, IOException{

		List<MTGCard> allCards = new ArrayList<MTGCard>();
		
		for(MTGSet set : getAllSets().values())
		{
			for(MTGCard card : set.getCards())
			{
				card.setSetCode(set.getCode());
				card.setSetName(set.getName());
				
				allCards.add(card);
			}
		}
		
		return allCards;
	}
}
