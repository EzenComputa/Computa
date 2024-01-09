package com.computa.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
    User findBySsid(String ssid);
}