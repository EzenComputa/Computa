package com.computa.service;

import java.util.List;

import com.computa.entity.ProductComment;

public interface ProductCommentService {
    List<ProductComment> getAllProductComments();
    List<ProductComment> getProductCommentsByProductId(Long productId);
    ProductComment getProductCommentById(Long id);
    ProductComment saveProductComment(ProductComment productComment, String content, Long productId, Long userId, Long parentId);
    void deleteProductComment(Long id);
}