package com.jiachengwu.mtg.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jiachengwu.mtg.dao.MTGCardDao;
import com.jiachengwu.mtg.model.MTGCard;
import com.jiachengwu.mtg.model.MTGDeck;
import com.jiachengwu.mtg.util.FindCard;

public class LoadDeck {
	public static File DECK_FOLDER = new File("C:/Users/Jason Wu/workspace/Mtg/Decks");
	
	public static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/application-config.xml");
	public static MTGCardDao mtgCardDao = context.getBean(MTGCardDao.class);
	
	public static void main(String[] args) {
		File file = new File(DECK_FOLDER,"LongForgottenSon (4-0).txt");
		MTGDeck deck = loaDeckFromFile(file);
		int count = 0;
		for (Integer number : deck.getMainDeck().values()) {
			count += number;
		}
		System.out.println(count);
	}
	
	public static MTGDeck loaDeckFromFile(String fileName){
		File file = new File(DECK_FOLDER,fileName);
		return loaDeckFromFile(file);
	}

	public static MTGDeck loaDeckFromFile(File file){
		MTGDeck deck = new MTGDeck();
		
		ArrayList<ArrayList<String>> blocks = generateBlocks(file, "");
		if (blocks.size()==2) {
			try {
				deck.setMainDeck(processBlock(blocks.get(0)));
				deck.setSideboard(processBlock(blocks.get(1)));
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			deck = null;
		}
		
		return deck;
	}
	
	public static Map<MTGCard, Integer> processBlock(ArrayList<String> block) throws JsonParseException, JsonMappingException, IOException{
		Map<MTGCard, Integer> map = new HashMap<MTGCard, Integer>();
		for (int i = 0; i < block.size(); i++) {
			String line = block.get(i);
			String items[] = line.split("\\s+",2);
			int numberOfCards = Integer.parseInt(items[0].trim());
			String cardName = items[1].trim();
			MTGCard card = mtgCardDao.findByName(cardName);
			map.put(card, numberOfCards);
		}
		return map;
	}
	
	public static ArrayList<ArrayList<String>> generateBlocks(File file, String BLOCK_SEPARATOR){
		ArrayList<ArrayList<String>> blocks = new ArrayList<ArrayList<String>>();
		try {
			//FileReader fr = new FileReader(file); 
			FileInputStream fr = new FileInputStream(file); 
			BufferedReader br = new BufferedReader(new InputStreamReader(fr,"UTF-8"));
			ArrayList<String> block = new ArrayList<String>();
			String line;
			while ((line=br.readLine())!=null) {
				if (line.equals(BLOCK_SEPARATOR)) {
					if (!block.isEmpty()) {
						blocks.add(block);
						block = new ArrayList<String>();
					}
				}
				else {
					block.add(line);
				}
			}
			if (!block.isEmpty()) {
				blocks.add(block);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return blocks;
	}
}
