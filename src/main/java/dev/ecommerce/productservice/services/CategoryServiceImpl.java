package dev.ecommerce.productservice.services;

import dev.ecommerce.productservice.dtos.CategoryDto;
import dev.ecommerce.productservice.dtos.GenericProductDto;
import dev.ecommerce.productservice.dtos.ProductDto;
import dev.ecommerce.productservice.models.Category;
import dev.ecommerce.productservice.models.Price;
import dev.ecommerce.productservice.models.Product;
import dev.ecommerce.productservice.repositories.CategoryRepository;
import dev.ecommerce.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Category getCategory(UUID uuid) {

        Optional<Category> categoryOptional = categoryRepository.findById(uuid);
        if(categoryOptional.isEmpty()){
            return null;
        }
        Category category = categoryOptional.get();
//        List<Product> products = category.getProducts();
        return category;
    }

    public List<String> getProductTitles(List<UUID> categoryUUIDs){

        List<UUID> uuids = new ArrayList<>();

        for (UUID uuid: categoryUUIDs){
            uuids.add(uuid);
        }
//        List<Category> categories = categoryRepository.findAllById(uuids);
//
//        List<String> titles = new ArrayList<>();
//
//        categories.forEach(
//                category -> {
//                    category.getProducts().forEach(
//                            product -> {
//                                titles.add(product.getTitle());
//                            }
//                    );
//                }
//        );

        List<Category> categories = categoryRepository.findAllById(uuids);

        List<Product> products = productRepository.findAllByCategoryIn(categories);

        List<String> titles = new ArrayList<>();

        for(Product product : products){
            titles.add(product.getTitle());
        }
        return titles;
    }

    @Override
    public List<String> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();

        List<String> allCategories = new ArrayList<>();
        for(Category category : categories) {
            String name = category.getName();
            allCategories.add(name);
        }
        return allCategories;

//        List<CategoryDto> categoryDtos = new ArrayList<>();
//
//        for(Category category : categories){
//            CategoryDto categoryDto = new CategoryDto();
//
//            categoryDto.setName(category.getName());
//
//            List<ProductDto> productDtos = new ArrayList<>();
//
//            for(Product product : category.getProducts()){
//                ProductDto productDto = new ProductDto();
//                productDto.setPrice(product.getPrice());
//                productDto.setDescription(product.getDescription());
//                productDto.setTitle(product.getTitle());
//                productDto.setImage(product.getImage());
//                productDtos.add(productDto);
//            }
//            categoryDto.setProducts(productDtos);
//            categoryDtos.add(categoryDto);
//        }
//        return categoryDtos;
    }

    @Override
    public List<GenericProductDto> getAllProductsByCategory(String category) {
        Optional<Category> categoryOptional = categoryRepository.findByName(category);

        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        if(categoryOptional.isPresent()) {
            List<Product> products = categoryOptional.get().getProducts();
            for (Product product : products) {
                GenericProductDto genericProductDto  = new GenericProductDto();
                genericProductDto.setId(product.getUuid());
                genericProductDto.setImage(product.getImage());
                genericProductDto.setDescription(product.getDescription());
                genericProductDto.setTitle(product.getTitle());
                genericProductDto.setPrice(product.getPrice().getPrice());
                genericProductDto.setCategory(product.getCategory().getName());
                genericProductDtos.add(genericProductDto);
            }
        }
        return genericProductDtos;
    }
}
