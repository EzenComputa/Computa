package com.computa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@Table(name="QnaList")
public class QnaList{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // primaray 글 번호 id
    private Long id;

    // 질문
    // 공지사항은 entity로 어떻게 작성을 하는 지

    @Column(nullable=false, unique=true)
    private String title;

    @JoinColumn(name="user_nickname", referencedColumnName="ID", nullable=false)
    private User nickname;

    @Column(nullable=false)
    private String Date;

    @Column(nullable = false)
    private int View;


    // 보류 JoinTable
    // @JoinTable(
    //         name="users_roles",
    //         joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
    //         inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    // private List<Role> roles = new ArrayList<>();

}
