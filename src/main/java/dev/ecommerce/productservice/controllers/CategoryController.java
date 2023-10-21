package dev.ecommerce.productservice.controllers;

import dev.ecommerce.productservice.dtos.CategoryDto;
import dev.ecommerce.productservice.dtos.GenericProductDto;
import dev.ecommerce.productservice.dtos.GetProductTitlesRequestDto;
import dev.ecommerce.productservice.dtos.ProductDto;
import dev.ecommerce.productservice.models.Category;
import dev.ecommerce.productservice.models.Product;
import dev.ecommerce.productservice.services.CategoryService;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/titles/")
    public List<String> getProductTitles(@RequestBody GetProductTitlesRequestDto requestDto){
        List<UUID> uuids = requestDto.getUuids();
        return categoryService.getProductTitles(uuids);
    }

    @GetMapping
    public List<String> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/name/{categoryName}")
    public List<GenericProductDto> getAllProductsByCategory(@PathVariable("categoryName") String categoryName){
        return categoryService.getAllProductsByCategory(categoryName);
    }


}
