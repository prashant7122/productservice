package dev.ecommerce.productservice.controllers;

import dev.ecommerce.productservice.dtos.GenericProductDto;
import dev.ecommerce.productservice.exceptions.NotFoundException;
import dev.ecommerce.productservice.repositories.ProductRepository;
import dev.ecommerce.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    //Field Injection
    //@Autowired
    private ProductService productService;
    private ProductRepository productRepository;

    // Constructor Injection
    public ProductController(ProductService productService, ProductRepository productRepository){
        this.productService = productService;
        this.productRepository = productRepository;
    }

    // Setter Injection
    //@Autowired
//    public void setProductService(ProductService productService){
//        this.productService = productService;
//    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    // localhost:8080/products/{id}
    // localhost:8080/products/123
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") UUID id) throws NotFoundException {
        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") UUID id){
        ResponseEntity<GenericProductDto> response = new ResponseEntity<>(
                productService.deleteProductById(id),
                HttpStatus.OK
        );
        return response;
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public GenericProductDto updateProductByID(@RequestBody GenericProductDto genericProductDto, @PathVariable("id") UUID id){
        return productService.updateProductByID(genericProductDto, id);
    }
}
