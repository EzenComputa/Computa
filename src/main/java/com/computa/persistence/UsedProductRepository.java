// package com.computa.persistence;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;

// import com.computa.entity.UsedProduct;

// public interface UsedProductRepository extends JpaRepository<UsedProduct,Long> {
//     @Modifying
//     @Query("update UsedProduct p set p.view = p.view + 1 where p.id =: id")
//     int update(Long id);
// }
