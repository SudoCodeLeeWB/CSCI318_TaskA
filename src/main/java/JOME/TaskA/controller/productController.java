package JOME.TaskA.controller;

import JOME.TaskA.entity.Product;
import JOME.TaskA.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productController {

    // for productRepository
    private final ProductRepository productRepository;


    public productController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // get the id of a product and return a "Product"
    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable Long id){
        return productRepository.findById(id).orElseThrow(RuntimeException::new);

    }

    @GetMapping("/products")
    List<Product> getAllProducts(){
        return productRepository.findAll();

    }

    @PostMapping("/products")
    Product createProduct(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

}
