package com.computa.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    List<Comment> findByPostId(Long postId);
}
