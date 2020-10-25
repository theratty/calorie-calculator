package com.awysocki.caloriecalculator.service;

import com.awysocki.caloriecalculator.dao.DayDao;
import com.awysocki.caloriecalculator.entity.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is implementation of service for Day entity.
 * It provides transactional operations on DayDao repository.
 */
@Service
public class DayServiceImpl implements DayService {

    @Autowired
    private DayDao dayDao;

    @Override
    @Transactional
    public void deleteDay(Day day) {

        dayDao.deleteDay(day);
    }

    @Override
    @Transactional
    public Day findDayById(int dayId) {

        return dayDao.findDayById(dayId);
    }

    @Override
    @Transactional
    public void save(Day day) {
        dayDao.save(day);
    }
}
