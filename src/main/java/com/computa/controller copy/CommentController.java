package com.computa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.computa.service.CommentService;
import com.computa.service.UserService;

@Controller
public class CommentController {
    
    // why are some final and some not?
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    
    @PostMapping("/saveComment")
    public String saveComment(@RequestParam Long postId, @RequestParam(required = false) Long parentCommentId, @RequestParam String content, @AuthenticationPrincipal UserDetails currentUser) {
        Long userId = userService.findUserByUsername(currentUser.getUsername()).getId();
        commentService.saveComment(postId, userId, parentCommentId, content);
        return "redirect:/postDetails/" + postId;
    }

}
