package com.computa.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.computa.entity.BoardType;
import com.computa.entity.Post;
import com.computa.entity.User;
import com.computa.persistence.PostRepository;
import com.computa.persistence.UserRepository;
import com.computa.service.PostService;

@Service
public class PostServiceImpl implements PostService{
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Post> getPostsByBoardType(BoardType boardType) {
        return postRepository.findByBoardType(boardType);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public void savePost(Long userId, Post post) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        post.setUser(user);
        postRepository.save(post);
    }
}
