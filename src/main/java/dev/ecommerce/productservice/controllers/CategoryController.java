package dev.ecommerce.productservice.controllers;

import dev.ecommerce.productservice.dtos.ProductDto;
import dev.ecommerce.productservice.models.Category;
import dev.ecommerce.productservice.models.Product;
import dev.ecommerce.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping ("{uuid}")
    public List<ProductDto> getCategory(@PathVariable("uuid") UUID uuid){
        List<Product> products = categoryService.getCategory(uuid).getProducts();
        List<ProductDto> productDtos = new ArrayList<>();

        for(Product product : products){
            ProductDto productDto = new ProductDto();
            productDto.setTitle(product.getTitle());
            productDto.setDescription(product.getDescription());
            productDto.setImage(product.getImage());
            productDto.setPrice(product.getPrice());
            productDtos.add(productDto);
        }

        return productDtos;
    }
}
