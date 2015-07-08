package com.jiachengwu.mtg.database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jiachengwu.mtg.dao.MTGCardDao;
import com.jiachengwu.mtg.model.MTGCard;
import com.jiachengwu.mtg.util.LoadAll;

public class LoadCards {

	@Test
	public void test(){
		try {
			List<MTGCard> cards = LoadAll.getAllCards();
			MTGCard card = cards.get(13157);
			System.out.println(card.getName().length());
			System.out.println(card.getManaCost());
			
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
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/application-config.xml");
		MTGCardDao mtgCardDao = context.getBean(MTGCardDao.class);
		try {
			List<MTGCard> cards = LoadAll.getAllCards();
			for (int i = 13157; i < cards.size(); i++) {
				MTGCard card = cards.get(i);
				card.setNamesString(processArrayListString(card.getNames()));
				card.setColorsString(processArrayListString(card.getColors()));
				card.setSupertypesString(processArrayListString(card.getSupertypes()));
				card.setTypesString(processArrayListString(card.getTypes()));
				card.setSubtypesString(processArrayListString(card.getSubtypes()));
				card.setVariationsString(processArrayListString(card.getVariations()));
				System.out.println(i);
				mtgCardDao.save(card);
			}
			
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
		
		context.close();
	}
	
	public static String processArrayListString(ArrayList<String> list){
		String string = "";
		if (list==null) {
			return null;
		}
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size()-1; i++) {
				string += list.get(i)+",";
			}
			string += list.get(list.size()-1);
		}
		return string;
	}

}
