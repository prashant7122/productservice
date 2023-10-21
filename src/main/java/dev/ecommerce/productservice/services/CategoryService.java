package dev.ecommerce.productservice.services;

import dev.ecommerce.productservice.dtos.CategoryDto;
import dev.ecommerce.productservice.dtos.GenericProductDto;
import dev.ecommerce.productservice.dtos.ProductDto;
import dev.ecommerce.productservice.models.Category;
import dev.ecommerce.productservice.models.Product;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    Category getCategory(UUID uuid);
    List<String> getProductTitles(List<UUID> categoryUUIDs);

    List<String> getAllCategories();

    List<GenericProductDto> getAllProductsByCategory(String category);

//    List<GenericProductDto> getAllProductsByCategory(String categoryName);

}
