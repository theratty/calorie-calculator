package com.awysocki.caloriecalculator.service;

import com.awysocki.caloriecalculator.entity.Role;


public interface RoleService {

    Role findByName(String roleName);
}
