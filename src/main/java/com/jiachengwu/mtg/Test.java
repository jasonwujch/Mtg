package com.jiachengwu.mtg;

import com.jiachengwu.mtg.model.MTGCard;
import com.jiachengwu.mtg.model.MTGDeck;
import com.jiachengwu.mtg.util.LoadDeck;

public class Test {
	
	@org.junit.Test
	public void test(){
		MTGDeck deck = LoadDeck.loaDeckFromFile("LongForgottenSon (4-0).txt");
		for (MTGCard card : deck.getMainDeck().keySet()) {
			System.out.println(card.getName());
		}
	}

	public static void main(String[] args) {
//		try {
//			Map<String, MTGSet> allSetsMap = LoadAll.getAllSets();
//			MTGSet M15 = allSetsMap.get("M15");
//			List<MTGCard> cards = LoadCards.getAllCards(M15);
//			MTGCard card = cards.get(0);
//			System.out.println(card.toString());
//			
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
