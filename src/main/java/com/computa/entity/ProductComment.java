package com.computa.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.computa.entity.pcparts.Product;

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
@Table(name="product_comments")
public class ProductComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String content;
    
    @ManyToOne // Many comments can be written by one user
    @JoinColumn(name="user_id", referencedColumnName="ID", nullable=false)
    private User user;

    @ManyToOne 
    @JoinColumn(name="product_id", referencedColumnName="ID")
    private Product product;
    
    @ManyToOne
    @JoinColumn(name="parent_id", referencedColumnName="ID")
    private ProductComment parent;
    
    @OneToMany(mappedBy="parent", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<ProductComment> replies = new ArrayList<>();

    @CreationTimestamp
    private Date createdDate;

    @OneToMany(mappedBy="productComment", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<ProductCommentImage> productCommentImages = new ArrayList<>();
}
