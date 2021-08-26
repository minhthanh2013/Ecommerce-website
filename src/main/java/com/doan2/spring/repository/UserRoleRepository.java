package com.doan2.spring.repository;

import com.doan2.spring.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    @Query("select s.role from UserRole s where s.username = ?1")
    List<String> getUserRoleByUsername(String username);

    @Query("select s from UserRole s where s.username = ?1")
    List<UserRole> getAllByUsername(String username);


}
