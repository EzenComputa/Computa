package com.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.dto.UserDto;
import com.app.entity.Qna;
import com.app.persistence.QnaRepository;




public interface QnaService {
    long getTotalRowCount(Qna qna);
    Qna getQnaBoard(Qna qna);
    Page<Qna> getQnalist(Pageable pageable, String searchType, String searchWord);
    void insertQna(Qna qna);
    void updateQna(Qna qna);
    void deleteQna(Qna qna);
    int updateReadCount(Qna qna);
    String getWriter(Qna qna);
    
} 

