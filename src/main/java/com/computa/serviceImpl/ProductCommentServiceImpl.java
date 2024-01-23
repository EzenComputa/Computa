package com.computa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computa.entity.ProductComment;
import com.computa.entity.User;
import com.computa.entity.pcparts.Product;
import com.computa.exceptions.ResourceNotFoundException;
import com.computa.persistence.ProductCommentRepository;
import com.computa.persistence.UserRepository;
import com.computa.persistence.pcparts.ProductRepository;
import com.computa.service.ProductCommentService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCommentServiceImpl implements ProductCommentService {

    @Autowired
    private ProductCommentRepository productCommentRepository;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ProductComment> getAllProductComments() {
        return productCommentRepository.findAll();
    }

    @Override
    public List<ProductComment> getProductCommentsByProductId(Long productId) {
        return productCommentRepository.findByProductId(productId);
    }

    @Override
    public ProductComment getProductCommentById(Long id) {
        Optional<ProductComment> optionalProductComment = productCommentRepository.findById(id);
        return optionalProductComment.orElse(null);
    }

    @Override
    public ProductComment saveProductComment(Long productId, Long userId, Long parentCommentId, String content) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        ProductComment parentComment = parentCommentId != null ? productCommentRepository.findById(parentCommentId).orElseThrow(() -> new RuntimeException("Parent comment not found")) : null;
        
        ProductComment productComment = new ProductComment();

        productComment.setUser(user);
        productComment.setProduct(product);
        productComment.setParent(parentComment);
        productComment.setContent(content);

        return productCommentRepository.save(productComment);
    }

    @Override
    public void deleteProductComment(Long id) {
        productCommentRepository.deleteById(id);
    }
}