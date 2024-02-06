package com.computa.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findByUserId(Long userId);
}