package com.spring.demoblog.repository;

import com.spring.demoblog.entity.Role;
import com.spring.demoblog.entity.RoleName;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    public Optional<Role> findByName(RoleName roleName);
}
