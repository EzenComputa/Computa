// package com.computa.entity;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Entity
// @Getter
// @Setter
// @AllArgsConstructor
// @NoArgsConstructor
// @Table(name = "used_product_images")
// public class UsedProductImage {

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long id;

// @Column(name = "url")
// private String url;

// @ManyToOne(fetch = FetchType.LAZY)
// @JoinColumn(name = "used_product_id", referencedColumnName = "ID")
// private UsedProduct usedProduct;
// }
