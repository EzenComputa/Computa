package com.computa.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import com.computa.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}