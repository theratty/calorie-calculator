package com.awysocki.caloriecalculator.service;

import com.awysocki.caloriecalculator.entity.Role;
import com.awysocki.caloriecalculator.entity.User;

import com.awysocki.caloriecalculator.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);
    void save(CrmUser crmUser, List<Role> userRoles);
    void save(User user);
}
