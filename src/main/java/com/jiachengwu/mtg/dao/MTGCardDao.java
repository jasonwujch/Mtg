package com.jiachengwu.mtg.dao;

import java.util.List;

import com.jiachengwu.mtg.model.MTGCard;

public interface MTGCardDao {
	public void save(MTGCard card);
	
	public List<MTGCard> list();
	
	public MTGCard findByName(String name);
}
