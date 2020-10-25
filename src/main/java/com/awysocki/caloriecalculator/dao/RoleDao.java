package com.awysocki.caloriecalculator.dao;


import com.awysocki.caloriecalculator.entity.Role;

public interface RoleDao {

	Role findRoleByName(String theRoleName);
	
}
