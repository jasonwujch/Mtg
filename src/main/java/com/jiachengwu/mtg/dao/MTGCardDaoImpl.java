package com.jiachengwu.mtg.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.jiachengwu.mtg.model.MTGCard;

public class MTGCardDaoImpl implements MTGCardDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(MTGCard card) {
		Session session = sessionFactory.getCurrentSession();
		session.save(card);
	}

	@SuppressWarnings("unchecked")
	public List<MTGCard> list() {
		Session session = this.sessionFactory.openSession();
		List<MTGCard> cards = session.createQuery("from MTGCard").list();
		session.close();
		return cards;
	}
	
	@Transactional
	public MTGCard findByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from MTGCard where name = :name");
		query.setParameter("name", name);
		
		List list = query.list();
		if (list==null||list.isEmpty()){
			return null;
		}
		
		tx.commit();
		
		return (MTGCard) list.get(0);
	}

}
