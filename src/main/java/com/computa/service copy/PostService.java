package com.computa.service;

import java.util.List;

import com.computa.entity.BoardType;
import com.computa.entity.Post;

public interface PostService {
    
    List<Post> getPostsByBoardType(BoardType boardType);

    Post getPostById(Long id);

    void savePost(Long userId, Post post);
}
