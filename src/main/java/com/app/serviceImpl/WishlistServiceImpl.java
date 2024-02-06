package com.app.serviceImpl;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.entity.Wishlist;
import com.app.entity.pcparts.Product;
import com.app.exceptions.ResourceNotFoundException;
import com.app.persistence.UserRepository;
import com.app.persistence.WishlistRepository;
import com.app.persistence.pcparts.ProductRepository;
import com.app.service.WishlistService;

@Service
public class WishlistServiceImpl implements WishlistService{

    private final WishlistRepository wishlistRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public WishlistServiceImpl(WishlistRepository wishlistRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.wishlistRepository = wishlistRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public List<Wishlist> getWishlistByUserId(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }

    public void addProductToWishlist(Long userId, Long productId) {
    User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    Wishlist wishlist = new Wishlist(null, user, product);
    wishlistRepository.save(wishlist);
}
}