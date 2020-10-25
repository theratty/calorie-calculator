package com.awysocki.caloriecalculator.service;

import com.awysocki.caloriecalculator.entity.Ingredient;

import java.util.List;


public interface IngredientService {

    Ingredient findById(int ingredientId);
    List<Ingredient> findByName(String name);
    List<Ingredient> findAll();

    void saveIngredient(Ingredient ingredient);
}
