package dev.ecommerce.productservice.services;

import dev.ecommerce.productservice.dtos.GenericProductDto;
import dev.ecommerce.productservice.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(UUID id) throws NotFoundException;

    List<GenericProductDto> getAllProducts();

//    List<GenericProductDto> getAllProductsByCategory(String category);

    GenericProductDto deleteProductById(UUID id);

    GenericProductDto updateProductByID(GenericProductDto genericProductDto, UUID id) throws NotFoundException;

}
