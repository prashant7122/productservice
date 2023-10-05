package dev.ecommerce.productservice.repositories;

import dev.ecommerce.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository
extends JpaRepository<Product, UUID> {

    Product getProductByUuid(UUID uuid);

    List<Product> findAll();

    Product findByTitleEquals(String title);
    Product findByTitleEqualsAndPrice_Price(String title, double price);
    List<Product> findAllByPrice_Currency(String currency);

    void deleteById(UUID id);

    Long countAllByPrice_Currency(String currency);

    @Query(value = CustomQueries.FIND_ALL_BY_TITLE,
            nativeQuery = true)
    List<Product> findAllByTitle(String title);

    //Hibernate Query Language -> Compile time safety
//    @Query("select Product from  Product where Product.price.currency = :currency and Product.title = :title")
//    List<Product> readAllByTitle(String title, String currency);
}
