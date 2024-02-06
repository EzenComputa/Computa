package com.app.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Qna;
import com.app.entity.QnaComment;

public interface QnaCommentRepository extends JpaRepository<QnaComment, Long>{
    List<QnaComment> findCommentByQna(Qna qna);
    List<QnaComment> findByParentIsNullAndQnaOrderByCreatedDateAsc(Qna qna);
}
