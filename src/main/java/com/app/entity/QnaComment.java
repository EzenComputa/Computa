package com.app.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class QnaComment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Many QnaComment to One User
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne // Qna's primary key is Long sec 
    @JoinColumn(name = "seq", nullable = false)
    private Qna qna;

    @Column
    private Integer level;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private QnaComment parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<QnaComment> replies = new ArrayList<>();

    private String content;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;
}