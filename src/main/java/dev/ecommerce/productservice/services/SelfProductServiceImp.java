package dev.ecommerce.productservice.services;

import dev.ecommerce.productservice.dtos.GenericProductDto;
import dev.ecommerce.productservice.exceptions.NotFoundException;
import dev.ecommerce.productservice.models.Category;
import dev.ecommerce.productservice.models.Price;
import dev.ecommerce.productservice.models.Product;
import dev.ecommerce.productservice.repositories.CategoryRepository;
import dev.ecommerce.productservice.repositories.PriceRepository;
import dev.ecommerce.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service("selfProductServiceImp")
public class SelfProductServiceImp implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;

    public SelfProductServiceImp(ProductRepository productRepository, CategoryRepository categoryRepository,
                                 PriceRepository priceRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
    }

    private GenericProductDto convertProductIntoGenericProduct(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();
        UUID uuid = product.getUuid();
        genericProductDto.setId(uuid);
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setImage(product.getImage());
        genericProductDto.setCategory(product.getCategory().getName());
        genericProductDto.setPrice(product.getPrice().getPrice());
        return genericProductDto;
    }


    @Override
    public GenericProductDto getProductById(UUID id) {
        Optional<Product> product = Optional.ofNullable(productRepository.getProductByUuid(id));
        if(product.isEmpty()) return null;
        return convertProductIntoGenericProduct(product.get());

    }


    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto){
        Product product = new Product();

        product.setImage(genericProductDto.getImage());
        product.setPrice(new Price("INR", genericProductDto.getPrice()));
        product.setDescription(genericProductDto.getDescription());
        product.setTitle(genericProductDto.getTitle());

        Category category = new Category();
        category.setName(genericProductDto.getCategory());
        product.setCategory(category);

        productRepository.save(product);
        return convertProductIntoGenericProduct(product);
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (Product product: products.stream().toList()) {
            genericProductDtos.add(convertProductIntoGenericProduct(product));
        }
        return genericProductDtos;
    }


    @Override
    public GenericProductDto deleteProductById(UUID id) {
        productRepository.deleteById(id);
        return null;
    }

    @Override
    public GenericProductDto updateProductByID(GenericProductDto genericProductDto, UUID id) throws NotFoundException{
        Optional<Product> product = Optional.ofNullable(productRepository.getProductByUuid(id));
        if(product.isEmpty()) {
            throw new NotFoundException("Product not found");
        }
        Product updateProduct = product.get();

        updateProduct.setImage(genericProductDto.getImage());
        updateProduct.setPrice(new Price("INR", genericProductDto.getPrice()));
        updateProduct.setDescription(genericProductDto.getDescription());
        updateProduct.setTitle(genericProductDto.getTitle());

        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if(categoryOptional.isPresent()){
            updateProduct.setCategory(categoryOptional.get());
        }
        else {
            Category category = new Category();
            category.setName(genericProductDto.getCategory());
            updateProduct.setCategory(category);
        }

        productRepository.save(updateProduct);

        return convertProductIntoGenericProduct(updateProduct);
    }


}
