package com.jiachengwu.mtg;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiachengwu.mtg.model.MTGCard;
import com.jiachengwu.mtg.model.MTGSet;


public class LoadAllCards {
	public static final File JSON_FOLDER = new File("C:/Users/Jason Wu/workspace/Mtg/Json");
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		@SuppressWarnings("unchecked")
		List<MTGCard> allCards = getAllCards((Map<String, MTGSet>)mapper.readValue(new File(JSON_FOLDER,"AllSets.json"), new TypeReference<Map<String, MTGSet>>()  {}));
		
		System.out.println("Number of cards: " + allCards.size());
	}
	
	public static List<MTGCard> getAllCards(Map<String, MTGSet> sets)
	{
		List<MTGCard> allCards = new ArrayList<MTGCard>();
		
		for(MTGSet set : sets.values())
		{
			for(MTGCard card : set.getCards())
			{
				//card.setSetCode(set.getCode());
				//card.setSetName(set.getName());
				//System.out.println(set.getName() + ": " + card.getName());
				
				allCards.add(card);
			}
		}
		
		return allCards;
	}
	
	public static List<MTGCard> getAllCards(Set<MTGSet> sets)
	{
		List<MTGCard> allCards = new ArrayList<MTGCard>();
		
		for(MTGSet set : sets)
		{
			for(MTGCard card : set.getCards())
			{
				//card.setSetCode(set.getCode());
				//card.setSetName(set.getName());
				//System.out.println(set.getName() + ": " + card.getName());
				
				allCards.add(card);
			}
		}
		
		return allCards;
	}
	
	public static List<MTGCard> getAllCards(MTGSet set)
	{
		List<MTGCard> allCards = new ArrayList<MTGCard>();
		
		for(MTGCard card : set.getCards())
		{
			//card.setSetCode(set.getCode());
			//card.setSetName(set.getName());
			//System.out.println(set.getName() + ": " + card.getName());

			allCards.add(card);
		}
		
		return allCards;
	}
}
