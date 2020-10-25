package com.awysocki.caloriecalculator.service;

import com.awysocki.caloriecalculator.entity.DayIngredient;

public interface DayIngredientService {

    DayIngredient findDayIngredientById(int dayIngredientId);
    void deleteDayIngredient(DayIngredient dayIngredient);
}
