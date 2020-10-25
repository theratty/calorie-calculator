package com.awysocki.caloriecalculator.dao;

import com.awysocki.caloriecalculator.entity.Day;

public interface DayDao {

    void deleteDay(Day day);
    Day findDayById(int dayId);

    void save(Day day);
}
