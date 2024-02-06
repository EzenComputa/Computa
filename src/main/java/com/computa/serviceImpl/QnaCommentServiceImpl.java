package com.computa.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.computa.entity.Qna;
import com.computa.entity.QnaComment;
import com.computa.entity.User;
import com.computa.persistence.QnaCommentRepository;
import com.computa.persistence.QnaRepository;
import com.computa.service.QnaCommentService;

@Service
public class QnaCommentServiceImpl implements QnaCommentService {
    private final QnaCommentRepository qnaCommentRepository;
    private final QnaRepository qnaRepository;

    public QnaCommentServiceImpl(QnaCommentRepository qnaCommentRepository, QnaRepository qnaRepository) {
        this.qnaCommentRepository = qnaCommentRepository;
        this.qnaRepository = qnaRepository;
    }

    @Override
    public QnaComment save(QnaComment comment, User user, Long qnaSeq, Long parentId) {
        Qna qna = qnaRepository.findById(qnaSeq).orElseThrow(() -> new IllegalArgumentException("Qna not found"));
        comment.setQna(qna);
        comment.setUser(user);
        if (parentId != null) {
            QnaComment parent = qnaCommentRepository.findById(parentId).orElse(null);
            if (parent != null) {
                comment.setLevel(parent.getLevel() + 1);
                comment.setParent(parent);
            }
        } else {
            comment.setLevel(0);
        }
        return qnaCommentRepository.save(comment);
    }

    @Override
    public QnaComment save(QnaComment comment, User user, Long qnaSeq) {
        Qna qna = qnaRepository.findById(qnaSeq).orElseThrow(() -> new IllegalArgumentException("Qna not found"));
        comment.setQna(qna);
        comment.setUser(user);
        comment.setLevel(0);
        return qnaCommentRepository.save(comment);
    }


    @Override
    public List<QnaComment> findCommentByQna(Qna qna) {
        return qnaCommentRepository.findCommentByQna(qna);
    }
}