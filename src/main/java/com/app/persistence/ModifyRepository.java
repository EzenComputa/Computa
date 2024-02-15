package com.app.persistence;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


import com.app.entity.User;

public interface ModifyRepository extends JpaRepository<User, Long>{
    List<User> findAll();    
}


