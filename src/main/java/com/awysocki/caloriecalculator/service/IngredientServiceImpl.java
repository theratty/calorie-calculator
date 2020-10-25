package com.awysocki.caloriecalculator.service;

import com.awysocki.caloriecalculator.dao.IngredientDao;
import com.awysocki.caloriecalculator.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class is implementation of service for Ingredient entity.
 * It provides transactional operations on IngredientDao repository.
 */
@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientDao ingredientDao;

    @Override
    @Transactional
    public List<Ingredient> findByName(String name) {

        return ingredientDao.getIngredients(name);
    }

    @Override
    @Transactional
    public List<Ingredient> findAll() {

        return ingredientDao.getAll();
    }

    @Override
    @Transactional
    public void saveIngredient(Ingredient ingredient) {

        ingredientDao.save(ingredient);
    }

    @Override
    @Transactional
    public Ingredient findById(int ingredientId) {
        return ingredientDao.getIngredient(ingredientId);
    }


}
