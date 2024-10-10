package com.example.demo.product.Commandhandlers;

import com.example.demo.Commend;
import com.example.demo.product.Model.Product;
import com.example.demo.product.ProductRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductCommandHandler implements Commend<Product, ResponseEntity> {


    @Autowired
    private ProductRepository productRepository;


    @Override
    public ResponseEntity execute(Product product) {

        validateProduct(product);

        productRepository.save(product);
        return ResponseEntity.ok().build();
    }
    private void validateProduct(Product product){

        if(StringUtils.isBlank(product.getName())){
            // throw exeption
            throw new RuntimeException("Product can't be empty");
        }

        if(StringUtils.isBlank(product.getDescription())){
            throw new RuntimeException("Description can't be empty");
        }

        if(product.getPrice() <= 0.0){
            //throw
            throw new RuntimeException("Price can't be negetive");
        }

        if(product.getQuantity() <= 0){
            //throw
            throw new RuntimeException("Quantity can't be negetive");
        }

    }
}
