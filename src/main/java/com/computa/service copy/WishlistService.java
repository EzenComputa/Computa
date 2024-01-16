package com.computa.service;

import java.util.List;

import com.computa.entity.Wishlist;

public interface WishlistService {

    List<Wishlist> getWishlistByUserId(Long userId);

    void addProductToWishlist(Long userId, Long productId);
}