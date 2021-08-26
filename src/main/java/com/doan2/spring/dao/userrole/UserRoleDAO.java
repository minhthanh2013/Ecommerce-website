package com.doan2.spring.dao.userrole;

import com.doan2.spring.entity.UserRole;
import org.springframework.data.jpa.repository.Query;

public interface UserRoleDAO {

    void saveUserRole(UserRole userRole);
}
