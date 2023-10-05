package dev.ecommerce.productservice.services;

import dev.ecommerce.productservice.models.Category;
import dev.ecommerce.productservice.models.Product;
import dev.ecommerce.productservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategory(UUID uuid) {
        Optional<Category> categoryOptional = categoryRepository.findById(uuid);
        if(categoryOptional.isEmpty()){
            return null;
        }
        Category category = categoryOptional.get();
        List<Product> products = category.getProducts();
        return category;
    }
}
