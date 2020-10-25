package com.awysocki.caloriecalculator.wrappers;

import com.awysocki.caloriecalculator.entity.DayIngredient;

/**
 * This class is wrapper of DayIngredient entity.
 * It is used in jsp files.
 */
public class DayIngredientWrapper {

    private DayIngredient dayIngredient;
    private int dayId;

    public DayIngredientWrapper(DayIngredient dayIngredient) {
        this.dayIngredient = dayIngredient;
    }

    public DayIngredient getDayIngredient() {
        return dayIngredient;
    }

    public void setDayIngredient(DayIngredient dayIngredient) {
        this.dayIngredient = dayIngredient;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

}
