package com.awysocki.caloriecalculator.wrappers;

import com.awysocki.caloriecalculator.entity.Day;
import com.awysocki.caloriecalculator.entity.DayIngredient;

/**
 * This class is wrapper of Day entity.
 * It is used in jsp files.
 */
public class DayWrapper {

    private Day day;
    private int totalKcal = 0;
    private float totalProteins = 0;
    private float totalCarbs = 0;
    private float totalFats = 0;

    public DayWrapper(Day day) {
        this.day = day;

        for (DayIngredient dayIngredient : day.getDayIngredients()) {
            int ingredientAmount = dayIngredient.getAmount();

            int ingredientCarbs = dayIngredient.getIngredient().getCarbs();
            int ingredientFats = dayIngredient.getIngredient().getFats();
            int ingredientProteins = dayIngredient.getIngredient().getProteins();

            totalCarbs += ingredientAmount * ingredientCarbs / 100.0;
            totalFats += ingredientAmount * ingredientFats / 100.0;
            totalProteins += ingredientAmount * ingredientProteins / 100.0;
        }

        totalKcal = (int) (totalCarbs * 4 + totalFats * 9 + totalProteins * 4);
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public int getTotalKcal() {
        return totalKcal;
    }

    public void setTotalKcal(int totalKcal) {
        this.totalKcal = totalKcal;
    }

    public float getTotalProteins() {
        return totalProteins;
    }

    public void setTotalProteins(float totalProteins) {
        this.totalProteins = totalProteins;
    }

    public float getTotalCarbs() {
        return totalCarbs;
    }

    public void setTotalCarbs(float totalCarbs) {
        this.totalCarbs = totalCarbs;
    }

    public float getTotalFats() {
        return totalFats;
    }

    public void setTotalFats(float totalFats) {
        this.totalFats = totalFats;
    }
}
