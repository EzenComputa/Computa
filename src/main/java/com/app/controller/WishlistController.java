package com.app.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entity.User;
import com.app.entity.Wishlist;
import com.app.service.UserService;
import com.app.service.WishlistService;

@Controller
public class WishlistController {

    private final WishlistService wishlistService;
    private UserService userService;

    public WishlistController(WishlistService wishlistService, 
                              UserService userService) {
        this.wishlistService = wishlistService;
        this.userService = userService;
    }

    @GetMapping("/wishlist")
    public String getWishlist(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        if (currentUser == null) {
            return "redirect:/login";
        }
        User user = userService.findUserByUsername(currentUser.getUsername());
        List<Wishlist> wishlist = wishlistService.getWishlistByUserId(user.getId());
        model.addAttribute("wishlist", wishlist);
        return "wishlist";
    }

    @PostMapping("/wishlist/add")
    public String addToWishlist(@RequestParam Long productId, @AuthenticationPrincipal UserDetails currentUser) {
        User user = userService.findUserByUsername(currentUser.getUsername());
        wishlistService.addProductToWishlist(user.getId(), productId);
        return "redirect:/wishlist";
    }

    
}