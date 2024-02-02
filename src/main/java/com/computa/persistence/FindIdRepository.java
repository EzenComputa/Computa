package com.computa.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.User;

public interface FindIdRepository extends JpaRepository<User, Long> {

    User findByName(String name); // 콤푸타에 엔티티를 가져옴

}