package com.app.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entity.Qna;
import com.app.entity.QnaComment;
import com.app.entity.User;
import com.app.persistence.QnaCommentRepository;
import com.app.persistence.QnaRepository;
import com.app.service.QnaCommentService;

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

    @Override
    public List<QnaComment> getTopLevelComments(Qna qna) {
        return qnaCommentRepository.findByParentIsNullAndQnaOrderByCreatedDateAsc(qna);
    }

    @Override
    public List<QnaComment> getOrderedComments(Qna qna) {
        List<QnaComment> topLevelComments = getTopLevelComments(qna);
        List<QnaComment> orderedComments = new ArrayList<>();
        for (QnaComment comment : topLevelComments) {
            addCommentAndReplies(comment, orderedComments);
        }
        return orderedComments;
    }

    private void addCommentAndReplies(QnaComment comment, List<QnaComment> orderedComments) {
        orderedComments.add(comment);
        for (QnaComment reply : comment.getReplies()) {
            addCommentAndReplies(reply, orderedComments);
        }
    }
}