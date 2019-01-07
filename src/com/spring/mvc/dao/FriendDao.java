package com.spring.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.beans.Friend;
import com.spring.mvc.entity.FriendEntity;

@Repository("friendDao")
public class FriendDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveToDB(Friend friend) {
		FriendEntity fEntity = new FriendEntity(friend);
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		Transaction trx = session.beginTransaction();
		session.saveOrUpdate(fEntity);
		session.flush();
		trx.commit();
		session.close();
	}

	public List<Friend> listFriends() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

		CriteriaQuery<FriendEntity> criteriaQuery = session.getCriteriaBuilder().createQuery(FriendEntity.class);
		criteriaQuery.from(FriendEntity.class);

		List<FriendEntity> friendList = session.createQuery(criteriaQuery).getResultList();
		session.close();

		List<Friend> friends = new ArrayList<>();
		for (FriendEntity fr : friendList) {
			Friend friendBean = new Friend();
			friendBean.setId(fr.getId());
			friendBean.setFriendName(fr.getFriendName());
			friendBean.setLocation(fr.getLocation());
			friends.add(friendBean);

		}

		return friends;
	}

	public void deleteFriend(int id) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		Transaction trx = session.beginTransaction();
		FriendEntity friendEntity = session.get(FriendEntity.class, id);
		session.delete(friendEntity);
		session.flush();
		trx.commit();
		session.close();
		
	}

}
