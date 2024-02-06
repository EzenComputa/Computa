package com.app.service;

import java.util.List;

import com.app.entity.Wishlist;

public interface WishlistService {

    List<Wishlist> getWishlistByUserId(Long userId);

    void addProductToWishlist(Long userId, Long productId);
}