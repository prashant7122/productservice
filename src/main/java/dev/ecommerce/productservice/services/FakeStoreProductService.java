package dev.ecommerce.productservice.services;

import dev.ecommerce.productservice.dtos.GenericProductDto;
import dev.ecommerce.productservice.exceptions.NotFoundException;
import dev.ecommerce.productservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductDto;
import dev.ecommerce.productservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;


    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto) {

        GenericProductDto product = new GenericProductDto();
//        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product){
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }
    @Override
    public GenericProductDto getProductById(UUID id) throws NotFoundException {
       return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto: fakeStoreProductServiceClient.getAllProducts()) {
            genericProductDtos.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

//    @Override
//    public List<GenericProductDto> getAllProductsByCategory(String category) {
//        return null;
//    }

    @Override
    public GenericProductDto deleteProductById(UUID id) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.deleteProductById(id));
    }

    @Override
    public GenericProductDto updateProductByID(GenericProductDto genericProductDto, UUID id) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.updateProductByID(genericProductDto, id));
    }

}
