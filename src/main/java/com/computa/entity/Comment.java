package com.computa.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String content;
    
    @ManyToOne // Many comments can be written by one user
    @JoinColumn(name="user_id", referencedColumnName="ID", nullable=false)
    private User user;

    @ManyToOne 
    @JoinColumn(name="post_id", referencedColumnName="ID")
    private Post post;
    
    @ManyToOne
    @JoinColumn(name="parent_id", referencedColumnName="ID")
    private Comment parent;
    
    @OneToMany(mappedBy="parent", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Comment> replies = new ArrayList<>();

    @CreationTimestamp
    private Date createdDate;
    // other fields and methods...
}