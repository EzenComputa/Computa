package com.computa.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.BoardType;
import com.computa.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
    List<Post> findByBoardType(BoardType boardType);
}
