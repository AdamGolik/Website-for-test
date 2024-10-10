package com.example.demo.product.Commandhandlers;

import com.example.demo.Commend;
import com.example.demo.product.Model.Product;
import com.example.demo.product.Model.UpdateProductCommand;
import com.example.demo.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductCommandHandler implements Commend<UpdateProductCommand, ResponseEntity> {

@Autowired
private ProductRepository productRepository;

    @Override
    public ResponseEntity<ResponseEntity> execute(UpdateProductCommand command) {
        Product product =  command.getProduct();
        product.setId(command.getId());
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }
}
