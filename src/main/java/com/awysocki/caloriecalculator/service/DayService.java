package com.awysocki.caloriecalculator.service;

import com.awysocki.caloriecalculator.entity.Day;

public interface DayService {

    void deleteDay(Day day);
    Day findDayById(int dayId);

    void save(Day day);
}
