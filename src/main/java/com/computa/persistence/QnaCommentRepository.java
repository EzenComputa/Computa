package com.computa.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.Qna;
import com.computa.entity.QnaComment;

public interface QnaCommentRepository extends JpaRepository<QnaComment, Long>{
    List<QnaComment> findCommentByQna(Qna qna);
}
