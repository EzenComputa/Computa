package com.computa.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computa.entity.Comment;
import com.computa.entity.Post;
import com.computa.entity.User;
import com.computa.persistence.CommentRepository;
import com.computa.persistence.PostRepository;
import com.computa.persistence.UserRepository;
import com.computa.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
    
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public Comment saveComment(Long postId, Long userId, Long parentCommentId, String content) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        Comment parentComment = parentCommentId != null ? commentRepository.findById(parentCommentId).orElseThrow(() -> new RuntimeException("Parent comment not found")) : null;

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setParent(parentComment);
        comment.setContent(content);

        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }
}
