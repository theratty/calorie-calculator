package com.awysocki.caloriecalculator.dao;


import com.awysocki.caloriecalculator.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
