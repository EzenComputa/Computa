package com.computa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="qna_list")
public class QnaList{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // primaray 글 번호 id
    private Long id;

    @ManyToOne // One user can have many question posts
    @JoinColumn(name="user_id", referencedColumnName="ID", nullable=false)
    private User user;


    @Column(nullable=false, unique=true)
    private String title;

    @JoinColumn(name="user_nickname", referencedColumnName="ID", nullable=false)
    private User nickname;

    @Column(nullable=false)
    private String Date;

    @Column(nullable = false)
    private int View;


}
