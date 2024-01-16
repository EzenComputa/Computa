package com.computa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.computa.entity.BoardType;
import com.computa.entity.Comment;
import com.computa.entity.Post;
import com.computa.entity.User;
import com.computa.service.CommentService;
// import com.computa.security.CustomUserDetails;
import com.computa.service.PostService;
import com.computa.service.UserService;

@Controller
public class PostController {
    
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    public PostController(PostService postService, UserService userService, CommentService commentService) {
        this.postService = postService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @GetMapping("/support_tickets")
    public String showSupportTickets(Model model){
        model.addAttribute("posts", postService.getPostsByBoardType(BoardType.SUPPORT_TICKETS));
        return "supportTickets";
    }

    @GetMapping("/general_questions")
    public String showGeneralQuestions(Model model) {
        model.addAttribute("posts", postService.getPostsByBoardType(BoardType.GENERAL_QUESTIONS));
        return "generalQuestions";
    }

    @GetMapping("/buy_sell")
    public String showBuySell(Model model) {
        model.addAttribute("posts", postService.getPostsByBoardType(BoardType.BUY_SELL));
        return "buySell";
    }

    @GetMapping("/postDetails/{id}")
    public String showPostDetails(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        List<Comment> comments = commentService.getCommentsByPostId(id);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        return "postDetails";
    }

    @GetMapping("/writePost/{boardType}")
    public String showWritePost(@PathVariable BoardType boardType, Model model, @AuthenticationPrincipal UserDetails currentUser) {
        User user = userService.findUserByUsername(currentUser.getUsername());
        if (user == null) {
            return "redirect:/login";
        }
        Post post = new Post();
        post.setBoardType(boardType);
        model.addAttribute("boardType", boardType);
        model.addAttribute("post", post);
        return "writePost";
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute Post post, @RequestParam BoardType boardType, @AuthenticationPrincipal UserDetails currentUser) {
        if (currentUser == null) {
            return "redirect:/login";
        }
        User user = userService.findUserByUsername(currentUser.getUsername());
        post.setBoardType(boardType);
        postService.savePost(user.getId(), post);
        return "redirect:/"+boardType.name().toLowerCase();
    }

}
