package com.awysocki.caloriecalculator.dao;


import com.awysocki.caloriecalculator.entity.Ingredient;

import java.util.List;

public interface IngredientDao {

	List<Ingredient> getIngredients(String name);
	List<Ingredient> getAll();
	void save(Ingredient ingredient);

	Ingredient getIngredient(int ingredientId);

}
