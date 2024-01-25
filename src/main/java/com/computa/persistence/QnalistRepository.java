package com.computa.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.QnaList;
import com.computa.entity.User;

public interface QnalistRepository extends JpaRepository<QnaList, Long> {

    List<QnaList> findByUserId(Long userId);

    // List<QnaList> findByDate(String date);
    

    
}
