package com.app.persistence;
// package com.computa.persistence;

// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import com.computa.entity.PL;

// import jakarta.transaction.Transactional;

// public interface PLRepository extends JpaRepository <PL, Long>{

//     @Modifying    // @Query의 sql이 insert/delete/update
//     @Transactional   // commit, rollback
//     @Query("update PL p set p.cnt = p.cnt + 1 where q.seq = :seq")
//     int updateReadCount(@Param("seq") Long seq);
//     List<PL> findall();
// }