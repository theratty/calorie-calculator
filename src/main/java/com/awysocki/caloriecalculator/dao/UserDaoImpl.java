package com.awysocki.caloriecalculator.dao;

import com.awysocki.caloriecalculator.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This is object represents repository for entity User.
 * It provides operations on database related with User entity.
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String name) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<User> query = currentSession.createQuery("from User where userName = :name", User.class);
		query.setParameter("name", name);

		User user;

		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			user = null;
		}

		return user;
	}

	@Override
	public void save(User theUser) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theUser);
	}

}
