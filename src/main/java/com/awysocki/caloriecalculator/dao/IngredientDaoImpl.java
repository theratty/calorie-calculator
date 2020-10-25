package com.awysocki.caloriecalculator.dao;

import com.awysocki.caloriecalculator.entity.Ingredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is object represents repository for entity Ingredient.
 * It provides operations on database related with Ingredient entity.
 */
@Repository
public class IngredientDaoImpl implements IngredientDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Ingredient> getIngredients(String name) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Ingredient> theQuery = currentSession.createQuery("from Ingredient where lower(name) like :ingredientName",
                Ingredient.class);

        theQuery.setParameter("ingredientName", "%" + name.toLowerCase() + "%");

        List<Ingredient> ingredients;

        try {
            ingredients = theQuery.getResultList();
        } catch (Exception e) {
            ingredients = null;
        }

        return ingredients;
    }

    @Override
    public List<Ingredient> getAll() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Ingredient> theQuery = currentSession.createQuery("from Ingredient",
                Ingredient.class);
        List<Ingredient> ingredients = theQuery.getResultList();

        return ingredients;
    }

    @Override
    public void save(Ingredient ingredient) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(ingredient);
    }

    @Override
    public Ingredient getIngredient(int ingredientId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Ingredient.class, ingredientId);
    }
}
