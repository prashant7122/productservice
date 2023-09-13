package dev.ecommerce.productservice.services;

import dev.ecommerce.productservice.dtos.GenericProductDto;
import dev.ecommerce.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProdcutById(Long id) throws NotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProductById(Long id);

    GenericProductDto updateProductByID(GenericProductDto genericProductDto, Long id);

}
