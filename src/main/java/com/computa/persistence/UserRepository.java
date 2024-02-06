package com.computa.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import com.computa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByUsername(String username);
    // User findBySsid(String ssid);

    // JpaRepository already has a findById(Id id) but it returns Optional<User> 
    // because the findById method might not find a user with the given ID, in which case 
    // returns an empty Optional. 
    // User findById(Long id); 

}