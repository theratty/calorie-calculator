package com.awysocki.caloriecalculator.dao;

import com.awysocki.caloriecalculator.entity.DayIngredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This is object represents repository for entity DayIngredient.
 * It provides operations on database related with DayIngredient entity.
 */
@Repository
public class DayIngredientDaoImpl implements DayIngredientDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public DayIngredient findDayIngredientById(int dayIngredientId) {
        Session session = sessionFactory.getCurrentSession();

        DayIngredient dayIngredient = session.get(DayIngredient.class, dayIngredientId);

        return dayIngredient;
    }

    @Override
    public void deleteDayIngredient(DayIngredient dayIngredient) {
        Session session = sessionFactory.getCurrentSession();

        session.delete(dayIngredient);
    }
}
