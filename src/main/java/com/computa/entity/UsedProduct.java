// package com.computa.entity;

// import java.util.ArrayList;
// import java.util.List;
// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Inheritance;
// import jakarta.persistence.InheritanceType;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Temporal;
// import jakarta.persistence.TemporalType;
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
// import java.util.Date;

// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Entity
// @Inheritance(strategy = InheritanceType.JOINED)
// public abstract class UsedProduct {

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long id;

// @Column(name = "fullname")
// private String fullname;

// @Column(name = "product_state")
// private String used_product_Type;

// @Column(name = "product_state")
// private String product_state;

// private Integer price;

// private Integer view_count;

// @OneToMany(mappedBy = "used_product", cascade = CascadeType.ALL, fetch =
// FetchType.LAZY)
// private List<UsedProductImage> usedproductImages = new ArrayList<>();

// @Temporal(TemporalType.DATE)
// Date regDate;

// @Temporal(TemporalType.TIME)
// Date regTime;

// // 부품종류
// @Enumerated(EnumType.STRING)
// private Parts parts;

// // 판매현황
// @Enumerated(EnumType.STRING)
// private SalesStatus SalesStatus;

// }
