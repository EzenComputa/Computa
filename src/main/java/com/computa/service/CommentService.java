package com.computa.service;

import java.util.List;

import com.computa.entity.Comment;

public interface CommentService {
    
    Comment saveComment(Long postId, Long userId, Long parentCommentId, String content);

    List<Comment> getCommentsByPostId(Long postId);
}
