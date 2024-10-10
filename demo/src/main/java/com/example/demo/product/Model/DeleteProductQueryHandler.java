package com.example.demo.product.Model;

import com.example.demo.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class DeleteProductQueryHandler {
    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.delete(productOptional.get());
            System.out.println("Product deleted. Product at id of " + id);
            return ResponseEntity.ok().build();
        } else {
            System.out.println("Product not found. Product at id of " + id);
            return ResponseEntity.notFound().build();
        }
    }
}
