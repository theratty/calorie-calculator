package com.awysocki.caloriecalculator.dao;

import com.awysocki.caloriecalculator.entity.DayIngredient;

public interface DayIngredientDao {

    DayIngredient findDayIngredientById(int dayIngredientId);
    void deleteDayIngredient(DayIngredient dayIngredient);
}
