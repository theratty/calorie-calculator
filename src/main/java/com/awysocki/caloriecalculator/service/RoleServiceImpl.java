package com.awysocki.caloriecalculator.service;

import com.awysocki.caloriecalculator.dao.RoleDao;
import com.awysocki.caloriecalculator.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is implementation of service for Role entity.
 * It provides transactional operations on RoleDao repository.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional
    public Role findByName(String roleName) {

        return roleDao.findRoleByName(roleName);
    }
}
