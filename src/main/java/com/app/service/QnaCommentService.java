package com.app.service;

import java.util.List;

import com.app.entity.Qna;
import com.app.entity.QnaComment;
import com.app.entity.User;

public interface QnaCommentService {
    QnaComment save(QnaComment comment, User user, Long qnaSeq, Long parentId);
    QnaComment save(QnaComment comment, User user, Long qnaSeq);
    List<QnaComment> findCommentByQna(Qna qna);
    List<QnaComment> getTopLevelComments(Qna qna);
    List<QnaComment> getOrderedComments(Qna qna);    
}
