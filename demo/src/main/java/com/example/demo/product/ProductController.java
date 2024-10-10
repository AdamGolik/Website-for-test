package com.example.demo.product;

import com.example.demo.product.Commandhandlers.CreateProductCommandHandler;
import com.example.demo.product.Commandhandlers.UpdateProductCommandHandler;
import com.example.demo.product.Model.Product;
import com.example.demo.product.queryhandlers.GetAllProductsQueryHandler;
import com.example.demo.product.Model.UpdateProductCommand;
import com.example.demo.product.queryhandlers.GetProductQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // Zezwalanie na CORS tylko z tej domeny
@RestController
@RequestMapping("/products")
public class ProductController {

    //Create , Read, Update,Delete
    //Post,    Get,  Put,   Delete


@Autowired
private UpdateProductCommandHandler updateProductCommandHandler;
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GetAllProductsQueryHandler getAllProductsQueryHandler;

    @Autowired
    private GetProductQueryHandler getProductQueryHandler;

    @Autowired
    private CreateProductCommandHandler createProductCommandHandler;
// dostanie co jest w  produktach
@GetMapping
    public ResponseEntity<List<Product>> getProducts(){
    System.out.println("product get visible");
    return getAllProductsQueryHandler.execute(null);
}


// wpisanie products/id i dostanie tego tylko id i produktów
@GetMapping("/{id}")
    public ResponseEntity<Product>getProduct(@PathVariable Integer id){
    System.out.println("product get visible");
      return getProductQueryHandler.execute(id);
}


//wysłanie dodanie do mysql nowego produtku
@PostMapping
public ResponseEntity createProduct(@RequestBody Product product){
    System.out.println("product get visible");
    return createProductCommandHandler.execute(product);
}


    //Update produktów
    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        UpdateProductCommand updateProductCommand = new UpdateProductCommand(id, product);
        return updateProductCommandHandler.execute(updateProductCommand);
    }


//detale//details end



//Delete
@DeleteMapping("/{id}")
public ResponseEntity deleteProduct(@PathVariable Integer id){
    System.out.println("Product deleted" + "Product at id of " + id);
    Product product = productRepository.findById(id).get();
productRepository.delete(product);
    return ResponseEntity.ok().build();
}


}
