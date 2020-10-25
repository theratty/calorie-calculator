package com.awysocki.caloriecalculator.dao;

import com.awysocki.caloriecalculator.entity.Day;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This is object represents repository for entity Day.
 * It provides operations on database related with Day entity.
 */
@Repository
public class DayDaoImpl implements DayDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void deleteDay(Day day) {
        Session session = sessionFactory.getCurrentSession();

        session.delete(day);
    }

    @Override
    public Day findDayById(int dayId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Day.class, dayId);
    }

    @Override
    public void save(Day day) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(day);
    }
}
