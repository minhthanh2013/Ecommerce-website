package com.doan2.spring.service.userrole;

import com.doan2.spring.dao.userrole.UserRoleDAO;
import com.doan2.spring.entity.UserRole;
import com.doan2.spring.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserRoleServiceImpl implements UserRoleService{
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    UserRoleDAO userRoleDAO;
    @Override
    @Transactional
    public List<String> getUserRoleByUsername(String username) {
        return userRoleRepository.getUserRoleByUsername(username);
    }

    @Override
    @Transactional
    public List<UserRole> getAllByUsername(String username) {
        return userRoleRepository.getAllByUsername(username);
    }

    @Override
    @Transactional
    public List<UserRole> saveAll(List<UserRole> userList) {
        return userRoleRepository.saveAll(userList);
    }

    @Override
    @Transactional
    public void saveUserRole(UserRole userRole) {
        userRoleDAO.saveUserRole(userRole);
    }
}
