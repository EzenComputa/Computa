package com.computa.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
// import org.springframework.transaction.annotation.Transactional;

import com.computa.entity.Qna;
import com.computa.entity.User;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


public interface QnaRepository extends JpaRepository<Qna, Long> {


    @Modifying    // @Query의 sql이 insert/delete/update
    @Transactional   // commit, rollback
    @Query("update Qna q set q.cnt = q.cnt + 1 where q.seq = :seq")
    int updateReadCount(@Param("seq") Long seq);


    List<Qna> findByWriter(String writer);


    @Modifying
    @Transactional
    @Query("update Qna q set q.qna_ref = q.seq, q.qna_lev=:lev, q.qna_seq=:_seq where q.seq = :seq")
    void updateLastSeq(@Param("lev") Long i, @Param("_seq") Long j, @Param("seq") Long seq);

    Page<Qna> findByTitleContaining(String title, Pageable pageable);
    Page<Qna> findByWriterContaining(String writer, Pageable pageable);
    Page<Qna> findByContentContaining(String content, Pageable pageable);

    
}
