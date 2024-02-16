package com.app.persistence;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.User;

public interface FindPwRepository extends JpaRepository<User,Long>{
   User findByUsernameAndNameAndSsid(String username, String name, String ssid);
} 