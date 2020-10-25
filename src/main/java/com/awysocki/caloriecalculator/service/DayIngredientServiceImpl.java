package com.awysocki.caloriecalculator.service;

import com.awysocki.caloriecalculator.dao.DayIngredientDao;
import com.awysocki.caloriecalculator.entity.DayIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * This class is implementation of service for DayIngredient entity.
 * It provides transactional operations on DayIngredientDao repository.
 */
@Service
public class DayIngredientServiceImpl implements DayIngredientService {

    @Autowired
    private DayIngredientDao dayIngredientDao;

    @Override
    @Transactional
    public DayIngredient findDayIngredientById(int dayIngredientId) {

        return dayIngredientDao.findDayIngredientById(dayIngredientId);
    }

    @Override
    @Transactional
    public void deleteDayIngredient(DayIngredient dayIngredient) {

        dayIngredientDao.deleteDayIngredient(dayIngredient);
    }
}
