package dev.ecommerce.productservice.services;

import dev.ecommerce.productservice.dtos.GenericProductDto;
import dev.ecommerce.productservice.exceptions.NotFoundException;
import dev.ecommerce.productservice.models.Category;
import dev.ecommerce.productservice.models.Price;
import dev.ecommerce.productservice.models.Product;
import dev.ecommerce.productservice.repositories.ProductRepository;
import dev.ecommerce.productservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductDto;
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

    public SelfProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
    public GenericProductDto createProduct(GenericProductDto product){
        return null;
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
    public GenericProductDto updateProductByID(GenericProductDto genericProductDto, UUID id) {
        return null;
    }

}
