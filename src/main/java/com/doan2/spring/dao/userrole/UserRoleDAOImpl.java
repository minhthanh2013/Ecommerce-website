package com.doan2.spring.dao.userrole;

import com.doan2.spring.entity.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDAOImpl implements UserRoleDAO{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveUserRole(UserRole userRole) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(userRole);
    }
}
