package com.doan2.spring.service.userrole;

import com.doan2.spring.entity.UserRole;


import java.util.List;

public interface UserRoleService {
    List<String> getUserRoleByUsername(String username);
    List<UserRole> getAllByUsername(String username);
    List<UserRole> saveAll(List<UserRole> userList);
    void saveUserRole(UserRole userRole);

}
