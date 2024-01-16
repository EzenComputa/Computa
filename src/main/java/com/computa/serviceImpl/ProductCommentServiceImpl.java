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
    public ProductComment saveProductComment(ProductComment productComment, String content, Long productId, Long userId, Long parentId) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        ProductComment parentComment = null;
        if (parentId != null) {
            parentComment = productCommentRepository.findById(parentId)
                .orElseThrow(() -> new ResourceNotFoundException("Parent comment not found"));
        }

        productComment.setContent(content);
        productComment.setProduct(product);
        productComment.setUser(user);
        productComment.setParent(parentComment);

        return productCommentRepository.save(productComment);
    }

    @Override
    public void deleteProductComment(Long id) {
        productCommentRepository.deleteById(id);
    }
}