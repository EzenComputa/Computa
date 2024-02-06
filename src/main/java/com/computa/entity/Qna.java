package com.computa.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;


// 1. 각 페이지마다 등록된 데이터(여기서는 게시글)가 있으므로 Entity 객체를 만들어 DB에 등록한다. 


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Qnalist")
public class Qna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // primaray 글 번호 id
    private Long seq;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 날짜 형식 지정
    @Column(insertable = false, updatable = false, columnDefinition = "date default now()")
    private Date createDate;

    @Column(insertable = false, updatable = false, columnDefinition = "bigint default 0")	
	private Long cnt;


    private String fileName;


    
    @Transient
	private MultipartFile uploadFile;
	
	// @Column(columnDefinition = "integer default 0", nullable = true)
	private Long qna_ref;
	
	// @Column(columnDefinition = "integer default 0", nullable = true)
	private Long qna_lev;
	
	// @Column(columnDefinition = "integer default 0", nullable = true)
	private Long qna_seq;





    // @ManyToOne // One user can have many question posts
    // @JoinColumn(name = "user_id", referencedColumnName = "ID", nullable = false)
    // private User user;


    // @JoinColumn(name="user_nickname", referencedColumnName="ID", nullable=false)
    // private User nickname;

    @OneToMany(mappedBy = "qna", cascade = CascadeType.ALL)
    private List<QnaComment> comments = new ArrayList<>();

}
