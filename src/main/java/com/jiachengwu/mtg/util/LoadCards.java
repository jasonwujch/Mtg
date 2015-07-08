package com.jiachengwu.mtg.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jiachengwu.mtg.model.MTGCard;
import com.jiachengwu.mtg.model.MTGSet;

public class LoadCards {
	
	public static List<MTGCard> getAllCards(Map<String, MTGSet> sets)
	{
		List<MTGCard> allCards = new ArrayList<MTGCard>();
		
		for(MTGSet set : sets.values())
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
	
	public static List<MTGCard> getAllCards(Set<MTGSet> sets)
	{
		List<MTGCard> allCards = new ArrayList<MTGCard>();
		
		for(MTGSet set : sets)
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
	
	public static List<MTGCard> getAllCards(MTGSet set)
	{
		List<MTGCard> allCards = new ArrayList<MTGCard>();
		
		for(MTGCard card : set.getCards())
		{
			card.setSetCode(set.getCode());
			card.setSetName(set.getName());

			allCards.add(card);
		}
		
		return allCards;
	}
}
