package com.computa.serviceImpl;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.computa.entity.Qna;
import com.computa.persistence.QnaRepository;
import com.computa.service.QnaService;

import jakarta.transaction.Transactional;

@Service
public class QnaServiceImpl implements QnaService{

    @Autowired
    private QnaRepository qnaRepo;

    @Override
    public long getTotalRowCount(Qna qna) {
        return qnaRepo.count();
    }

    @Override
    public Qna getQnaBoard(Qna qna) {
        Optional<Qna> findQna = qnaRepo.findById(qna.getSeq());

        if(findQna.isPresent()) {
            return findQna.get();
        } else {
            return null;
        }
    }

    @Override
    public Page<Qna> getQnalist(Pageable pageable, String searchType, String searchWord){
        if(searchType.equalsIgnoreCase("title")) {
            return qnaRepo.findByTitleContaining(searchWord, pageable);
        } else if(searchType. equalsIgnoreCase("writer")) {
            return qnaRepo.findByWriterContaining(searchWord, pageable);
        } else {
            return qnaRepo.findByContentContaining(searchWord, pageable);
        }
    }

    @Override
    public void insertQna(Qna qna) {
        qnaRepo.save(qna);
        qnaRepo.updateLastSeq(0L, 0L, qna.getSeq());
    }

    @Override
    public void updateQna(Qna qna) {
        Qna findQna = qnaRepo.findById(qna.getSeq()).get();
        findQna.setTitle(qna.getTitle());
        findQna.setContent(qna.getContent());
        qnaRepo.save(findQna);
    }
    
    
    @Override
	public void deleteQna(Qna qna) {
		qnaRepo.deleteById(qna.getSeq());	
	}




    // 작성자닉네임 가져오기
    @Override
    public String getWriter(Qna qna){
        // findById를 사용하여 qnaRepo에서 qna의 seq(시퀀스)에 해당하는 게시물을 찾음.
        Optional<Qna> findQna = qnaRepo.findById(qna.getSeq());

        // 만약 게시물이 존재하면
        if(findQna.isPresent()){
            // 해당 게시글의 작성자 이름을 반환
            return findQna.get().getWriter();
        }else{
            // 게시글이 존재하지 않으면 null을 반환
            return null;
        }
    }
    
    @Override
    public int updateReadCount(Qna qna) {
        return qnaRepo.updateReadCount(qna.getSeq());
    }
    
}
