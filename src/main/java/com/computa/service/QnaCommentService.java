package com.computa.service;

import java.util.List;

import com.computa.entity.Qna;
import com.computa.entity.QnaComment;
import com.computa.entity.User;

public interface QnaCommentService {
    QnaComment save(QnaComment comment, User user, Long qnaSeq, Long parentId);
    QnaComment save(QnaComment comment, User user, Long qnaSeq);
    List<QnaComment> findCommentByQna(Qna qna);
}
