package com.example.demo.product.queryhandlers;

import com.example.demo.Query;
import com.example.demo.product.Model.Product;
import com.example.demo.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.Optional;

@Service
public class GetProductQueryHandler implements Query<Integer, Product> {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public ResponseEntity<Product> execute(Integer id ) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            //daj exetion
            throw new RuntimeException("Product not found");
        }
        return ResponseEntity.ok(product.get());

    }
}
