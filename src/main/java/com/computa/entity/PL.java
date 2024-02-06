// package com.computa.entity;

// import org.springframework.data.jpa.domain.support.AuditingEntityListener;
// import org.springframework.format.annotation.DateTimeFormat;
// import org.springframework.web.multipart.MultipartFile;

// import jakarta.persistence.*;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;
// import java.util.ListIterator;


// @Entity
// @Getter
// @Setter
// @AllArgsConstructor
// @NoArgsConstructor
// @Table(name = "ProductList")
// public class PL {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY) // primaray 글 번호 id
//     private Long seq;

//     @Column(nullable = false)
//     private String title;

//     @Column(nullable = false)
//     private String price;

//     @Column(nullable = false)
//     private String content;

//     @Column(insertable = false, updatable = false, columnDefinition = "bigint default 0")	
// 	private Long cnt;

//     @OneToMany(mappedBy = "qna", cascade = CascadeType.ALL)
//     private List<QnaComment> comments = new ArrayList<>();
    
// }
