package dev.ecommerce.productservice;

import dev.ecommerce.productservice.models.Category;
import dev.ecommerce.productservice.models.Price;
import dev.ecommerce.productservice.models.Product;
import dev.ecommerce.productservice.repositories.CategoryRepository;
import dev.ecommerce.productservice.repositories.PriceRepository;
import dev.ecommerce.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductserviceApplication{ //implements CommandLineRunner {

//    private final ProductRepository productRepository;
//    private final CategoryRepository categoryRepository;
//    private final PriceRepository priceRepository;
//
//    public ProductserviceApplication
//            (ProductRepository productRepository,
//             CategoryRepository categoryRepository,
//             PriceRepository priceRepository) {
//        this.productRepository = productRepository;
//        this.categoryRepository = categoryRepository;
//        this.priceRepository = priceRepository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
    }

//    @Transactional
//    @Override
//    public void run(String... args) throws Exception {
//        Category category = new Category();
//        category.setName("Apple Devices");
////        Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price("Rupee", 10.0);
////        Price savedPrice = priceRepository.save(price);
//
//        Product product = new Product();
//        product.setTitle("iPhone 15 Pro");
//        product.setDescription("The best iPhone Ever");
//        product.setCategory(category);
//        product.setPrice(price);
//
//        productRepository.save(product);
//
////        productRepository.deleteById(UUID.fromString("4f40761b-ebf4-480b-af07-0b36fb005788"));
//
//        List<Product> products = productRepository.findAllByPrice_Currency("Rupee");
//
//        Long count = productRepository.countAllByPrice_Currency("Rupee");
//
////        productRepository.delete(product);
//
//        List<Product> products1 = productRepository.findAllByTitle("iPhone 15 Pro");
////        System.out.println(products1);
////
////        System.out.println(count);
//        System.out.println("Fetching Category for : 04795456-f30e-4796-9717-fca8f76f63e1");
//        Thread.sleep(1000);
//
//        Optional<Category> category1Optional = categoryRepository.findById(UUID.fromString("07af12f5-7eb7-4b23-ab39-2f8966325248"));
//        Category category1 = category1Optional.get();
//        System.out.println(category1);
//
//
//        System.out.println("Fetching product for the category");
//        Thread.sleep(1000);
//        List<Product> products11 = category1.getProducts();
//
//
////       List<Product> products2= productRepository.realAllByTitle("iPhone 15 Pro","Rupee");
////        System.out.println(products2);
//
//    }


}
